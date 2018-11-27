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
		dcon = new DataConnection();
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
    
    @FXML
    private Button addBut;

    private DataConnection dcon = null;
    
    @FXML
    void AddPlaceYBtoDB(ActionEvent event) throws IOException {
    	String selected = MatchesList.getSelectionModel().getSelectedItem().toString();
    	System.out.println("please work " + selected);
    	//dcon.addLocation(selected, user, 1);
    	System.out.println("Location has been added!");
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MainFramework.fxml"));
		backgroundRoot.getChildren().setAll(pane);
    }
	

    public ArrayList<String> initialize() throws Exception {
    	//System.out.println("this is from matches " + name + " "+ city);
    	
    	PlaceSearch searchResults = new PlaceSearch(name,city);
    	ArrayList<Place> searchPlaces = searchResults.getResults();
    	
    	//System.out.println("OKAY LETS GO: " + searchPlaces);
    	
    	try {
    		for(int i = 0; i< searchPlaces.size(); i++) {
    			String entry = searchPlaces.get(i).getPlaceName() + " " + searchPlaces.get(i).getPlaceAddress();
    			stringPlaces.add(entry);
    		} 
    	    MatchesList.setValue("Select Potential Match");
    		MatchesList.setItems(data);
    	}
    	catch(Exception e) {
    		System.out.println("An error occured while searching!");
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

    //handle search --> integrate with API
    //send to page with possible matches
    @FXML
    ArrayList<String> handleSearch(ActionEvent event) throws Exception {
    	name = placeName.getText();
    	city = City.getText();
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
