import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import application.Place;

public class Place_Test {
	
	@Test
	void placeConstructor() {
		final String dummyName = "Columbia University";
		final String dummyAddress = "535 West 116th Street New York, NY 10027"; 
		
		//create Place object
		Place columbia = new Place(dummyName, dummyAddress); 
		
		assertEquals(columbia.getPlaceName(), dummyName);
		assertEquals(columbia.getPlaceAddress(), dummyAddress); 
		
	}

}
