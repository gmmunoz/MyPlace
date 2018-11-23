package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainFramework_Controller {

    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private Button PlacesYGbut;

    @FXML
    private Button PlacesYBbut;

    @FXML
    private Button LogoutBut;

    @FXML
    void DirectPlacesYB(ActionEvent event) throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Options.fxml"));
		backgroundRoot.getChildren().setAll(pane);
    }

    @FXML
    void DirectPlacesYG(ActionEvent event) throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Options.fxml"));
		backgroundRoot.getChildren().setAll(pane);
    }

    //logs out user
    @FXML
    void LogoutUser(ActionEvent event) {
    	System.out.println("You have officially logged out!");
        Stage stage = (Stage) LogoutBut.getScene().getWindow();
        stage.close();
    }
}

