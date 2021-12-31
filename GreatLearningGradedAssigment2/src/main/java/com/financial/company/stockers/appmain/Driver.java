package com.financial.company.stockers.appmain;

import java.util.Scanner;
import java.util.TreeMap;

import com.financial.company.stockers.service.OperationsService;

public class Driver {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		OperationsService service = new OperationsService();

		System.out.println("Enter the number of companies");
		int n = sc.nextInt();
		int input = 0;

		TreeMap<Integer, Double> map = new TreeMap<>();

		int trueCount = 0;
		int falseCount = 0;

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter current stock price of the company " + i);
			double price = sc.nextDouble();
			map.put(i, price);
			System.out.println("Whether company's stock price rose today compare to yesterday?");

			String rise = sc.next();
			if (rise.equalsIgnoreCase("true")) {
				trueCount++;
			} else if (rise.equalsIgnoreCase("false")) {
				falseCount++;
			}

		}

		do {

			System.out.println("---------------------------------------------------------------------");

			System.out.println("Enter the operation that you want to perform\n"

					+ "1. Display the companies stock prices in ascending order\n"
					+ "2. Display the companies stock prices in descending order\n"
					+ "3. Display the total no of companies for which stock prices rose today\n"
					+ "4. Display the total no of companies for which stock prices declined today\n"
					+ "5. Search a specific stock price\n" + "6. press 0 to exit");

			System.out.println("----------------------------------------------------------------------");

			System.out.println();

			input = sc.nextInt();
			switch (input) {
			case 1:
				service.printNaturalOrder(map);
				break;
			case 2:
				service.sortValuesbyDesc(map);
				break;
			case 3:
				System.out.println("Total no of companies whose stock price rose today : " + trueCount);
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today : " + falseCount);
				break;
			case 5:
				System.out.println("Enter the key value");
				double searchPrice = sc.nextDouble();
				service.searchStockPrice(map, searchPrice);
				break;
			default:
				if (input > 5)
					System.out.println("Enter valid option");
			}
		} while (input != 0);
		System.out.println("Exited Successfully");
		sc.close();
	}

}
