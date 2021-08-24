package Tsystem;

public class User implements Comparable<User>{
	private String userID;
	private String userName;
	private String userAddress;
	private String userPhone;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userID, String userName, String userAddress, String userPhone) {
		// create a constructor of the class User
		super();
		this.userID = userID;
		this.userName = userName;
		this.userAddress = userAddress;
        this.userPhone = userPhone;
		// initialize
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "User [User ID =" + userID + ", User name =" + userName + ", User address =" + userAddress
                + ", User phone =" + userPhone + "]";
	}
	// toString() to print/ display
	
	 public int compareTo (User u) {          
		 if (Integer.parseInt(this.getUserID()) < Integer.parseInt(u.getUserID()))    
			 return 1;          
		 else if (Integer.parseInt(this.getUserID()) > Integer.parseInt(u.getUserID()))             
			 return -1;          
		 else              
			 return (int) (Integer.parseInt(this.getUserID()) - Integer.parseInt(u.getUserID()));
	}
	 // sort user from the newest to the oldest
}
