package application;

import java.io.IOException;
import java.net.URL;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
<<<<<<< HEAD
//import com.gluonhq.charm.glisten.control.TextField;
=======
>>>>>>> 502959c34cef7f5b49e1be7a669ef5d0fb0e1c6e

public class MyController implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	    @FXML
	    private TextField txtUserName;

	    @FXML
	    private PasswordField Password;

	    @FXML
	    private Button loginBut;

	    @FXML
	    private Button forgetPwd;

	    @FXML
	    private Button signupBut;

	   // private Connection con = null;
	    private PreparedStatement ps = null;
		private ResultSet rs = null;

		public MyController() {
			//con = ConnectionDB.connect();
		}
		
		 //action to register
	    @FXML
	    void signUp(ActionEvent event) throws Exception{
	    	try {
	    		System.out.println("You clicked Sign Up button");
	    		   
		    	Parent root = FXMLLoader.load(getClass().getResource("/RegisterFXML.fxml"));	    
		    	Scene scene = new Scene(root);	    
		    	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();	    
		    	stage.setTitle("Register");
		    	stage.setScene(scene);	  
		    	stage.show();
		    	
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    	}    	
	  
	    }
}    

