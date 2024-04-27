package utils;

import static utils.VehicleValidationRule.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import core.Color;
import core.Vehicle;
import static core.Vehicle.getCount;
import custom_exception.*;

public class VehicleUtility {

	public static Vehicle addVehicle(Vehicle[] arr) throws ColorNotSupportedException, ParseException,
			InsuranceExpiryDateException, ManufactureDateException, DuplicateChasisNumberException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Chasis no:");
		String chasisno = isChasisNoUnique(arr, sc.next());
		System.out.println("Enter Color(WHITE , SILVER , BLACK , RED , BLUE):");
		Color clr = checkColor(sc.next().toUpperCase());
		System.out.println("Enter price:");
		double price = sc.nextDouble();
		System.out.println("Enter manufacturing date(yyyy-MM-dd):");
		String dateInput = sc.next();
		Date manufactureDate = checkManufacturingDate(dateConvert(dateInput));
		System.out.println("Enter insurance expiry date(yyyy-MM-dd):");
		dateInput = sc.next();
		Date insuranceExpDate = checkInsuranceExpDate(manufactureDate, dateConvert(dateInput));
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

			}

		}
	}

	private static Date dateConvert(String dateInput) throws ParseException {
		// Define the date format expected from the user
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Parse the date string into a Date object
		Date date = dateFormat.parse(dateInput);
		return date;
	}

	public static void displayAllVehicles(Vehicle[] arr) {
		for (Vehicle v : arr) {
			if (v != null)
				System.out.println(v);
		}
	}

}
