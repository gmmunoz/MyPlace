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
		
		//delete user if "test" already exists
		assertEquals(usernameTest, dataConnection.deleteUser(usernameTest));
		assertFalse(dataConnection.userExists(usernameTest));
		
		//ensure that user is valid and added to database
		assertFalse(dataConnection.validAccount(usernameTest, passwordTest)); 
		assertEquals(dataConnection.addUser(usernameTest, passwordTest, "12", "12"), 3); 
		assertTrue(dataConnection.userExists(usernameTest)); 
		
		//delete test user
		assertEquals(usernameTest, dataConnection.deleteUser(usernameTest)); 
		
		dataConnection.close(); 
		
	}
	
	/* Create account with invalid field */
	@Test
	void createAccount_invalidFieldUN() throws Exception {
		dataConnection = new DataConnection(); 
		
		String usernameAttempt = ""; 
		String passwordAttempt = "123"; 
		String sqAttempt1 = "123";
		String sqAttempt2 = "123"; 

		//ensure empty fields cannot be added to database
		assertEquals(dataConnection.addUser(usernameAttempt, passwordAttempt, sqAttempt1, sqAttempt2), 1); 
		
		dataConnection.close(); 
		
	}
	
	@Test
	void createAccount_invalidFieldPS() throws Exception {
		dataConnection = new DataConnection(); 
		
		String usernameAttempt = "test"; 
		String passwordAttempt = ""; 
		String sqAttempt1 = "123";
		String sqAttempt2 = "123"; 

		//ensure empty fields cannot be added to database
		assertEquals(dataConnection.addUser(usernameAttempt, passwordAttempt, sqAttempt1, sqAttempt2), 1); 
		
		dataConnection.close(); 
		
	}
	
	@Test
	void createAccount_invalidFieldSQ1() throws Exception {
		dataConnection = new DataConnection(); 
		
		String usernameAttempt = "test"; 
		String passwordAttempt = "123"; 
		String sqAttempt1 = "";
		String sqAttempt2 = "123"; 

		//ensure empty fields cannot be added to database
		assertEquals(dataConnection.addUser(usernameAttempt, passwordAttempt, sqAttempt1, sqAttempt2), 1); 
		
		dataConnection.close(); 
		
	}
	
	@Test
	void createAccount_invalidFieldSQ2() throws Exception {
		dataConnection = new DataConnection(); 
		
		String usernameAttempt = "test"; 
		String passwordAttempt = "123"; 
		String sqAttempt1 = "123";
		String sqAttempt2 = ""; 

		//ensure empty fields cannot be added to database
		assertEquals(dataConnection.addUser(usernameAttempt, passwordAttempt, sqAttempt1, sqAttempt2), 1); 
		
		dataConnection.close(); 
		
	}
	
	/* Create account with invalid username (already exists) */
	@Test
    void createAccount_existingUsername() throws Exception{
		dataConnection = new DataConnection(); 
		
		String usernameAttempt = "test"; 
		String passwordAttempt = "12"; 
		
		//add test user
		assertEquals(dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12"), 3);
		assertTrue(dataConnection.validAccount(usernameAttempt, passwordAttempt));
		
		//try adding user with same username as test
		assertEquals(dataConnection.addUser(usernameAttempt, passwordAttempt, "12", "12"), 2);
		
		//remove from database
		assertEquals(usernameAttempt, dataConnection.deleteUser(usernameAttempt));
		assertFalse(dataConnection.userExists(usernameAttempt));
		
		
		dataConnection.close(); 
	}

}
