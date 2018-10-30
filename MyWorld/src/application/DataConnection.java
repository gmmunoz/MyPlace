package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataConnection {
	
	private Connection c = null;
	
	public DataConnection() {
		
		try {
		   Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:myplacedb.db");
	    } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
	
	public boolean validAccount(String user, String pass) throws Exception {
		PreparedStatement account_statement = c.prepareStatement("SELECT username, password FROM accounts WHERE username = 'user'");
		ResultSet results = account_statement.executeQuery();
		if (results.next()) {
			String associated_pass = results.getString("password");
			if (associated_pass == pass) {
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}
	
	public boolean userExists(String user) throws Exception {
		PreparedStatement username_statement = c.prepareStatement("SELECT username FROM accounts WHERE username = 'user'");
		ResultSet results = username_statement.executeQuery();
		if (results == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean addUser(String user, String pass, String answer1, String answer2) throws Exception {
		if (user == null || pass == null) {
			return false;
		}
		else if (userExists(user) == true) {
			return false;
		}
		else {
			PreparedStatement add_statement = c.prepareStatement("INSERT INTO accounts(username, password, q1_answer, q2_answer) VALUES(user, pass, answer1, answer2)");
			add_statement.executeUpdate();
			return true;
		}
	}
}
