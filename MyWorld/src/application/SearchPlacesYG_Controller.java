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

public class SearchPlacesYG_Controller {
		String name;
		String city;

		ArrayList<String> stringPlaces = new ArrayList<String>();
		
		public SearchPlacesYG_Controller() throws Exception {
			initialize();
			dcon = new DataConnection();
		}
		
		@FXML
	    private AnchorPane backgroundRootRoot;

	    @FXML
	    private AnchorPane backgroundRoot;

	    @FXML
	    private AnchorPane backgroundRoot1;

	    @FXML
	    private ComboBox<String> MatchesList;

	    @FXML
	    private TextField placeName;

	    @FXML
	    private AnchorPane backgroundRoot2;

	    @FXML
	    private Button SearchBut;

	    @FXML
	    private TextField City;
	    
	    @FXML
	    private TextField Comment;
	    
	    @FXML
	    private Button LogoutBut;

	    @FXML
	    private Button SendBackBut;

	    @FXML
	    private Button addBut;

	    private DataConnection dcon = null;

	    @FXML
	    void AddPlaceYBtoDB(ActionEvent event) throws Exception {
	    	String comment = Comment.getText();
	    	int selectedIndex = MatchesList.getSelectionModel().getSelectedIndex();
	    	
	    	PlaceSearch searchResults = new PlaceSearch(name,city);
	    	Place index = searchResults.getResults().get(selectedIndex);
	    	
	    	AccountTracker currUser = new AccountTracker();	
			if (dcon.placeInAccount(currUser.getUser(), index.getPlaceName(), 2) == false) {
				dcon.addLocation(index, currUser.getUser(), 2, comment);	
				System.out.println("You've successfully added this place to your list!");
				// Send back to main framework
				AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Options.fxml"));	
				backgroundRoot.getChildren().setAll(pane);
			} else {
				System.out.println("You've already added this place to your list!");	
			}
			//dcon.close();
			
	    }

	    	    
	    public ArrayList<String> initialize() throws Exception {
	    	ObservableList<String> data;
			data = FXCollections.observableArrayList();
	    	PlaceSearch searchResults = new PlaceSearch(name,city);
	    	ArrayList<Place> searchPlaces = searchResults.getResults();
	    		    	
	    	try {
	    		for(int i = 0; i< searchPlaces.size(); i++) {
	    			String entry = searchPlaces.get(i).getPlaceName() + " " + searchPlaces.get(i).getPlaceAddress();
	    			stringPlaces.add(entry);
	    			data.add(entry);
	    		} 
	    	    MatchesList.setValue("Potential Matches");
	    		MatchesList.setItems(data);
	    	}
	    	catch(Exception e) {
	    		System.out.println("An error occured while searching!");
	    	}
			return stringPlaces;
	    }

	    	
	    @FXML
	    void LogoutUser(ActionEvent event) throws Exception {
	    	dcon.close();
	    	System.out.println("You have officially logged out!");
	        Stage stage = (Stage) LogoutBut.getScene().getWindow();
	        stage.close();
	    }

	    @FXML
	    void SendUsertoPrevPage(ActionEvent event) throws Exception {
	    	//now load previous page
	    	dcon.close();
	    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Options.fxml"));
	   		backgroundRootRoot.getChildren().setAll(pane);
	    	    }

	    /*
	    public boolean isValid(String input) {
			return input.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
		}
	    */
	    
	    //handle search --> integrate with API
	    @FXML
	    ArrayList<String> handleSearch(ActionEvent event) throws Exception {
	    	//check for fields being filled in 
	    	if(placeName.getText().trim().isEmpty() || City.getText().trim().isEmpty()) {
	    		System.out.println("Please fill in both fields!");
	    		return null;
	    	}
	    	name = placeName.getText();
	    	city = City.getText();
	    	

	    	//both fields are filled, checking for special characters
	    	if(!isValid(name) || !isValid(city)) {
	    		System.out.println("Please enter valid entries!");
	    		return null;
	    	}
	    
	    	else {
	    		//System.out.println("this is name " + name + " " + city);
	    		return initialize();
	    	}
	    }
	    
	}
