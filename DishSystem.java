package Tsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DishSystem implements ADO<Dish> {

	static Map<String, Dish> dishSys = new HashMap<>();
	Set<String> ds = dishSys.keySet();

	// use Map and List to save data
	public void add(Dish t) {
		// TODO Auto-generated method stub
		dishSys.put(t.getDishID(), t);
		// add/ put the dish ID
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		if (dishSys.get(ID) == null) {
			System.out.println("Wrong ID, re-enter: ");
		} else {
			dishSys.remove(ID);
		}
		// delete the dish by dish ID
	}

	@Override
	public Dish find(String ID) {
		// TODO Auto-generated method stub
		if (dishSys.get(ID) == null) {
			return null;
		} else {
			return dishSys.get(ID);
		}
		// search the dish by dish ID
	}

	@Override
	public List<Dish> findAll() {
		// TODO Auto-generated method stub
		List<Dish> list = new ArrayList<>();
		for (String str : ds) {
			list.add(dishSys.get(str));
		}
		return list;
		// find all dishes by list
	}

	public List<Dish> findByType(String type) {
		List<Dish> list = new ArrayList<>();
		for (String key : ds) {
			if (Objects.equals(type, dishSys.get(key).getDishType())) {
				list.add(dishSys.get(key));
			}
		}
		return list;
		// find dish by type(s)
	}

}
