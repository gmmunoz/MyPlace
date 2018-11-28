import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import application.DataConnection;
import application.Place;


public class AddLocation_Test {
	
	DataConnection dataConnection; 
	
	//add dummy user
	//Name: test Pass: "123"
	final String userTest = "test"; 
	final String userPass = "123"; 
	
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
		
		if(dataConnection.placeInAccount(userTest, locationNameTest, 0)) {
			assertEquals(dataConnection.deleteLocation(place, userTest, 0), locationNameTest);
		}
		
		assertEquals(dataConnection.addLocation(place, userTest, 0), locationNameTest); 
		assertTrue(dataConnection.placeInAccount(userTest, locationNameTest, 0));
		
		assertEquals(dataConnection.deleteLocation(place, userTest, 0), locationNameTest);
		
		dataConnection.close();
	}
	
	
	/* deleteLocation successfully removes existing place from database */
	@Test
	void deleteLocation_test() throws Exception {
		dataConnection = new DataConnection(); 
		
		final String locationNameTest = "testName";
		final String locationAddressTest = "testAddress";
		
		Place place = new Place(locationNameTest, locationAddressTest);
		assertEquals(dataConnection.addLocation(place, userTest, 0), locationNameTest); 
		assertTrue(dataConnection.placeInAccount(userTest, locationNameTest, 0));
		assertEquals(dataConnection.deleteLocation(place, userTest, 0), locationNameTest);
		assertFalse(dataConnection.placeInAccount(userTest, locationNameTest, 0)); 
		
		dataConnection.close();
			
	}

	
	/* deleteLocation attempts to remove non-existing place from database */
	@Test
	void deleteLocation_invalid() throws Exception {
		dataConnection = new DataConnection(); 
		
		final String locationINVALID_Test = "testINVALID";
		
		Place place = new Place(locationINVALID_Test, locationINVALID_Test);
		assertFalse(dataConnection.placeInAccount(userTest, locationINVALID_Test, 0));
		
		assertEquals(dataConnection.deleteLocation(place, userTest, 0), locationINVALID_Test); /*COME BACK TO THIS*/
		
		assertFalse(dataConnection.placeInAccount(userTest, locationINVALID_Test, 0)); 
		
		dataConnection.close();
		
	}
	
	
	/* loadPlaces successfully loads all places in a given user's list*/
	/*@Test
	void loadPlaces_test() throws Exception {
		//dummy places
		final String n1 = "1"; //dummy name
		final String a1 = "1"; //dummy address
		final String n2 = "2"; //dummy name
		final String a2 = "2"; //dummy address
		
		//Dummy 1
		Place p1 = new Place(n1, a1); 
		assertEquals(dataConnection.addLocation(p1, userTest, 0), n1);
		
		//Dummy 2
		Place p2 = new Place(n2, a2); 
		assertEquals(dataConnection.addLocation(p2, userTest, 0), n2);
		
		ResultSet rs = dataConnection.loadPlaces(userTest, 0); 
		while(rs.next()) {
			assertTrue(rs.getString(0), ); 
		}*/
		
		
		
	}
	

