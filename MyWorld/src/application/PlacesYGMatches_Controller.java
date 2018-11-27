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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PlacesYGMatches_Controller {
	ArrayList<String> stringPlaces = new ArrayList<String>();
	ObservableList<String> data;
	
	//private DataConnection dcon = null;
	 
	public PlacesYGMatches_Controller() throws Exception {
		//dcon = new DataConnection();
		initialize();
		data = FXCollections.observableArrayList(stringPlaces);
	}
    @FXML
    private AnchorPane backgroundRoot2;

    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;

    @FXML
    private ComboBox<String> MatchesList;

    @FXML
    private Button addPageBut;

    @FXML
    void addPlacetoDB(ActionEvent event) {
    	//dcon.addLocation(location, user, which_list);

    }

 
    @FXML
    void LogoutUser(ActionEvent event) {
    	System.out.println("You have officially logged out!");
        Stage stage = (Stage) LogoutBut.getScene().getWindow();
        stage.close();
    }

    public ArrayList<String> initialize() throws Exception {
    	PlaceSearch searchResults = new PlaceSearch("pizza", "Chicago");
    	ArrayList<Place> searchPlaces = searchResults.getResults();
    	try {
    		for(int i = 0; i< searchPlaces.size(); i++) {
    			String entry = searchPlaces.get(i).getPlaceName() + " " + searchPlaces.get(i).getPlaceAddress();
    			stringPlaces.add(entry);
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
    void SendUsertoPrevPage(ActionEvent event) throws IOException {
    	//now load previous page
    			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/SearchPlacesYG.fxml"));
    			backgroundRoot2.getChildren().setAll(pane);
    	    }
  
}