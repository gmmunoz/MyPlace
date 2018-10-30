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
		PreparedStatement account_statement = c.prepareStatement("SELECT username, password FROM accounts WHERE username = ? AND password = ?");
		account_statement.setString(1, user);
		account_statement.setString(2, pass);
		ResultSet results = account_statement.executeQuery();
		if (results.next()) {
			/*String associated_pass = results.getString("password");
			if (associated_pass == pass) {
				return true;
			}*/
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean userExists(String user) throws Exception {
		PreparedStatement username_statement = c.prepareStatement("SELECT username FROM accounts WHERE username = ?");
		username_statement.setString(1, user);
		ResultSet results = username_statement.executeQuery();
		if (results.next()) {
			return true;
		}
		else {
			return false;
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
			PreparedStatement add_statement = c.prepareStatement("INSERT INTO accounts(username, password, q1_answer, q2_answer) VALUES(?,?,?,?)");
			add_statement.setString(1, user);
			add_statement.setString(2, pass);
			add_statement.setString(3, answer1);
			add_statement.setString(4, answer2);
			add_statement.executeUpdate();
			return true;
		}
	}
}
