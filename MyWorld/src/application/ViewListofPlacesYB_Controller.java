package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewListofPlacesYB_Controller {
	
	private DataConnection dcon = null;

	public ViewListofPlacesYB_Controller() throws Exception{
		dcon = new DataConnection();
	}
	
    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;

    @FXML
    private Button AddBut;

    
    private ObservableList<String> data = FXCollections.observableArrayList();
    
    @FXML
    private Button seePlaces;
    
    @FXML
    private TextField userName;
    
    @FXML
    private ListView<String> listNames;
    
    @FXML
    private Button seeListBut;

    @FXML
    void handleDisplay(ActionEvent event) throws Exception{
    	AccountTracker currUser = new AccountTracker();
    	ArrayList<ArrayList<String>> list = dcon.loadPlaces(currUser.getUser(),1);
		for(int i = 0; i < list.size(); i++ ) {
			String name = dcon.loadPlaces(currUser.getUser(), 1).get(i).get(0);
			data.add(name);
			System.out.println(name);
		}
		listNames.setItems(data);	
    }

    @FXML
    void AddPlace(ActionEvent event) throws IOException {
    	//now load Add a place page
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/SearchPlace.fxml"));
    	backgroundRoot.getChildren().setAll(pane);
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
    			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MainFramework.fxml"));
    			backgroundRoot.getChildren().setAll(pane);
    }

}
