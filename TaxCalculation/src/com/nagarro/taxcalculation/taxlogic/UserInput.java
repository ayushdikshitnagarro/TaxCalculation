package com.nagarro.taxcalculation.taxlogic;

import java.util.Scanner;

import com.nagarro.taxcalculation.constants.Constants;
import com.nagarro.taxcalculation.enums.ItemType;
import com.nagarro.taxcalculation.model.ItemDetails;

public class UserInput {

	public void getUserInput() {

		Double tax = 0.0;
		Double fixedPrice = 0.0;

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(Constants.ITEM_NAME);
			String itemName = scanner.nextLine();

			System.out.println(Constants.ITEM_TYPE);
			String itemType = scanner.next();

			System.out.println(Constants.ITEM_PRICE);
			Double itemPrice = scanner.nextDouble();

			System.out.println(Constants.ITEM_QUANTITY);
			int itemQuantity = scanner.nextInt();

			if (itemType == null || itemPrice < 0 || itemQuantity < 0) {
				System.out.println(Constants.CONDITION);
				break;
			} else {
				ItemDetails item = new ItemDetails(itemName, itemPrice, itemQuantity, itemType);

				if ((ItemType.raw).equals(item.getType())) {
					tax = Calculation.getRaw(item);
					fixedPrice = item.getPrice() * item.getQuantity() + tax;
				} else if ((ItemType.manufactured).equals(item.getType())) {
					tax = Calculation.getManufactured(item);
					fixedPrice = item.getPrice() * item.getQuantity() + tax;
				} else {
					tax = Calculation.getImported(item);
					fixedPrice = item.getPrice() * item.getQuantity() + tax;
					if (fixedPrice <= 100) {
						fixedPrice = fixedPrice + 5;
					} else if (fixedPrice > 100 && fixedPrice <= 200) {
						fixedPrice = fixedPrice + 10.0;
					} else {
						fixedPrice = fixedPrice + ((5.0 / 100) * fixedPrice);
					}

				}
				System.out.println(Constants.ITEM_NAME + item.getName());
				System.out.println(Constants.ITEM_PRICE + item.getPrice());
				System.out.println(Constants.SALES_TAX + tax);
				System.out.println(Constants.FINAL_TAX + fixedPrice);
			}
			System.out.println(Constants.PRINT);
			String choice = scanner.next();
			if (choice.equalsIgnoreCase(Constants.CONTINUE)) {
				continue;
			} else {
				System.out.println(Constants.REGARDS);
				break;
			}
		}
	}
}
