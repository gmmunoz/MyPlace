import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import application.DataConnection;
import application.Place;


public class AddLocation_Test {
	
	DataConnection dataConnection; 
	
	//add dummy user
	//Name: test Pass: "123"
	final String userTest = "test"; 
	final String userPass = "123"; 
	final String dummyComment = "";
	
	void createAccount(String name, String pass) throws Exception {
		dataConnection.addUser(name, pass, pass, pass);
	}
	
	/* addLocation successfully adds places to database */
	@Test
	void addLocation_valid() throws Exception {	
		dataConnection = new DataConnection(); 
		
		if(dataConnection.userExists(userTest)) {
			dataConnection.deleteUser(userTest); 
		}
		createAccount(userTest, userPass); 
		
		final String locationNameTest = "testName";
		final String locationAddressTest = "testAddress";
		
		Place place = new Place(locationNameTest, locationAddressTest);
		
		if(dataConnection.placeInAccount(userTest, locationNameTest, 1)) {
			assertEquals(dataConnection.deleteLocation(place, userTest, 1), locationNameTest);
		}
		
		assertEquals(dataConnection.addLocation(place, userTest, 1, dummyComment), locationNameTest); 
		assertTrue(dataConnection.placeInAccount(userTest, locationNameTest, 1));
		
		assertEquals(dataConnection.deleteLocation(place, userTest, 1), locationNameTest);
		
		dataConnection.deleteUser(userTest);
		dataConnection.close();
	}
	
	
	/* deleteLocation successfully removes existing place from database */
	@Test
	void deleteLocation_test() throws Exception {
		dataConnection = new DataConnection();
		
		if(dataConnection.userExists(userTest)) {
			dataConnection.deleteUser(userTest);
		}
		createAccount(userTest, userPass);
		
		final String locationNameTest = "testName";
		final String locationAddressTest = "testAddress";
		
		Place place = new Place(locationNameTest, locationAddressTest);
		assertEquals(dataConnection.addLocation(place, userTest, 1, dummyComment), locationNameTest);
		assertTrue(dataConnection.placeInAccount(userTest, locationNameTest, 1));
		assertEquals(dataConnection.deleteLocation(place, userTest, 1), locationNameTest);
		assertFalse(dataConnection.placeInAccount(userTest, locationNameTest, 1));
		
		dataConnection.deleteUser(userTest);
		dataConnection.close();
			
	}

	
	/* deleteLocation attempts to remove non-existing place from database */
	@Test
	void deleteLocation_invalid() throws Exception {
		dataConnection = new DataConnection();
		
		if(dataConnection.userExists(userTest)) {
			dataConnection.deleteUser(userTest);
		}
		createAccount(userTest, userPass);
		
		final String locationINVALID_Test = "testINVALID";
		
		Place place = new Place(locationINVALID_Test, locationINVALID_Test);
		assertFalse(dataConnection.placeInAccount(userTest, locationINVALID_Test, 0));
		
		assertEquals(dataConnection.deleteLocation(place, userTest, 0), locationINVALID_Test); /*COME BACK TO THIS*/
		
		assertFalse(dataConnection.placeInAccount(userTest, locationINVALID_Test, 0));
		
		dataConnection.deleteUser(userTest);
		dataConnection.close();
		
	}
	
	
	/* loadPlaces successfully loads all places in a given user's list*/
	@Test
	void loadPlaces_test() throws Exception {
		dataConnection = new DataConnection(); 
		
		if(dataConnection.userExists(userTest)) {
			dataConnection.deleteUser(userTest);
		}
		createAccount(userTest, userPass);
		
		
		//dummy places
		final String n1 = "1"; //dummy name
		final String a1 = "1"; //dummy address
		final String n2 = "2"; //dummy name
		final String a2 = "2"; //dummy address
		
		//Dummy 1
		Place p1 = new Place(n1, a1);
		assertEquals(dataConnection.addLocation(p1, userTest, 1, dummyComment), p1.getPlaceName());
		
		//Dummy 2
		Place p2 = new Place(n2, a2);
		assertEquals(dataConnection.addLocation(p2, userTest, 1, dummyComment), p2.getPlaceName());
		
		ArrayList<ArrayList<String>> rs = dataConnection.loadPlaces(userTest, 1);
		assertTrue(rs.size()>0);
		
		dataConnection.deleteUser(userTest);
		dataConnection.close();
	}
		
	/* Test commentary */
	//All commentary valid, just need to ensure it works as expected
	@Test
	void commentary_test() throws Exception{
		dataConnection = new DataConnection(); 
		
		if(dataConnection.userExists(userTest)) {
			dataConnection.deleteUser(userTest);
		}
		createAccount(userTest, userPass);
		
		
		//dummy place
		final String n1 = "name_test"; //dummy name
		final String a1 = "address_test"; //dummy address
		final String commentTest = "comment_test"; 
		
		
		//Dummy -- when user enters a comment
		Place p1 = new Place(n1, a1);
		assertEquals(dataConnection.addLocation(p1, userTest, 1, commentTest), p1.getPlaceName());
		assertEquals(dataConnection.loadComment(userTest, p1.getPlaceName(), 1), commentTest);
		
		//when user does not enter any comment
		final String n2 = "name_test_2"; //dummy name
		final String a2 = "address_test_2"; //dummy address
		final String commentTest2 = ""; 
		Place p2 = new Place(n2, a2);
		assertEquals(dataConnection.addLocation(p2, userTest, 1, commentTest2), p2.getPlaceName());
		assertEquals(dataConnection.loadComment(userTest, p2.getPlaceName(), 1), commentTest2);
		
		dataConnection.deleteUser(userTest);
		dataConnection.close();
		
	}
		
}
	

