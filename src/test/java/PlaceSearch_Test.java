import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.Place;
import application.PlaceSearch;

public class PlaceSearch_Test {
	
	PlaceSearch pizzaChicago; 
	
	/* Test valid search against dummy page */
	@Test 
	void results_complete() throws Exception {
		pizzaChicago = new PlaceSearch("pizza", "Chicago");
		ArrayList<Place> results = pizzaChicago.getResults(); 
		
		assertTrue(results.size() > 0); 
		
	}
	
	/* Test empty search field -- all returned values should be from identified city*/
	@Test
	void results_TestCity() throws Exception {
		final String test_City = "Miami"; 
		
		PlaceSearch invalidSearch = new PlaceSearch("", test_City);
		ArrayList<Place> results_test_City = invalidSearch.getResults(); 
		
		assertTrue(results_test_City.size() > 0); 
		
		for(Place p : results_test_City) {
			assertTrue(p.getAddress().toLowerCase().contains(test_City.toLowerCase()));
		}
		
	}
	
	/* invalid location*/
	@Test
	void results_InvalidCity() {
		final String search = "";
		final String invalid_City = "test";
		
		PlaceSearch invalidCity = new PlaceSearch(search, invalid_City); 
		assertEquals(invalidCity.getResults().size(), 0); 
		
	}
	
	/* city with a space in its name, i.e. New York City */
	@Test
	void results_Space() {
		final String search = "";
		final String space_City = "New York City"; 
		
		PlaceSearch spaceCity = new PlaceSearch(search, space_City); 
		assertTrue(spaceCity.getResults().size() > 0); 
		
	}
	
	
	/* Misspelled search field -- should still return values */
	@Test
	void results_MisspelledSearch() throws Exception {
		final String test_misspelled_search = "pizha";
		final String test_City = "Miami";
	
		PlaceSearch misspelledSearch = new PlaceSearch(test_misspelled_search, test_City);
		assertTrue(misspelledSearch.getResults().size() > 0); 
	
	}	

}
