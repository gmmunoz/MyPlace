import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import application.DataConnection;
import application.Place;
import application.PlaceSearch;

public class PlaceSearch_Test {
	
	/* Test valid search input -- isValid should return True */
	@Test 
	void searchInput_AllValid() throws Exception {
		final String search_Thing = "pizza"; 
		final String search_City = "Chicago"; 
		
		PlaceSearch placeSearch = new PlaceSearch(search_Thing, search_City); 
		assertTrue(placeSearch.isValidInput(search_Thing));
		
	}
	
	/* Test valid search input -- isValid should return True */
	@Test 
	void searchInput_valid() throws Exception {
		final String search_Thing = "pizza"; 
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertTrue(placeSearch.isValidInput(search_Thing));
		
	}
	
	/* Test valid search input -- isValid should return True */
	@Test 
	void searchInput_Empty() throws Exception {
		final String search_Thing = ""; 
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertTrue(placeSearch.isValidInput(search_Thing));
		
	}
	
	/* Test invalid search input -- user uses non-alphabetic characters*/
	@Test 
	void searchInput_invalid() throws Exception {
		final String search_Thing = "pizza123"; 
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertFalse(placeSearch.isValidInput(search_Thing));
		
	}
	
	/* Test valid search input -- user inputs valid city input */
	@Test
	void searchCity_valid() throws Exception{
		final String search_City = "Chicago";
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertTrue(placeSearch.isValidInput_City(search_City));
		
	}
	
	/* Test valid search input -- user inputs valid city all uppercase */
	@Test
	void searchCity_Uppercase() throws Exception{
		final String search_City = "CHICAGO";
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertTrue(placeSearch.isValidInput_City(search_City));
		
	}
	
	/* Test valid search input -- user inputs valid city with space*/
	@Test
	void searchCity_Space() throws Exception{
		final String search_City = "New York";
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertTrue(placeSearch.isValidInput_City(search_City));
		
	}
	
	/* Test invalid search input -- user does not enter a city name */
	@Test
	void searchCity_Empty() throws Exception{
		final String search_City = "";
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertFalse(placeSearch.isValidInput_City(search_City));
		
	}
	
	/* Test invalid search input -- user enters a city name with non-alphabet characters */
	@Test
	void searchCity_invalid() throws Exception{
		final String search_City = "Chicago123";
		
		PlaceSearch placeSearch = new PlaceSearch(); 
		assertFalse(placeSearch.isValidInput_City(search_City));
		
	}
	
	/* Test JSONtoArray methods to ensure we are properly treating data coming from API*/
	@SuppressWarnings("unchecked")
	@Test
	void searchResults_test() throws FileNotFoundException, IOException, ParseException {	    
		Object obj = new JSONParser().parse(new FileReader("JSONObjectTest.txt"));
		JSONArray jsonArray = (JSONArray) obj;
	    
		System.out.println(jsonArray.get(0));
		
		//initialize expected
		JSONObject test = (JSONObject) jsonArray.get(0);
		//String place_name = (String) test.get("name");
		String place_name = "Raw South Juice Co"; 
		String place_add = "9804 SW 77th AveMiami, FL 33156United States"; 
	    Place rawSouth_test = new Place(place_name, place_add); 
	    ArrayList<Place> expected_result = new ArrayList<Place>();
	    expected_result.add(rawSouth_test);
	    
	    //test function 
	    JSONArray tester = new JSONArray();
	    tester.add((JSONObject) jsonArray.get(0));
	    PlaceSearch placeSearch_test = new PlaceSearch(); 
	    ArrayList<Place> placeSearch_result = placeSearch_test.convertJSONtoArrayList(tester); 
	    
	    assertEquals(placeSearch_result.get(0).getPlaceName(), expected_result.get(0).getPlaceName()); 
	    assertEquals(placeSearch_result.get(0).getPlaceAddress(), expected_result.get(0).getPlaceAddress()); 

	    
	}
	
	
	/* Test invalid search input -- user enters a valid city that is not in our city database */
//	@Test
//	void searchCity_nonexistant() throws Exception{
//		DataConnection dataConnection = new DataConnection(); 
//		
//		final String search_City = "Naples"; //COME BACK TO THIS -- NEED LIST TO TEST CITY NOT IN DATABASE
//		assertFalse(dataConnection.isValidCity(search_City)); 
//		
//		dataConnection.close();
//	}
//	
	/* Test valid search input -- user enters city in our city database */
//	@Test
//	void searchCity_existant() throws Exception {
//		DataConnection dataConnection = new DataConnection(); 
//		
//		final String search_City = "Miami"; //COME BACK TO THIS -- NEED LIST TO TEST CITY IN DATABASE
//		assertTrue(dataConnection.isValidCity(search_City)); 
//		
//		dataConnection.close();
//		
//	}
}

	
	/* Test empty search field -- all returned values should be from identified city*/
	/*@Test
	void results_TestCity() throws Exception {
		final String test_City = "Miami"; 
		
		PlaceSearch invalidSearch = new PlaceSearch("", test_City);
		ArrayList<Place> results_test_City = invalidSearch.getResults(); 
		
		assertTrue(results_test_City.size() > 0); 
		
		for(Place p : results_test_City) {
			assertTrue(p.getAddress().toLowerCase().contains(test_City.toLowerCase()));
		}
		
	}*/
	
	/* invalid location*/
	/*@Test
	void results_InvalidCity() throws Exception {
		final String search = "";
		final String invalid_City = "test";
		
		PlaceSearch invalidCity = new PlaceSearch(search, invalid_City); 
		assertEquals(invalidCity.getResults().size(), 0); 
		
	}*/
	
	/* city with a space in its name, i.e. New York City */
	/*@Test
	void results_Space() throws Exception {
		final String search = "";
		final String space_City = "New York City"; 
		
		PlaceSearch spaceCity = new PlaceSearch(search, space_City); 
		assertTrue(spaceCity.getResults().size() > 0); 
		
	}*/
	
	
	/* Misspelled search field -- should still return values */
	/*@Test
	void results_MisspelledSearch() throws Exception {
		final String test_misspelled_search = "pizha";
		final String test_City = "Miami";
	
		PlaceSearch misspelledSearch = new PlaceSearch(test_misspelled_search, test_City);
		assertTrue(misspelledSearch.getResults().size() == 0); 
	
	}*/	

//}
