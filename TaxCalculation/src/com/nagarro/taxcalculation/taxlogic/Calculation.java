package com.nagarro.taxcalculation.taxlogic;

import com.nagarro.taxcalculation.model.ItemDetails;

public class Calculation {

	public static double getRaw(ItemDetails item) {
		double totalPrice = item.getPrice() * item.getQuantity();
		return (12.5 / 100) * totalPrice;
	}

	public static double getManufactured(ItemDetails item) {
		double totalPrice = item.getPrice() * item.getQuantity();
		return ((12.5 / 100) * totalPrice) + (2.0 / 100) * ((totalPrice + ((12.5 / 100) * totalPrice)));
	}

	public static double getImported(ItemDetails item) {

		double totalPrice = item.getPrice() * item.getQuantity();
		return (10.0 / 100) * totalPrice;
	}
}
