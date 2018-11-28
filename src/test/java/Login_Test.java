import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import application.DataConnection;

public class Login_Test {

	DataConnection dataConnection; 
	
	/* Test valid login credentials*/
	@Test
	void login_valid() throws Exception {
		dataConnection = new DataConnection(); 
		
		String usernameTest = "test"; 
		String passwordTest = "test123"; 
		String securityqTest = "12"; 
		
		dataConnection.addUser(usernameTest, passwordTest, securityqTest, securityqTest); 
		
		assertTrue(dataConnection.userExists(usernameTest));
		dataConnection.deleteUser(usernameTest); 
		
		dataConnection.close();
		
	}
	
	/* Test invalid login credentials -- empty strings*/
	@Test
	void login_emptyField() throws Exception {
		dataConnection = new DataConnection();
		
		String usernameAttempt = ""; 
		String passwordTest = ""; 
		String securityqTest = "12"; 
		
		assertFalse(dataConnection.validAccount(usernameAttempt, passwordTest)); 
		
		dataConnection.close();
		
	}
	
	/* Test invalid login credentials -- wrong password*/
	@Test
	void login_wrongPassword() throws Exception{
		dataConnection = new DataConnection(); 
		
		String usernameTest = "test"; 
		String passwordTest = "test123"; 
		String securityqTest = "12"; 
		
		assertTrue(dataConnection.addUser(usernameTest, passwordTest, securityqTest, securityqTest) == 3); 
		
		String incorrectPassword = "Test12"; 
		assertFalse(dataConnection.validAccount(usernameTest, incorrectPassword));
		dataConnection.deleteUser(usernameTest);
		
		dataConnection.close(); 
	}
	

}
