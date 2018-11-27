package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

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
	
	ObservableList<String> questionList = FXCollections.observableArrayList("What is your mother's maiden name?");
	ObservableList<String> questionList2 = FXCollections.observableArrayList("What is your favorite color?");
	 
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
    private ComboBox<String> SecQbox2;

    @FXML
    private TextField answer2;
    
    @FXML
    void initialize() {
		 SecQbox.setValue("Security Question #1");
		 SecQbox.setItems(questionList);
		 SecQbox2.setValue("Security Question #2");
		 SecQbox2.setItems(questionList2);
    }
    
    private DataConnection con = new DataConnection();
    
    @FXML
    void handleForgotBut(ActionEvent event) throws Exception {
    	//check DB to see if username & answer to security question exist, if yes --> show pwd
    	
    	String user = userName.getText().trim();
    	String q1_answer = answer1.getText().trim();
    	String q2_answer = answer2.getText().trim();
    	
    	if (con.securityQuestionCheck(user, q1_answer, q2_answer).equals("fieldsBlank")) {
    		System.out.println("You cannot leave fields blank.");
    	}
    	
    	else if (con.securityQuestionCheck(user, q1_answer, q2_answer).equals("noMatchingAccount")) {
    		System.out.println("No matching account was found");
    	}
    	
    	else {
    		String retrieved_pass = con.securityQuestionCheck(user, q1_answer, q2_answer);
    		System.out.println(retrieved_pass);
    	}
    	
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
