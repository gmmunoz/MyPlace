package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataConnection {
	
	private Connection c = null;
	
	public DataConnection() {
		
		try {
		   Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:myplace.db");
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
			account_statement.close();
			results.close();
			return true;
		}
		else {
			account_statement.close();
			results.close();
			return false;
		}
	}
	
	public boolean userExists(String user) throws Exception {
		PreparedStatement username_statement = c.prepareStatement("SELECT username FROM accounts WHERE username = ?");
		username_statement.setString(1, user);
		ResultSet results = username_statement.executeQuery();
		if (results.next()) {
			username_statement.close();
			results.close();
			return true;
		}
		else {
			username_statement.close();
			results.close();
			return false;
		}
	}
	
	public int addUser(String user, String pass, String answer1, String answer2) throws Exception {
		if (user.isEmpty() || pass.isEmpty() || answer1.isEmpty() || answer2.isEmpty()) {
			return 1; //1 corresponds to fields being empty
		}
		else if (userExists(user) == true) {
			return 2; //2 corresponds to username already being taken
		}
		else {
			PreparedStatement add_statement = c.prepareStatement("INSERT INTO accounts(username, password, answer1, answer2) VALUES(?,?,?,?)");
			add_statement.setString(1, user);
			add_statement.setString(2, pass);
			add_statement.setString(3, answer1);
			add_statement.setString(4, answer2);
			add_statement.executeUpdate();
			add_statement.close();
			return 3; //3 corresponds to account being added successfully
		}
	}
	
	public String deleteUser(String user) throws Exception {
		PreparedStatement delete_statement = c.prepareStatement("DELETE FROM accounts WHERE username = ?");
		delete_statement.setString(1, user);
		delete_statement.executeUpdate();
		delete_statement.close();
		System.out.println("Your account has been deleted");
		return user;
	}

	public String addLocation(Place location, String user, int which_list, String comment) throws Exception {
		String query = "INSERT INTO places(username, place_name, address, which_tab, comment) VALUES(?,?,?,?,?)";
		PreparedStatement addLocation = c.prepareStatement(query);
		addLocation.setString(1, user);
		addLocation.setString(2, location.getPlaceName());
		addLocation.setString(3, location.getPlaceAddress());
		addLocation.setInt(4, which_list);
		addLocation.setString(5, comment);
		addLocation.executeUpdate();
		addLocation.close();
		System.out.println("Successfully added location!");
		return location.getPlaceName(); //returns the name of the place that it added
	}
	
	//deletes location 
	public String deleteLocation(Place location, String user, int which_list) throws Exception{
		String query = "DELETE FROM places WHERE username = ? AND place_name = ? AND which_tab = ?";
		PreparedStatement delete_location = c.prepareStatement(query);
		delete_location.setString(1, user);
		delete_location.setString(2, location.getPlaceName());
		delete_location.setInt(3, which_list);
		delete_location.executeUpdate();
		delete_location.close();
		System.out.println("Successfully deleted a location from list.");
		return location.getPlaceName(); //returns the name of the place that it deleted
	}
	
	public ArrayList<ArrayList<String>> loadPlaces(String user, int which_list) throws Exception {
		String query = "SELECT place_name, address FROM places WHERE username = ? AND which_tab = ?";
		PreparedStatement load_places = c.prepareStatement(query);
		load_places.setString(1, user);
		load_places.setInt(2, which_list);
		ResultSet results = load_places.executeQuery();
		ArrayList<ArrayList<String>> string_results = new ArrayList<>();
		while (results.next()) {
			ArrayList<String> this_result = new ArrayList<>();
			this_result.add(results.getString("place_name"));
			this_result.add(results.getString("address"));
			string_results.add(this_result);
		}
		return string_results;
	}
	
	public String securityQuestionCheck(String user, String answer1, String answer2) throws Exception {
		if (user.isEmpty() || answer1.isEmpty() || answer2.isEmpty()) {
			return "fieldsBlank"; 
		}
		else {
			String query = "SELECT password FROM accounts WHERE username = ? AND answer1 = ? AND answer2 = ?";
			PreparedStatement checkQuestions = c.prepareStatement(query);
			checkQuestions.setString(1, user);
			checkQuestions.setString(2,  answer1);
			checkQuestions.setString(3, answer2);
			ResultSet results = checkQuestions.executeQuery();
			if (results.next()) {
				String retrieved_password = results.getString("password");
				return retrieved_password;
			}
			else {
				return "noMatchingAccount";
			}
		}
	}
	
	public boolean placeInAccount(String user, String place, int which_list) throws SQLException {
		String query = "SELECT place_name FROM places WHERE username = ? AND place_name = ? AND which_tab = ?";
		PreparedStatement checkPlace = c.prepareStatement(query);
		checkPlace.setString(1, user);
		checkPlace.setString(2,  place);
		checkPlace.setInt(3,  which_list);
		ResultSet results = checkPlace.executeQuery();
		if (results.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//loads comment
	public String loadComment(String user, String place, int which_list) throws SQLException {
		String query = "SELECT comment FROM places WHERE username = ? AND place_name = ? AND which_tab = ?";
		PreparedStatement getComment = c.prepareStatement(query);
		getComment.setString(1, user);
		getComment.setString(2,  place);
		getComment.setInt(3,  which_list);
		ResultSet rs = getComment.executeQuery();
		String string_results = "";
		
		if(rs.next()) {
			string_results = rs.getString("comment");
			return string_results;
			
		} else {
			String noComment = "No comment";
			return noComment;

		}
	}
	
	
	public void close() throws Exception {
		c.close();
	}
}
