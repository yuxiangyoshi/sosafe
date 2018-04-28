package sosafe;

public class Customer {
	private String id; // phone or email
	private String name;
	private String address;
	private String[] contactNumbers;
	private String date;
	private String email;

	
	public Customer() {
		id = "COEN-275-E";
		name = "Batman ";
		address = "Santa Clara University";
		email = "batman@scu.edu";
	    date = "MAY/9/2017 - JUN/9/2017";
	    contactNumbers = new String [] {"6692739342", "6692739459"};
	}
	
//	public void installFireSensor(Room room) {
//		room.installFireSensor();
//		 //set change
//		setChanged();
//	    // notify Observers that model has changed
//	    notifyObservers();
//	}
	
//	public void installMotionSensor(Room room) {
//		room.installMotionSensor();
//		 //set change
//		setChanged();
//	    // notify Observers that model has changed
//	    notifyObservers();
//	}
	
//	public Building getBuilding() {
//		return building;
//	}
	
//	public void setInstallCost(int value) {
//		installCost = value;
//	}
	
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String[] getContactNumbers() {
		return contactNumbers;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getDate() {
		return date;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
