package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

public class RetrievePwdController {

    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Button TryNowBut;

    
    @FXML
    void handleTryNow(ActionEvent event) {
    	
    	System.out.println("Retry to login with password!");    			    		 		  		
	
    	try {  				
    		AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MyPlace_login.fxml"));    				
    		backgroundRoot.getChildren().setAll(pane);
 			
    	} catch (Exception ex) {   				
    		ex.printStackTrace();    			
    	}

    }

}


