package com.greatlearning;

import java.util.Scanner;

import com.greatlearning.model.Company;
import com.greatlearning.service.BinarySearch;
import com.greatlearning.service.MergeSortImplementation;

public class Driver {

	public static void main(String[] args) {

		MergeSortImplementation mergeSortImplementation = new MergeSortImplementation();

		System.out.println("Enter the no of companies");

		try (Scanner sc = new Scanner(System.in)) {
			int numberOfCompanies = sc.nextInt();
			Company[] companies = new Company[numberOfCompanies];

			for (int i = 0; i < numberOfCompanies; i++) {
				Company company = new Company();
				System.out.println("Enter current stock price of the company " + (i + 1));
				company.setStockPrice(sc.nextDouble());
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				company.setStockRisen(sc.nextBoolean());
				companies[i] = company;
			}

			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("-----------------------------------------------");

			mergeSortImplementation.sort(companies, 0, numberOfCompanies - 1);
			while (true) {
				switch (sc.nextInt()) {

				case 1:
					System.out.println("Stock prices in ascending order are :");
					for (int company = companies.length - 1; company >= 0; company--) {
						System.out.print(companies[company].getStockPrice() + " ");
					}
					System.out.println();
					break;
				case 2:
					System.out.println("Stock prices in descending order are :");
					for (Company company : companies) {
						System.out.print(company.getStockPrice()+ " ");
					}
					System.out.println();
					break;
				case 3:
					int count = 0;
					for (Company company : companies) {
						if (company.isStockRisen()) {
							count++;
						}
					}
					System.out.println("Total no of companies whose stock price rose today : " + count);
					break;
				case 4:
					int counter = 0;
					for (Company company : companies) {
						if (!company.isStockRisen()) {
							counter++;
						}
					}
					System.out.println("Total no of companies whose stock price declined today : " + counter);
					break;
				case 5:
					System.out.println("enter the key value");
					double value = sc.nextDouble();
					BinarySearch search = new BinarySearch();
					
					if (-1 == search.binarySearch(companies, 0, companies.length - 1, value)) {
						System.out.println("Stock of value " + value + " is not present");
					} else {
						System.out.println("Stock of value " + value + " is present");
					}
					break;
				case 0:
					System.out.println("Exited Successfully");
					System.exit(0);
				default:
					System.out.println("Incorrect value entered. Please enter values from 1-6");
				}
			}
		}
	}

}
