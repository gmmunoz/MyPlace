package application;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Place {

	public String name; 
	public String address;
	//private JSONArray similarVenues;
	
	
	//public Place() {
		// TODO Auto-generated constructor stub
	//}
	
	public Place(String returned_name, String returned_address/*, JSONArray returned_similarVenues*/) {
		name = returned_name;
		address = returned_address;
		//similarVenues = returned_similarVenues;
	}
	
	public String getPlaceName() {
		return name;
	}
	
	/*public String getPlaceAddress() {
		return address;
	}*/
	
	/*public JSONArray getSimilarVenues() {
		return similarVenues;
	}*/
	
	public void printPlace() {
		System.out.println(name);
		System.out.println(address);
		//System.out.println(similarVenues);
		
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	
	/*public JSONArray getSimVenues() {
		return similarVenues; 
	}*/

}
