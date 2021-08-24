package Tsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserSystem implements ADO<User>{
	
	static Map<String, User> userSys = new HashMap<>();
	Set<String> keys = userSys.keySet();
    // use Map and Set to save data
    Scanner sc = new Scanner(System.in);

	@Override
	public void add(User t) {
		// TODO Auto-generated method stub
		userSys.put(t.getUserID(), t);
		// add user
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		if (userSys.get(ID) == null) {
			System.out.println("User not found!");
		} else {
			System.out.println(userSys.get(ID) + "deleted");
			userSys.remove(ID);
		}
		// delete user by user ID
	}

	@Override
	public User find(String ID) {
		// TODO Auto-generated method stub
		if(userSys.get(ID) == null) {
			return null;
		} else {
			return userSys.get(ID);
		}
		// find user by user ID
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> ul = new ArrayList<>();
        for (String str : keys) {
            ul.add(userSys.get(str));
        }
        return ul;
        // show all user by a list
	}

}
