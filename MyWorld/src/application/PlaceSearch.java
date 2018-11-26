package application;

import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class PlaceSearch {
	
	private String place_name;
	private String city;
	private String foursquare_id = "YF1RC14OTL1V3HOKOWRRYL4XNSHD2ZLBBLIXBNUONLNPM40J";
	private String foursquare_secret = "CXYEIKYBNRQBTS2JIBSO4OG1QL5YNPMWX01SLHMGXE3ABVJB";
	private String v = "20181122";
	private DataConnection dataConn = null;

	public PlaceSearch() {
	}
	
	public PlaceSearch(String name, String city_name) {
		place_name = name;
		city = city_name;
		dataConn = new DataConnection();
	}
	
	public ArrayList<Place> getResults() throws Exception {
			
		URL url = new URL("https://api.foursquare.com/v2/venues/search?near=" + city + "&query=" + place_name + "&v=" + v + "&client_id=" + foursquare_id + "&client_secret=" + foursquare_secret);
	    HttpURLConnection con = (HttpURLConnection) url.openConnection();
	    con.setRequestMethod("GET");
	    con.connect();
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer content = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	        content.append(inputLine);
	    }
	    in.close();
	    
	    BufferedWriter out = new BufferedWriter(new FileWriter(new File("output.txt")));	    
	    out.append(content);	    
	    out.flush();
	    out.close();

	    
	    Object obj = new JSONParser().parse(new FileReader("output.txt"));
	    ArrayList<Place> locationList = new ArrayList<>();
	    JSONObject jsonObject = (JSONObject) obj;
	    JSONObject jsonObj = (JSONObject) jsonObject.get("response");
	    JSONArray jsonArray = (JSONArray) jsonObj.get("venues");
	    
	    //System.out.println(jsonObject);
	    //System.out.println(jsonArray);
	    
	    //@SuppressWarnings("unchecked")
		//Iterator<Object> iterator = array.iterator();
	    //while (iterator.hasNext()) {
	    	//Object it = iterator.next();
	    
	    for (int x = 0; x < jsonArray.size(); x++) {
	    	JSONObject data = (JSONObject) jsonArray.get(x);
	    	String venue_id = (String) (data.get("id"));
	    	
	    	String name = (String) data.get("name");
	    	
	    	JSONObject loc = (JSONObject) data.get("location");
	    	JSONArray formattedAddress = (JSONArray) loc.get("formattedAddress");    	
	    	String fullAddress = "";
		    for (int j = 0; j < formattedAddress.size(); j++) {
		    	String address_line = (String) formattedAddress.get(j);
		    	fullAddress = fullAddress + address_line;
		    }
	    	
	    	URL venue_url = new URL("https://api.foursquare.com/v2/venues/" + venue_id + "/similar" + "?v=" + v + "&client_id=" + foursquare_id + "&client_secret=" + foursquare_secret);
	    	HttpURLConnection venue_con = (HttpURLConnection) venue_url.openConnection();
	    	venue_con.setRequestMethod("GET");
	    	venue_con.connect();
	    	
		    BufferedReader venue_in = new BufferedReader(new InputStreamReader(venue_con.getInputStream()));
		    String venue_inputLine;
		    StringBuffer venue_content = new StringBuffer();
		    while ((venue_inputLine = venue_in.readLine()) != null) {
		        venue_content.append(venue_inputLine);
		    }
		    venue_in.close();
		    
		    //System.out.println(venue_content);
		    
		    BufferedWriter venue_out = new BufferedWriter(new FileWriter(new File("venue_output.txt")));
		    venue_out.append(venue_content);		    
		    venue_out.flush();		    
		    venue_out.close();	    	
		    venue_con.connect();
		    
		    Object venue_obj = new JSONParser().parse(new FileReader("venue_output.txt"));
		    
		    JSONObject venue_object = (JSONObject) venue_obj;
		    
		    JSONObject response = (JSONObject) venue_object.get("response");
		    JSONObject simVen = (JSONObject) response.get("similarVenues");
		    JSONArray simVenItems = (JSONArray) simVen.get("items");
		    
		    //System.out.println(similarVenues);
		    
	    	Place new_place = new Place(name, fullAddress, simVenItems);
	    	
	    	locationList.add(new_place);
	    	ObservableList<Place> locationsDropDown = FXCollections.observableArrayList(locationList);
	    }
	    
	    return locationList;
	}
}
