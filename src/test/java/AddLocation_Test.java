import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import application.DataConnection;
import application.Place;


public class AddLocation_Test {
	
	DataConnection dataConnection = new DataConnection(); 
	
	/*  Add location with valid fields */
	@Test
	void addLocation_valid() throws Exception {
		String locationNameTest = "testName";
		String locationAddressTest = "testAddress";
		
		Place place = new Place(locationNameTest, locationAddressTest, null);
		
		
	}
	
	/* Add location with invalid fields */
	
}
