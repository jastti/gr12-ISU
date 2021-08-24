package Tsystem;

public class Admin {
	private String adminID;
	private String adminPswd;
	private String adminAcc;

	public Admin(String adminID, String adminPswd, String adminAcc) {
		// create a constructor of the class Admin
		super();
		this.adminID = adminID;
		this.adminPswd = adminPswd;
		this.adminAcc = adminAcc;
		// initialize
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPswd() {
		return adminPswd;
	}

	public void setAdminPswd(String adminPswd) {
		this.adminPswd = adminPswd;
	}

	public String getAdminAcc() {
		return adminAcc;
	}

	public void setAdminAcc(String adminAcc) {
		this.adminAcc = adminAcc;
	}

	public String toString() {
		return "Admin [adminID =" + adminID + ", adminPswd =" + adminPswd + ", admin account =" + adminAcc + "]";
		// toString() to print/ display
	}

}
