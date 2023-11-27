package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	private FoodTruck[] fleet = new FoodTruck[5];
	private int truckCount = 0;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < fleet.length; i++) {
			System.out.print("Enter the name of the food truck (type 'quit' to stop): ");
			String name = scanner.nextLine();

			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.print("Enter the food type: ");
			String foodType = scanner.nextLine();

			System.out.print("Enter the rating: ");
			int rating = scanner.nextInt();
			scanner.nextLine();

			fleet[truckCount++] = new FoodTruck(name, foodType, rating);
		}

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. List all food trucks");
			System.out.println("2. Display average rating");
			System.out.println("3. Display highest-rated food truck");
			System.out.println("4. Quit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				listAllTrucks();
				break;
			case 2:
				displayAverageRating();
				break;
			case 3:
				displayHighestRatedTruck();
				break;
			case 4:
				System.out.println("Exiting the program. Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private void listAllTrucks() {
		System.out.println("\nList of all food trucks:");
		for (int i = 0; i < truckCount; i++) {
			System.out.println(fleet[i].toString());
		}
	}

	private void displayAverageRating() {
		int totalRating = 0;

		for (int i = 0; i < truckCount; i++) {
			totalRating += fleet[i].getRating();
		}

		double averageRating = (double) totalRating / truckCount;
		System.out.println("\nAverage rating: " + averageRating);
	}

	private void displayHighestRatedTruck() {
		if (truckCount == 0) {
			System.out.println("No trucks available to display.");
			return;
		}

		FoodTruck highestRatedTruck = fleet[0];

		for (int i = 1; i < truckCount; i++) {
			if (fleet[i].getRating() > highestRatedTruck.getRating()) {
				highestRatedTruck = fleet[i];
			}
		}

		System.out.println("\nHighest-rated food truck:\n" + highestRatedTruck.toString());
	}
}
