package tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestDate {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the date (YYYY-MM-DD): ");
			String dateInput = scanner.nextLine();

			// Define the date format expected from the user
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				// Parse the date string into a Date object
				Date date = dateFormat.parse(dateInput);

				// Print the parsed date
				System.out.println("Parsed Date: " + date);
			} catch (ParseException e) {
				System.out.println("Error parsing the date: " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
