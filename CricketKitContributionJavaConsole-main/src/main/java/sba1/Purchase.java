package sba1;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase implements Comparable<Purchase> {
	private long id;
	private Date purchaseDate;
	private double totalAmount;
	private String username;

	public Purchase(long id, Date purchaseDate, double totalAmount, String username) {
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return String.format("%-10d %-15s %.1f", this.getId(), this.getUsername(), this.getTotalAmount());
	}

	static Purchase obtainPurchaseWithAmount(String str) throws InvalidWholeSaleException, ParseException {
		String d[] = str.split(",");
		long purchaseId = Long.parseLong(d[0]);
		if (((d.length - 3) / 3) < 5) {
			throw new InvalidWholeSaleException("Purchase " + purchaseId + " is not a whole sale");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		sdf.setLenient(false);
		Date purchaseDate = sdf.parse(d[1]);
		double totalAmount = 0;
		for (int i = 5; i < d.length; i = i + 3) {
			int itemCost = Integer.parseInt(d[i - 1]);
			int itemQuantity = Integer.parseInt(d[i]);
			totalAmount = totalAmount + (itemCost * itemQuantity);
		}
		String username = d[2];

		Purchase purchase = new Purchase(purchaseId, purchaseDate, totalAmount, username);
		return purchase;
	}

//	2[0],12-12-2021[1],Narender[2],TV[3],15000[4],6[5],8,11,14

	@Override
	public int compareTo(Purchase p) {
		if (this.getTotalAmount() < p.getTotalAmount()) {
			return -1;
		} else if (this.getTotalAmount() == p.getTotalAmount()) {
			return 0;
		} else {
			return 1;
		}
	}
}
