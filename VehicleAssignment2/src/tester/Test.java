package tester;

import static core.Vehicle.getCount;
import static utils.VehicleUtility.*;
import java.util.Scanner;
import core.Vehicle;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vehicle[] arr = new Vehicle[5];

		try {
			boolean exit = false;

			while (!exit) {
				System.out.println("--: Vehicle Management System :--");
				System.out.println("1.Add new vehicle  2.Drive vehicle 3.Display all Vehicles 4.Exit");
				System.out.println("Enter choice");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					arr[getCount()] = addVehicle(arr);
					break;
				case 2:					
					drive(arr);
					break;
				case 3:
					displayAllVehicles(arr);
					break;
				case 4:
					exit = true;
					break;
				default:
					System.out.println("Invalid Choice!!");
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
