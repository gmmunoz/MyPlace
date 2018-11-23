import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import application.DataConnection;

public class Login_Test {

	DataConnection dataConnection = new DataConnection(); 
	
	/* Test valid login credentials*/
	@Test
	void login_valid() throws Exception {
		String usernameTest = "test"; 
		String passwordTest = "test123"; 
		String securityqTest = "12"; 
		
		dataConnection.addUser(usernameTest, passwordTest, securityqTest, securityqTest); 
		
		assertTrue(dataConnection.userExists(usernameTest));
		dataConnection.deleteUser(usernameTest); 
		
	}
	
	/* Test invalid login credentials -- empty strings*/
	@Test
	void login_emptyField() throws Exception {
		String usernameAttempt = ""; 
		String passwordTest = ""; 
		String securityqTest = "12"; 
		
		assertFalse(dataConnection.validAccount(usernameAttempt, passwordTest)); 
		
	}
	
	/* Test invalid login credentials -- wrong password*/
	@Test
	void login_wrongPassword() throws Exception{
		String usernameTest = "test"; 
		String passwordTest = "test123"; 
		String securityqTest = "12"; 
		
		assertTrue(dataConnection.addUser(usernameTest, passwordTest, securityqTest, securityqTest) == 3); 
		
		String incorrectPassword = "Test12"; 
		assertFalse(dataConnection.validAccount(usernameTest, incorrectPassword));
		dataConnection.deleteUser(usernameTest);
	}
	

}
