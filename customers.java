package ticketplease;

class Customers extends users {
	  // Additional attributes for Customers
	  private String customerId;
	  private String address;
	  private String phoneNumber;

	  // Constructor
	  public Customers(String name, String username, String password, String customerId, String address, String phoneNumber) {
	    super(name, username, password, phoneNumber, phoneNumber);
	    this.customerId = customerId;
	    this.address = address;
	    this.phoneNumber = phoneNumber;
	  }

	  // Getters and Setters for additional attributes
	  public String getCustomerId() {
	    return this.customerId;
	  }

	  public void setCustomerId(String customerId) {
	    this.customerId = customerId;
	  }

	  public String getAddress() {
	    return this.address;
	  }

	  public void setAddress(String address) {
	    this.address = address;
	  }

	  public String getPhoneNumber() {
	    return this.phoneNumber;
	  }

	  public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	  }

	  // Additional methods for Customers
	  public void showAvailableFilms() {
	    // Logic to show available films
	  }

	  public void makeReservation() {
	    // Logic to make a reservation
	  }

	  public void viewReservation() {
	    // Logic to view reservation
	  }
	}