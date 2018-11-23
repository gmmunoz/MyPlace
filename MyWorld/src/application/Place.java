package application;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Place {

	private String name; 
	private String address;
	private JSONArray similarVenues;
	
	
	//public Place() {
		// TODO Auto-generated constructor stub
	//}
	
	public Place(String returned_name, String returned_address, JSONArray returned_similarVenues) {
		name = returned_name;
		address = returned_address;
		similarVenues = returned_similarVenues;
	}
	
	public void printPlace() {
		System.out.println(name);
		System.out.println(address);
		System.out.println(similarVenues);
		
	}

}
