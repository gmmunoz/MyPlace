package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Matches_Controller {

    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;
    
    @FXML
    private TableView<dataClass> PossibleMatches;

    @FXML
    private TableColumn<dataClass,String> PlaceName;

    @FXML
    private TableColumn<dataClass, String> Address;

    @FXML
    void LogoutUser(ActionEvent event) {
    	System.out.println("You have officially logged out!");
        Stage stage = (Stage) LogoutBut.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SendUsertoPrevPage(ActionEvent event) throws IOException {
    	//now load previous page
    			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/SearchPlace.fxml"));
    			backgroundRoot.getChildren().setAll(pane);
    	    }
    
    //NEED TO FIGURE OUT HOW TO CREATE A PERSONALIZED TABLE WITH ADD BUTTON ATTACHED TO EACH RESULT
    //https://stackoverflow.com/questions/16228502/display-items-from-a-database-in-a-javafx-tableview
    
    
    public class dataClass{
    
    }
}