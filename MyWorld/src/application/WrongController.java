package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class WrongController {
	
	@FXML
    private AnchorPane backgroundRoot;
	
    @FXML
    private Button TryAgainBut;

    @FXML
    void returnBack(ActionEvent event) throws IOException {
    	try {	
    		System.out.println("You clicked try again button!");    			    		 		  
		
    		AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MyPlace_login.fxml"));		
    		backgroundRoot.getChildren().setAll(pane);
		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}

    }

}
