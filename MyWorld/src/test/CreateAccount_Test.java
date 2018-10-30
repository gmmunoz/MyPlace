package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import application.DataConnection;


class CreateAccount_Test {

	DataConnection dataConnection = new DataConnection(); 
	
	/*  Create account with valid fields */
	@Test
	void createAccount_valid() throws Exception {
		String usernameTest = "test"; 
		String passwordTest = "12"; 
		
		dataConnection.addUser(usernameTest, passwordTest, "12", "12"); 
		
		assertTrue(dataConnection.userExists(usernameTest)); 
	}
	
	/* Create account with invalid field */
	@Test
	void createAccount_invalidField() throws Exception {
		String usernameAttempt = ""; 
		String passwordAttempt = ""; 
		
		assertTrue(dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12") == 1); 
		
	}
	
	/* Create account with invalid username (already exists) */
	@Test
    void createAccount_existingUsername() throws Exception{
		String usernameAttempt = "test"; 
		String passwordAttempt = "12"; 
		
		dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12");
		
		assertTrue(dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12") == 2);
		
		//remove from database
		dataConnection.deleteUser(usernameAttempt); 
	
	}

}
