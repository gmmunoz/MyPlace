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

public class ViewListofPlacesYB_Controller {

    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;

    @FXML
    private Button AddBut;

    @FXML
    private TableView<dataClass> PinnedPlaces;

    @FXML
    private TableColumn<dataClass,String> PlaceNameCol;

    @FXML
    private TableColumn<dataClass,String> AddressCol;

    @FXML
    private TableColumn<dataClass,String> CommentCol;

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
    
    public class dataClass{
    //2 --> places YB
    }

}
