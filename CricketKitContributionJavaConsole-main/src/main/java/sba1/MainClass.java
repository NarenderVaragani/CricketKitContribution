package sba1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static void main(String[] args) throws IOException, NumberFormatException, ParseException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		List<Purchase> purchases = new ArrayList<Purchase>();
		System.out.println("Enter the number of purchases:");
		Integer purchaseCount = Integer.parseInt(buff.readLine());
		System.out.println("Enter the purchase details:");
		for (int i = 0; i < purchaseCount; i++) {
			String str = buff.readLine();
			try {
				Purchase p = Purchase.obtainPurchaseWithAmount(str);
				purchases.add(p);
				System.out.println("Purchase " + p.getId() + " is added to the list");
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		Collections.sort(purchases);
		System.out.println("Whole sale purchases:");

		for (Purchase p : purchases) {
			System.out.println(p);
		}

	}
}
/*
 * input for program
1,12-12-2021,Narender,TV,15000,6,Fridge,54000,4,tablet,43000,5,laptop,54000,12,gyser,250000,10,chair,145,25
*/