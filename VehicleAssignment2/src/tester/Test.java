package tester;

import static core.Vehicle.getCount;
import static utils.VehicleUtility.addVehicle;
import static utils.VehicleUtility.drive;

import java.util.Scanner;

import javax.print.attribute.standard.PrinterStateReason;

import core.Vehicle;
import exception.ColorNotSupportedException;
import exception.PollutionLevelException;

public class Test {
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			Vehicle[] arr = new Vehicle[5];

			try{
				boolean exit = false;

			while (!exit) {
				System.out.println("1.Add new vehicle  2.Drive vehicle");
				System.out.println("Enter choice");				
				int choice = in.nextInt();
				switch (choice) {
				case 1:
					arr[getCount()] = addVehicle(arr);
					System.out.println(arr[getCount() - 1]);
					break;
				case 2:
					System.out.println("Enter km");
					drive(arr[getCount() - 1], in.nextInt());
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("invalid");
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
}
