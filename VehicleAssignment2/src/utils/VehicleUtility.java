package utils;

import static utils.VehicleValidationRule.checkColor;
import static utils.VehicleValidationRule.checkPollutionLevel;

import java.util.Scanner;

import core.Color;
import core.Vehicle;
import exception.ColorNotSupportedException;
import exception.PollutionLevelException;

public class VehicleUtility {
	
	public static Vehicle addVehicle(Vehicle[] arr)throws ColorNotSupportedException {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Chasis no:");
			String chasisno=sc.next();
			System.out.println("Enter Color:");
			Color clr= checkColor(sc.next().toUpperCase());
			System.out.println("Enter price:");
			double price = sc.nextDouble();
			System.out.println("Enter manufacturing date:");
			String manaufacture=sc.next();
			System.out.println("Enter insurance expiry date:");
			String insurance=sc.next();
			
			return new Vehicle(chasisno,clr,price,manaufacture,insurance);
		
	}
	
	public static void drive(Vehicle arr,int km) throws PollutionLevelException {
		arr.setPollutionLevel(km*0.1);
		checkPollutionLevel(arr);
		
	}

}
