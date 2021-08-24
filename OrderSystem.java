package Tsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class OrderSystem implements ADO<Order> {

	static Map<String, Order> orderSys = new HashMap<>();
	static List<Order> ol = new ArrayList<>();

	// use Map and List to save data
	@Override
	public void add(Order t) {
		// TODO Auto-generated method stub
		orderSys.put(t.getOrderID(), t);
		// add order
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		if (orderSys.get(ID) == null) {
			System.out.println("Wrong ID, re-enter: ");
		} else {
			System.out.println("Deleted");
			orderSys.remove(ID);
		}
		// delete order by order ID
	}

	@Override
	public Order find(String ID) {
		if (orderSys.get(ID) == null) {
			return null;
		} else {
			return orderSys.get(ID);
		}
		// find order by order ID
	}

	public List<Order> findByUser(String userID) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<>();
		Set<String> keys = orderSys.keySet();
		for (String key : keys) {
			if (Objects.equals(userID, orderSys.get(key).getUserID())) {
				list.add(orderSys.get(key));
			}
		}
		return list;
		// find order by user ID
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		List<Order> orderlist = new ArrayList<>();
		Set<String> keys = orderSys.keySet();
		for (String key : keys) {
			orderlist.add(orderSys.get(key));
		}
		return orderlist;
		// find all order by list
	}

}
