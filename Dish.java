package Tsystem;

public class Dish implements Comparable<Dish>{
	private String dishID;
	private String dishName;
	private String dishType;
	private Double price;

	public Dish(String dishID, String dishName, String dishType, double price) {
		// create a constructor of the class Dish
		super();
		this.dishID = dishID;
		this.dishName = dishName;
		this.dishType = dishType;
		this.price = price;
		// initialize
	}

	public Dish() {
		// TODO Auto-generated constructor stub
	}

	public String getDishID() {
		return dishID;
	}

	public void setDishID(String dishID) {
		this.dishID = dishID;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dtype) {
		this.dishType = dishType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Dish [Dish id: " + dishID + ", Dish: " + dishName + ", Type：" + dishType + ", price：" + price + "]";
	}
	// toString() to print/ display

	public int compareTo (Dish d) {          
		 if (Integer.parseInt(this.getDishID()) < Integer.parseInt(d.getDishID()))    
			 return 1;          
		 else if (Integer.parseInt(this.getDishID()) > Integer.parseInt(d.getDishID()))             
			 return -1;          
		 else              
			 return (int) (Integer.parseInt(this.getDishID()) - Integer.parseInt(d.getDishID()));
	}
	// sort dish from the newest to the oldest
	
}
