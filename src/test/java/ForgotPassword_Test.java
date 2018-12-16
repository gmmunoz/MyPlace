import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import application.DataConnection;

public class ForgotPassword_Test {
	
	DataConnection dataConnection; 
	
	void createAccount(String username, String pass, String sq1, String sq2) throws Exception {
		
		if(dataConnection.userExists(username)) {
			dataConnection.deleteUser(username); 
		}
		
		dataConnection.addUser(username, pass, sq1, sq2); 
	}
	

	/* test valid forgotPassword input -- result should be successful login */
	@Test
	void forgotPassword_valid() throws Exception {		
		final String username = "test";
		final String password = "123";
		final String sq1 = "1234";
		final String sq2 = "123456"; 
		
		//create account
		dataConnection = new DataConnection(); 
		createAccount(username, password, sq1, sq2); 
		
		//test inputs -- if correct, should successfully retrieve password
		//System.out.println(dataConnection.securityQuestionCheck(username, sq1, sq2));
		//System.out.println(password); 
		assertTrue(dataConnection.userExists(username));
		assertEquals(dataConnection.securityQuestionCheck(username, sq1, sq2), password);
		
		//delete account
		dataConnection.deleteUser(username);
		dataConnection.close(); 
		
	}
	
	/* test invalid forgotPassword input -- invalid username*/
	@Test
	void forgotPassword_invalidUsername() throws Exception {
		final String username = "test";
		final String password = "123";
		final String sq = "123";
		
		//create account
		dataConnection = new DataConnection(); 
		createAccount(username, password, sq, sq); 
		
		final String username_invalid = "tst"; 
		//test inputs -- if incorrect, should return "noMatchingAccount"
		assertEquals(dataConnection.securityQuestionCheck(username_invalid, sq, sq), "noMatchingAccount");
		
		//delete account
		dataConnection.deleteUser(username);
		dataConnection.close();
		
	}
	
	/* test invalid forgotPassword input -- invalid security question1 */
	@Test
	void forgotPassword_invalidSQ() throws Exception {
		final String username = "test";
		final String password = "123";
		final String sq = "123";
		
		//create account
		dataConnection = new DataConnection(); 
		createAccount(username, password, sq, sq); 
		
		final String sq1_invalid = "12"; 
		//test inputs -- if incorrect, should return "noMatchingAccount"
		assertEquals(dataConnection.securityQuestionCheck(username, sq1_invalid, sq), "noMatchingAccount");
		assertEquals(dataConnection.securityQuestionCheck(username, sq, sq1_invalid), "noMatchingAccount"); 
		
		//delete account
		dataConnection.deleteUser(username);
		dataConnection.close();
		
	}
	
	/* test invalid forgotPassword input -- empty field, should return "fieldsBlank" */
	@Test
	void forgotPassword_emptyField() throws Exception {
		final String username = "test";
		final String password = "123";
		final String sq = "123";
		
		//create account
		dataConnection = new DataConnection(); 
		createAccount(username, password, sq, sq); 
		
		final String blank = ""; 
		//test inputs -- if empty field, should return "fieldsBlank"
		assertEquals(dataConnection.securityQuestionCheck(blank, sq, sq), "fieldsBlank");
		assertEquals(dataConnection.securityQuestionCheck(username, blank, sq), "fieldsBlank");
		assertEquals(dataConnection.securityQuestionCheck(username, sq, blank), "fieldsBlank");
		
		//delete account
		dataConnection.deleteUser(username);
		dataConnection.close(); 
		
	}
	
	

}
