package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class ForgotPwdController {
	
	ObservableList<String> questionList = FXCollections.observableArrayList("What is your favorite color?","What is your father's middle name?","What was your childhood nickname?","What is the name of your first pet?", "What is your mother's maiden name?","What is your dream job?");
	 
	@FXML
	private AnchorPane backgroundRoot;
	 
    @FXML
    private Button forgotBut;

    @FXML
    private TextField userName;
    
    @FXML
    private ComboBox<String> SecQbox;

    @FXML
    private TextField answer1;

    @FXML
    void initialize() {
		 SecQbox.setValue("Security Question");
		 SecQbox.setItems(questionList);
    }
    
    @FXML
    void handleForgotBut(ActionEvent event) {
    	//check DB to see if username & answer to security question exist, if yes --> show pwd
    	
    	
    	
    	//return to login page			
    	System.out.println("Retrieve Password!");    			    		 		  		
    			
    	try {  				
    		AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/RetreivePwdFXML.fxml"));    				
    		backgroundRoot.getChildren().setAll(pane);
 			
    	} catch (Exception ex) {   				
    		ex.printStackTrace();    			
    	}
   
    }

}
