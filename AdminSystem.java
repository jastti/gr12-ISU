package Tsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ComboBoxModel;


public class AdminSystem implements ADO<Admin>{

	static Map<String, Admin> map = new HashMap<>();
	static String orderIndex = "0000";
	static String userIndex = "0000";
	static String dishIndex = "000";
	//initialize order, user, dish
	
	UserSystem u = new UserSystem();
	OrderSystem o = new OrderSystem();
	DishSystem d = new DishSystem();
	Scanner sc = new Scanner(System.in);
	User us = new User();
	
	//Console Program
    public void addDish() throws IOException {
        System.out.println("Enter Dish:(Dish ID/Dish name/Dish type/price)");
        String str = sc.next();
        String[] info = str.split("/");
        // ask to input in order, split the input the string and determine
        if (info.length < 4) {
            System.out.println("Wrong enter! Re-enter: ");
            addDish();
            // if the input is too short, ask to re-input
        } else {
//            LocalDate dtime = LocalDate.now();
            Dish t = new Dish(info[0], info[1], info[2], Double.parseDouble(info[3]));
            d.add(t);
            System.out.println("Dish added");
            // else add new dish
        }
    }
    
    // Graphic Program
    public Dish addDishToWin(String dId, String dName, String dType, Double dPrice)  {
    	dishIndex = codeAddOne(dishIndex, 3);
    	// Order length is 4, use "0" to fill the formal order is
		if (d.find(dishIndex) == null) {
			// Check if the dish id is unique, if yes, add dish
			  Dish t = new Dish(dishIndex, dName, dType, dPrice);
	            d.add(t);
	            System.out.println("Dish added: ");
	            return t;
		} else {
			// else cannot add
			System.out.println("The dish is repeated!!");
			return null;
		}
    }
    
  //Console Program
    public void deleteDish() {
    	System.out.println("Enter the dish ID of the dish you want to delete: ");
    	String id = sc.next();
        d.delete(id);
        System.out.println("Deleted");
        // Delete dish by enter dish ID
    }
    
    // Graphic Program
    public Boolean deleteDishToWin(String id) {
        System.out.println("Deleted");
        if (d.find(id) == null) {
			return false;
			// If cannot find dish id, return false
		} else {
			d.delete(id);
	        System.out.println("Deleted");
			return true;
			// If find dish with dish id, delete dish and return true
		}
    }
    
  //Console Program
    public void viewAllDish() {
    	List<Dish> dl = d.findAll();
    	 while (true) {
    		 System.out.println(dl);
                 break;
             }
    	 // print dish list(menu)
    }
    
    // Graphic Program
	public Dish[] viewAllDishToWin() {
    	List<Dish> dl = d.findAll();
    	Collections.sort((List<Dish>) dl);
    	// sort dish
    	int i = dl.size();
    	Dish[] dishInfo = (Dish[]) dl.toArray(new Dish[i]);
    	// change List toArray, add into JCombobox
    	System.out.println(dishInfo.toString());
    	// Use toString() to print in formal way
		return dishInfo;
	}
    
	//Console Program
    public void priceChange() {
        System.out.println("Enter the dish ID：");
        String id = sc.next();
        Dish dish = d.find(id);
        // ask to enter dish id
        if (dish == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Dish：" + dish);
            System.out.println("Enter new price：");
            double newprice = sc.nextDouble();
            // enter new price
            Dish t = new Dish(dish.getDishID(), dish.getDishName(), dish.getDishType(), newprice);
            d.add(t);
            System.out.println("successful!" + d.find(t.getDishID()));
            // use map to "update" new price to the dish
        }
    }
    
    public Dish priceChange(String id, double dPrice) {
        Dish dish = d.find(id);
        // find dish by dish id first
        if (dish == null) {
            System.out.println("Not found");
            return null;
        } else {
            System.out.println("Dish：" + dish);
            double newprice = dPrice;
            // if find dish, enter new price
            Dish t = new Dish(dish.getDishID(), dish.getDishName(), dish.getDishType(), newprice);
            d.add(t);
            System.out.println("successful!" + d.find(t.getDishID()));
            return t;
         // use map to "update" new price to the dish
        }
    }

  //Console Program
    public void addUser() {
    	 System.out.println("Enter user info:(User ID/User Name/User Address/User phone number)");
         String str = sc.next();
         String[] info = str.split("/");
         // enter user info in order to add new user
         if (info.length < 4) {
             System.out.println("Wrong enter! Re-enter: ");
             addUser();
             // if input is too short, re-input
         } else {
             User user = new User(info[0], info[1], info[2], info[3]);             
            u.add(user);
             System.out.println("User added");
             // else add new user
         }
    }
    
    // Graphic Program
    public User addUserToWin(String uid, String name, String address, String phone) {
        userIndex = codeAddOne(userIndex, 4);
        // add "0" at the beginning of the user id to filled user id in formal way
        User user = new User(userIndex, name, address, phone);
        u.add(user);
        // add user by info
        System.out.println("User added");
    return user;
}
    
  //Console Program
    public void deleteUser() {
    	System.out.println("Enter the user ID of the user you want to delete: ");
    	String id = sc.next();
        u.delete(id);
        // delete user by user ID
    }
    
    public Boolean deleteUserToWin(String id) {
		if (u.find(id) == null) {
			return false;
			// If cannot find user by user id, return false
		} else {
			u.delete(id);
			return true;
			// If find user, delete by user id, return true
		}
	}
    
  //Console Program
    public void viewUser() {
    	List<User> userList = u.findAll();
    	for(User user:userList) {
    		System.out.println(user);
    	}
    	// Iterate userList to print all users line by line
    }

    // Graphic Program
	 public User[] viewUserToWin() {
			List<User> userList = u.findAll();
			Collections.sort((List<User>) userList);
			// sort user list
			int i = userList.size();
			User[] userInfo = (User[]) userList.toArray(new User[i]);
			// change userList toArray, add into JCombobox
			return userInfo;
	}
    
	//Console Program
    public User findUser(String ID) {
    	System.out.println(u.find(ID));
    	return u.find(ID);
    	// find user by user ID
    }
    
    // Graphic Program
    public User findUserToWin(String ID) {
    	System.out.println(u.find(ID));
    	return u.find(ID);
    	// find user by user ID
    }
    
  //Console Program
    public void showOrderList(User user) {
    	List<Order> order = o.findByUser(user.getUserID());
    	for(Order or:order) {
    		System.out.println(or);
    	}
    	// Iterate order to print all orders of a user line by line
    }
    
    // Graphic Program
	public List<Order> showOrderListToWin(User user) {
    	List<Order> orderList = o.findByUser(user.getUserID());
    	Collections.sort((List<Order>) orderList);
    	// sort orders from the newest to the oldest
    	for(Order or: orderList ) {
    		System.out.println(or);
    	}
    	return orderList;
    	// Iterate orderList to print all orders of a user line by line
    }
    
	//Console Program
    public void showOrderList() {
        List<Order> allOrder = o.findAll();
        Collections.sort((List<Order>) allOrder);
     // sort orders from the newest to the oldest
        for (Order order : allOrder) {
            System.out.println(order);
        }
     // Iterate allOrder to print all orders line by line
    }
    
    // Graphic Program
    public List<Order> showOrderListToWin() {
        List<Order> allOrder = o.findAll();
        Collections.sort((List<Order>) allOrder);
     // sort orders from the newest to the oldest
        for (Order order : allOrder) {
            System.out.println(order);
        }
        return allOrder;
     // Iterate allOrder to print all orders line by line
    }
    
  //Console Program
    public void buyDish(User user) {
    	System.out.println("Enter the dish you want to buy(DishID/ Quantity): ");
    	String str = sc.next();
        String[] info = str.split("/");
        // enter dish id and amount to buy dish
        if(info.length < 2) {
        	System.out.println("Wrong enter! Re-enter: ");
        	buyDish(user);
        } else {
        	LocalDateTime time = LocalDateTime.now();
//        	DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");  
//            String formatDateTime = time.format(format); 
        	String userId = user.getUserID();
        	System.out.println(info[0]);// dish id
        	System.out.println(time);
        	System.out.println(d.find(info[0]));
        	int quantity = Integer.parseInt(info[1]);//amount
        	System.out.println(quantity);
        	System.out.println(userId);
        	System.out.println(d.find(info[0]).getPrice());
        	double oPrice = quantity*(d.find(info[0]).getPrice());// orderPrice
        	System.out.println(oPrice);
        	orderIndex = codeAddOne(orderIndex,4);
        	// the default length of order is 4, add "0" at the beginning to fill the length
        	if (o.find(orderIndex)==null) {
        		Order order = new Order(orderIndex, time, d.find(info[0]), quantity,
                		userId, oPrice);
        		// check if the order id is unique, if yes, add new order
                o.add(order);
                System.out.println("Order: " + o.find(orderIndex).toString());
			}
        	else {
				System.out.println("The order is repeated!!");
			}
        } 
    }
    
    // Graphic Program
	public Order buyDishToWin(User user, String dishID, Integer quantity) {
		LocalDateTime time = LocalDateTime.now();
		String userId = user.getUserID();
		System.out.println(dishID);// dish id
		System.out.println(time);
		System.out.println(d.find(dishID));
		System.out.println(quantity);
		System.out.println(userId);
		System.out.println(d.find(dishID).getPrice());
		double oPrice = quantity * (d.find(dishID).getPrice());// order price
		System.out.println(oPrice);
		orderIndex = codeAddOne(orderIndex, 4);
		// the default length of order is 4, add "0" at the beginning to fill the length
		if (o.find(orderIndex) == null) {
			Order order = new Order(orderIndex, time, d.find(dishID), quantity, userId, oPrice);
			// check if the order id is unique, if yes, add new order
			o.add(order);
			System.out.println("Order: " + o.find(orderIndex).toString());
			return order;
		} else {
			System.out.println("The order is repeated!!");
			return null;
		}
	}
    
	//Console Program
    public void DishByType() {
        System.out.println("Enter dish type: ");
        String str = sc.next();
        System.out.println(d.findByType(str));
        // enter dish type and find that type of dishes
    }
    
    // Graphic Program
    public Dish[] DishByTypeToWin(String dishType) {
    	 List<Dish> dishList = d.findByType(dishType);
    	 int i = dishList.size();
     	// Change List to Array to add into JCombobox
     	Dish[] dishInfo = (Dish[]) dishList.toArray(new Dish[i]);
         System.out.println(dishInfo.toString());
         // Use toString to print info in formal way
		return dishInfo;
	}
    
    public static String codeAddOne(String code, int len){
    	   Integer intHao = Integer.parseInt(code);
    	   intHao++;
    	   String strHao = intHao.toString();
    	   while (strHao.length() < len) {
    	       strHao = "0" + strHao;
    	     }
    	   // if the length isn't enough, use "0" to fill
    	   return strHao;
    	}
    
    // read file
    public void readFile() throws FileNotFoundException {
    	try {
    		// read file of dish
			File file = new File("dish2.txt");
			Scanner scan = new Scanner(file);
			String code1 = null;
			if(file.exists()) {
				int dCount = 1;
				while (scan.hasNext()) {
					code1 = scan.nextLine();
					// read the string in this line.
					final String[] words = code1.split("[, ]+");
					System.out.println(words + " is ok");
					String sd = words[0];
					if (dCount == 1) {
						dishIndex = sd; 
						// sort orders from the newest to the oldest
						dCount ++;
					}
					Dish d1 = new Dish(words[0], words[1], words[2],  Double.parseDouble(words[3]));
					d.add(d1);
				}
			}
		
		} catch (Exception e) {
			System.out.println("File cannot read");
        }
    	
    	try {
    		// read file of user
			File file = new File("user2.txt");
			Scanner scan = new Scanner(file);
			String code1 = null;
			if(file.exists()) {
				int uCount = 1;
				while (scan.hasNext()) {
					code1 = scan.nextLine();
					// read the string in this line.
					final String[] words = code1.split("[, ]+");
					System.out.println(words + " is ok");
					String su = words[0];
					if (uCount == 1) {
						userIndex = su; 
						// sort orders from the newest to the oldest
						uCount ++;
					}
					User u1 = new User(words[0], words[1], words[2],  words[3]);
					u.add(u1);
				}
			}
		} catch (Exception e) {
			System.out.println("File cannot read");
        }
    	
    	try {
    		// read file of order
			File file = new File("order2.txt");
			Scanner scan = new Scanner(file);
			String code1 = null;
			int count=1;
			if(file.exists()) {
				while (scan.hasNext()) {
					code1 = scan.nextLine();
					// read the string in this line.
					final String[] words = code1.split("[,][ ]+"); 
					// regex the string and save
					System.out.println(words + " is ok");
					Dish d1 = new Dish(words[2], words[3], words[4], Double.parseDouble(words[5]));
					String s0 = words[0];
					DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");//规范化日期格式，在程序加载和文件中保持一致；
					LocalDateTime s1 = LocalDateTime.parse(words[1],df);
					// Turn date from file in formal way
					System.out.println("LocalDateTime："+s1);
					
					Integer s6 = Integer.parseInt(words[6]);
					String s7 = words[7];
					Double s8 = Double.parseDouble(words[8]);
					if (count == 1) {
						orderIndex = s0; 
						// Order save from the newest to the oldest
						// Use the first line as default and add order
					    count ++;
					}
					Order o1 = new Order(s0, s1, d1, s6, s7, s8);
					o.add(o1);
				}
			}
		} catch (Exception e) {
			System.out.println("File cannot read");
        }
	}
    
    // write file
    public void exitSystem()  {
		try {
			FileWriter d_fw = new FileWriter("dish2.txt",false);
            PrintWriter d_pw = new PrintWriter(d_fw);
            List<Dish> dishList = d.findAll();
            Collections.sort((List<Dish>) dishList);
         // dish save from the newest to the oldest
            for (Dish dish : dishList) {
            	System.out.println(dish);
            	String d_String = dish.getDishID()  +", " + dish.getDishName()  +", " + dish.getDishType()  +", " + dish.getPrice();
        		d_pw.println(d_String);
        		// the end of the String doesn't need nextLine
			}	
            d_pw.close () ;
            d_fw.close () ;
            
            FileWriter u_fw = new FileWriter("user2.txt",false);
            PrintWriter u_pw = new PrintWriter(u_fw);
            List<User> userList = u.findAll();
            Collections.sort((List<User>) userList);
         // user save from the newest to the oldest
        	for(User user:userList) {
        		System.out.println(user);
        		String u_String = user.getUserID() +", " + user.getUserName() +", " + user.getUserAddress() +", " + user.getUserPhone();
        		u_pw.println(u_String);
        		// the end of the String doesn't need nextLine
        	}
       	 u_pw.close () ;
         u_fw.close () ;
         
        	 FileWriter o_fw = new FileWriter("order2.txt",false);
             PrintWriter o_pw = new PrintWriter(o_fw);
        	List<Order> orderList = o.findAll();
        	Collections.sort((List<Order>) orderList);
        	// user save from the newest to the oldest
        	for(Order order: orderList) {
        		System.out.println(order);
        		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        		LocalDateTime time = order.getOrderTime();
				String localTime = df.format(time);
				// set time in formal
				String d_price = String.valueOf(order.getDish().getPrice());
				Double o_priceDouble = order.getOrderPrice();
				String o_price = String.valueOf(o_priceDouble);
        		String o_String = order.getOrderID() +", " + localTime +", " 
        		+ order.getDish().getDishID() +", " + order.getDish().getDishName() +", " 
        				+ order.getDish().getDishType() +", " 
        		+ d_price +", " + order.getOrderNum() + ", " + order.getUserID() +", " 
        				+ o_price;
        		o_pw.println(o_String);
        		// the end of the String doesn't need nextLine
        	}
            o_pw.close () ;
            o_fw.close () ;
		} catch (Exception e) {
			System.out.println("File cannot read");
		}
	}
    
  //Console Program
    public void deleteOrder() {
    	System.out.println("Enter the order ID of the order you want to delete: ");
    	String id = sc.next();
        o.delete(id);
        o.findAll();
        // Delete order by order id
    }

    // Graphic Program
	public Boolean deleteOrderToWin(String orderID) {
		System.out.println(orderID);
    		if (o.find(orderID)==null) {
    			// if cannot find the order, return false
    			return false;
    		}
            else {
            	o.delete(orderID);
            	// if find the order, delete it by order id, return true
    			return true;
    		}
	}
	
	public void delete(String ID) {
	}

	@Override
	public Admin find(String ID) {
		return map.get(ID);
	}

	@Override
	public List findAll() {
		return null;
	}

	@Override
	public void add(Admin t) {
		
	}
	
	// Console Test Program
	public static void main(String[] args) {
		AdminSystem ad = new AdminSystem();
		
		for(int i = 0; i>=0; i++) {
		System.out.println("ENTER:");
		Scanner sc = new Scanner(System.in);
		int st = sc.nextInt();
		// enter number of choice to test the program
		if (st == 1) {
		try {
			ad.addDish();
			// add dish
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else if (st == 2) {
		ad.viewAllDish();
		// view all dish(menu)
		} else if (st == 3) {
			ad.deleteDish();
			// delete dish
			}
		else if (st == 4) {
			ad.addUser();
			// add user
		}
		else if (st == 5) {
			ad.deleteUser();
			// delete user
		}
		else if (st == 6) {
			ad.viewUser();
			// view user list
		} else if (st == 7) {
			Scanner sc2 = new Scanner(System.in);
			String s = sc2.toString();
			ad.findUser(s);
			// find user
		} else if (st == 8) {
//			ad.showOrderList();
		} else if (st == 9) {
//			ad.buyDish();
		} else if (st == 10){
			System.exit(0);
			// exit
		}
		}
	}

	// set Default info
	public void addMessage() throws FileNotFoundException {
		map.put("admin", new Admin("10086", "123456", "admin"));
		readFile();
		LocalDate time = LocalDate.now();
      Dish d1 = new Dish("1", "Hamburger", "Fast food", 6.5);
      d.add(d1);
      Dish d2 = new Dish("2", "Udon", "Noodle", 12);
      d.add(d2);
      Dish d3 = new Dish("3", "Donut", "Dessert", 3);
      d.add(d3);
      Dish d4 = new Dish("4", "Baguette", "Bread", 7.5);
      d.add(d4);
      Dish d5 = new Dish("5", "Cupcake", "Dessert", 6);
      d.add(d5);
      
      LocalDateTime localdatetime = LocalDateTime.now();
    Order o1 = new Order("1", localdatetime, d1, 10, "1001", 65.0);
    o.add(o1);
    Order o2 = new Order("2", localdatetime, d2, 5, "1002", 60.0);
    o.add(o2);
    Order o3 = new Order("3", localdatetime, d3, 4, "1003", 12.0);
    o.add(o3);
    Order o4 = new Order("4", localdatetime, d4, 2, "1004", 15.0);
    o.add(o4);
    Order o5 = new Order("5", localdatetime, d5, 5, "1005", 30.0);
    o.add(o5);
      
    User u1 = new User("1001", "Ada", "3700 Highway7", "6471234567");
  u.add(u1);
  User u2 = new User("1002", "Betty", "1000 Carlton Rd", "6477654321");
  u.add(u2);
  User u3 = new User("1003", "Cindy", "300 Yonge St", "6471122334");
  u.add(u3);
  User u4 = new User("1004", "Daisy", "50 Markville Rd", "6471112223");
  u.add(u4);
  User u5 = new User("1005", "Emily", "7524 16Ave", "6479876543");
  u.add(u5);
    
        // String uID, String uname, String usex, String upwd, String uadress, String
        // utel, LocalDateTime utime
	}

}
