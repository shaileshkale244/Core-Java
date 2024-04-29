package utils;

import static core.Vehicle.getCount;
import static utils.VehicleValidationRule.checkColor;
import static utils.VehicleValidationRule.checkInsuranceExpDate;
import static utils.VehicleValidationRule.checkManufacturingDate;
import static utils.VehicleValidationRule.checkPollutionLevel;
import static utils.VehicleValidationRule.isChasisNoUnique;

import java.text.ParseException;

import java.time.LocalDate;

import java.util.Scanner;

import core.Color;
import core.Vehicle;
import custom_exception.ColorNotSupportedException;
import custom_exception.DuplicateChasisNumberException;
import custom_exception.InsuranceExpiryDateException;
import custom_exception.ManufactureDateException;
import custom_exception.PollutionLevelException;

public class VehicleUtility {

	@SuppressWarnings("resource")
	public static Vehicle addVehicle(Vehicle[] arr) throws ColorNotSupportedException, ParseException,
			InsuranceExpiryDateException, ManufactureDateException, DuplicateChasisNumberException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Chasis no:");
		String chasisno = isChasisNoUnique(arr, sc.next());

		System.out.println("Enter Color(WHITE , SILVER , BLACK , RED , BLUE):");
		Color clr = checkColor(sc.next().toUpperCase());

		System.out.println("Enter price:");
		double price = sc.nextDouble();

		System.out.println("Enter manufacturing date(yyyy-MM-dd):");

		LocalDate manufactureDate = checkManufacturingDate(LocalDate.parse(sc.next()));

		System.out.println("Enter insurance expiry date(yyyy-MM-dd):");

		LocalDate insuranceExpDate = checkInsuranceExpDate(manufactureDate, LocalDate.parse(sc.next()));
		return new Vehicle(chasisno, clr, price, manufactureDate, insuranceExpDate);
	}

	@SuppressWarnings("resource")
	public static void drive(Vehicle[] arr) throws PollutionLevelException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vehicle chasis number:");
		String chasisNo = sc.next();
		for (int i = 0; i < getCount(); i++) {
			if (arr[i].getChasisNo().equals(chasisNo)) {
				System.out.println("Enter Distance Travelled in Km:");
				int km = sc.nextInt();
				arr[i].setPollutionLevel(km += (km * 0.01));
				checkPollutionLevel(arr[i]);

			} else {
				System.out.println("Invalid chasis number!!");
			}
		}
	}

	public static void displayAllVehicles(Vehicle[] arr) {
		for (Vehicle v : arr) {
			if (v != null)
				System.out.println(v);
		}
	}

}
