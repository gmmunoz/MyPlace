package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchPlace_Controller {
	String name;
	String city;
	public SearchPlace_Controller() throws Exception {
	}

    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private TextField placeName;

    @FXML
    private Button SearchBut;

    @FXML
    private TextField City;
    
    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;

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
    void handleSearch(ActionEvent event) throws IOException {
    	name = placeName.getText();
    	System.out.println("this is name " + name);
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Matches.fxml"));
		backgroundRoot.getChildren().setAll(pane);
    	city = City.getText();
    	System.out.println("this is city " + city);
    }
    
    public String getName() {
    	
    	return this.name;
    }
    
    public String getCity() {
    	return this.city;
    }

    public void initialize() throws Exception {
    }
}
