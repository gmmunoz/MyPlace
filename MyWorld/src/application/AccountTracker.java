package application;

public class AccountTracker {

	private static String currentUser;
	
	public AccountTracker(String input){
		currentUser = input;
	}
	
	public AccountTracker() {
		this.getUser();
	}
	
	public String getUser() {
		return currentUser;
	}
}
