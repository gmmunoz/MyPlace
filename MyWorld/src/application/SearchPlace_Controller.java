package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchPlace_Controller {
	String name;
	String city;
	
	ArrayList<String> stringPlaces = new ArrayList<String>();
	ObservableList<String> data;
	
	public SearchPlace_Controller() throws Exception {
		initialize();
		data = FXCollections.observableList(stringPlaces);
	}
	
	@FXML
    private AnchorPane backgroundRoot;

    @FXML
    private AnchorPane backgroundRoot1;

    @FXML
    private AnchorPane backgroundRoot2;

    @FXML
    private TextField placeName;

    @FXML
    private AnchorPane backgroundRoot3;

    @FXML
    private TextField City;

    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;

    @FXML
    private ComboBox<String> MatchesList;

    @FXML
    private Button SearchBut;
	

    public ArrayList<String> initialize() throws Exception {
    	System.out.println("this is from matches " + name + " "+ city);
    	
    	PlaceSearch searchResults = new PlaceSearch(name,city);
    	ArrayList<Place> searchPlaces = searchResults.getResults();
    	
    	System.out.println("OKAY LETS GO: " + searchPlaces);
    	
    	try {
    		for(int i = 0; i< searchPlaces.size(); i++) {
    			String entry = searchPlaces.get(i).getPlaceName() + " " + searchPlaces.get(i).getPlaceAddress();
    			stringPlaces.add(entry);
    			System.out.println("This is an entry: " + entry);
    		} 
    	    MatchesList.setValue("Potential Matches");
    		MatchesList.setItems(data);
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
		return stringPlaces;
    }

    @FXML
    void LogoutUser(ActionEvent event) {
    	System.out.println("You have officially logged out!");
        Stage stage = (Stage) LogoutBut.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SendUsertoPrevPage(ActionEvent event) throws IOException {
    	//now load previous page
    			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Options.fxml"));
    			backgroundRoot.getChildren().setAll(pane);
    	    }

	public boolean isValid(String input) {
		return input.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
	}
    //handle search --> integrate with API
    //send to page with possible matches
    @FXML
    ArrayList<String> handleSearch(ActionEvent event) throws Exception {
    	//check for fields being filled in 
    	if(placeName.getText().trim().isEmpty() || City.getText().trim().isEmpty()) {
    		System.out.println("Please fill in both fields!");
    		return null;
    	}
    	name = placeName.getText();
    	city = City.getText();
<<<<<<< HEAD
    	//both fields are filled, checking for special characters
    	if(!isValid(name) || !isValid(city)) {
    		System.out.println("Please enter valid entries!");
    		return null;
    	}
//    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Matches.fxml"));
//		backgroundRoot.getChildren().setAll(pane);
=======
>>>>>>> fda17f65c22a1a48b21b2bb94a273d9e957c0e52
    	System.out.println("this is name " + name + " " + city);
    	return initialize();
    }
    
    public String getName() {
    	
    	return this.name;
    }
    
    public String getCity() {
    	return this.city;
    }

    
}
