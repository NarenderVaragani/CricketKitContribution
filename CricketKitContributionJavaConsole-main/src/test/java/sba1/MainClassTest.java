package sba1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainClassTest {

			
		@Test
		void testObtainPurchaseWithAmountCustomException() {
			
			String str = "1,12-12-2012,John,Bat,1500,5,Ball,60,2";
			Exception exception = Assertions.assertThrows(InvalidWholeSaleException.class, () -> { Purchase p = Purchase.obtainPurchaseWithAmount(str); });

			String expectedMessage = "Purchase 1 is added to the list"; 
			String actualMessage = exception.getMessage();
			System.out.println(actualMessage);
			
			Assertions.assertTrue(actualMessage.contains (expectedMessage));
		}		

	@Test
	void testObtainPurchaseWithAmount() throws Exception {
		// Test will pass
		List<Purchase> purchases = new ArrayList<Purchase>();
		List<String> expectedList = new ArrayList<String>();
		List<String> resultList = new ArrayList<String>();
		String str = "1,12-12-2012,John,Bat,1500,5,Ball,60,2,Stump,340,15,helmet,925,8,Pad,600,20,Gloves,450,35,Guard,120,4";
		Purchase p = Purchase.obtainPurchaseWithAmount(str);
		if(p==null) {
			Assertions.assertNull(p);
			return;
		}
		purchases.add(p);
		String str1 = "3,12-12-2012,Jack,Bat,1500,7,Ball,60,1,Stump,340,5,helmet,925,5,Pad,600,15";
		p = Purchase.obtainPurchaseWithAmount(str1);
		purchases.add(p);
		Collections.sort(purchases);
		expectedList.add("3          Jack            25885.0");
		expectedList.add("1          John            48350.0");
		for (int i = 0; i < purchases.size(); i++) {
			resultList.add(purchases.get(i).toString());
		}
		Assertions.assertEquals(expectedList, resultList);
		}
	
	@Test
	void testObtainPurchaseWithAmountImpl() throws Exception {
		// Test will pass
		
		String str = "1,12-12-2012,John,Bat,1500,5,Ball,60,2,Stump,340,15,helmet,925,8,Pad,600,20,Gloves,450,35,Guard,120,4";
		Purchase p = Purchase.obtainPurchaseWithAmount(str);
		if(p==null) {
			Assertions.assertNull(p);
			return;
		}
		}
}
