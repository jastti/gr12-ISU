package Tsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order implements Comparable<Order> {
	private String orderID;
	private LocalDateTime orderTime;
	private Dish dish;
	private int orderNum;
	private String userID;
	private Double orderPrice;

	public Order(String orderID, LocalDateTime orderTime, Dish dish, int orderNum, String userID, Double orderPrice) {
		// create a constructor of the class Order
		super();
		this.orderID = orderID;
		this.orderTime = orderTime;
		this.dish = dish;
		this.orderNum = orderNum;
		this.userID = userID;
		this.orderPrice = orderPrice;
		// initialize
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		orderID = orderID;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		orderPrice = orderPrice;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		orderNum = orderNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Double total() {
		// TODO Auto-generated method stub
		return orderPrice;
	}

	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		String time = orderTime.format(format);
		return "Order: [ Order ID =" + orderID + ", Order Time = " + time + ", dishes = " + dish + ", Quantity = "
				+ orderNum + ", user ID =" + userID + ", Order price=" + orderPrice + "]";
	}
	// toString() to print/ display

	@Override
	public int compareTo(Order o) {
		if (Integer.parseInt(this.getOrderID()) < Integer.parseInt(o.getOrderID()))
			return 1;
		else if (Integer.parseInt(this.getOrderID()) > Integer.parseInt(o.getOrderID()))
			return -1;
		else
			return (int) (Integer.parseInt(this.getOrderID()) - Integer.parseInt(o.getOrderID()));
	}
	// sort the order list from the smallest number to the largest number
}
