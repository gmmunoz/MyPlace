 package application;

import java.sql.*;
import java.util.ArrayList;

import javax.xml.ws.http.HTTPException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.*;

public class PlaceSearch {
	
	private String place_name;
	private String city;
	private String foursquare_id = "1FFZZL5MNNBG2KJCB0H2UTN554BZOQXY4CHUTARLAL5WMJTT";
	private String foursquare_secret = "HMVC3IMTTWCXRLXBENBPXXBMXKJBTMXA5HFJVMWJJ3ZBHNOZ";
	private String v = "20181122";

	ArrayList<Place> locationList = new ArrayList<>();

	public PlaceSearch() {
	}
	
	public PlaceSearch(String name, String city_name) throws IOException {
		place_name = name;
		city = city_name;
		//dataConn = new DataConnection();
	}
	
	public boolean isValidInput(String input) {
		return input.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ) || input.trim().isEmpty();
	}
	
	public boolean isValidInput_City(String city) {
		return city.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ) && !city.trim().isEmpty();
	}
	
	//returns an observable array list of the results of a search
    public ArrayList<Place> getResults() throws Exception {
		String urlString = ("https://api.foursquare.com/v2/venues/search?near=" + city + "&query=" + place_name + "&v=" + v + "&client_id=" + foursquare_id + "&client_secret=" + foursquare_secret).replaceAll(" ", "%20");
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
	    try {
	    	int code = con.getResponseCode();
		    if (code == HttpURLConnection.HTTP_OK) {
		    	con.setRequestMethod("GET");
		    }
		    else if(code == HttpURLConnection.HTTP_BAD_REQUEST) {
		    	System.out.println("That city does not exist!");
		    }
	    }
	    catch(RuntimeException e) {
	    }
	    finally {
	    	con.connect();
	    }
	    try{
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
	    }
	    catch(IOException e){
	    	System.out.println("Please input a valid city name!");
	    }
	    
	    Object obj = new JSONParser().parse(new FileReader("output.txt"));
	    //ArrayList<Place> locationList = new ArrayList<>();
	    JSONObject jsonObject = (JSONObject) obj;
	    JSONObject jsonObj = (JSONObject) jsonObject.get("response");
	    JSONArray jsonArray = (JSONArray) jsonObj.get("venues");
	    System.out.println(jsonArray);
	    ArrayList<Place> result = convertJSONtoArrayList(jsonArray);
	    
	    //System.out.println(result.get(0).getPlaceName());
	    //System.out.println(result.get(0).getPlaceAddress());
	    
	    return result;
    }

	    
    public ArrayList<Place> convertJSONtoArrayList(JSONArray jsonArray) {	 
	    for (int x = 0; x < jsonArray.size(); x++) {
	    	JSONObject data = (JSONObject) jsonArray.get(x);
	    	//String venue_id = (String) (data.get("id"));
	    	
	    	String name = (String) data.get("name");
	    	
	    	JSONObject loc = (JSONObject) data.get("location");
	    	JSONArray formattedAddress = (JSONArray) loc.get("formattedAddress");    	
	    	String fullAddress = "";
		    for (int j = 0; j < formattedAddress.size(); j++) {
		    	String address_line = (String) formattedAddress.get(j);
		    	fullAddress = fullAddress + address_line;
		    }
	    	
	    	/*URL venue_url = new URL("https://api.foursquare.com/v2/venues/" + venue_id + "/similar" + "?v=" + v + "&client_id=" + foursquare_id + "&client_secret=" + foursquare_secret);
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
		    
		    //System.out.println(similarVenues);*/
		    
	    	Place new_place = new Place(name, fullAddress);
	    	locationList.add(new_place);
	    	ObservableList<Place> locationsDropDown = FXCollections.observableArrayList(locationList);
	    }
	    
	    return locationList;
	}
}

