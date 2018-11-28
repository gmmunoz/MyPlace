import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import application.DataConnection;


class CreateAccount_Test {

	DataConnection dataConnection; 
	
	/*  Create account with valid fields */
	@Test
	void createAccount_valid() throws Exception {
		dataConnection = new DataConnection(); 
		
		String usernameTest = "test"; 
		String passwordTest = "12"; 
		
		assertEquals(usernameTest, dataConnection.deleteUser(usernameTest));
		assertFalse(dataConnection.userExists(usernameTest));
		
		assertTrue(dataConnection.addUser(usernameTest, passwordTest, "12", "12") == 3); 
		assertTrue(dataConnection.userExists(usernameTest)); 
		
		//delete test user
		assertEquals(usernameTest, dataConnection.deleteUser(usernameTest)); 
		
		dataConnection.close(); 
		
	}
	
	/* Create account with invalid field */
	@Test
	void createAccount_invalidField() throws Exception {
		dataConnection = new DataConnection(); 
		
		String usernameAttempt = ""; 
		String passwordAttempt = ""; 
		
		assertTrue(dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12") == 1); 
		
		dataConnection.close(); 
		
	}
	
	/* Create account with invalid username (already exists) */
	@Test
    void createAccount_existingUsername() throws Exception{
		dataConnection = new DataConnection(); 
		
		String usernameAttempt = "test"; 
		String passwordAttempt = "12"; 
		
		//add test user
		assertTrue(dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12") == 3);
		
		//try adding user with same username as test
		assertTrue(dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12") == 2);
		
		//remove from database
		assertEquals(usernameAttempt, dataConnection.deleteUser(usernameAttempt));
		assertFalse(dataConnection.userExists(usernameAttempt));
		
		
		dataConnection.close(); 
	}

}
