package application;

public class Account {
	
	private String username; 
	private String password; //create Password class and encrypt with hash function
	
	Account(String user, String pass){
		username = user; 
		password = pass; 
	}
	
	
	//checks if inputted values are a valid username and password
	public boolean isValid(String user, String pass) {
		
		return true; //change this
	}
	
	
	//checks if inputted values correspond to existing account
	public boolean exists(String user, String pass) {
		
		return true; //change this
	}
	
	

}
