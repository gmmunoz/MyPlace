package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.json.simple.*;


public class Matches_Controller {
	ArrayList<String> stringPlaces = new ArrayList<String>();
	ObservableList<String> data;
	
	//private DataConnection dcon = null;
	 
	public Matches_Controller() throws Exception {
		//dcon = new DataConnection();
		initialize();
		data = FXCollections.observableArrayList(stringPlaces);
	}


    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private AnchorPane backgroundRoot1;

    @FXML
    private AnchorPane backgroundRoot2;
    
    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;
    
    @FXML
    private Button addPageBut;

    @FXML
    private ComboBox<String> MatchesList;
    
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
    	//SearchPlace_Controller spController = new SearchPlace_Controller();
    	//System.out.println("this is from matches " + spController.getName());
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
    			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/SearchPlace.fxml"));
    			backgroundRoot.getChildren().setAll(pane);
    	    }
  
   
}