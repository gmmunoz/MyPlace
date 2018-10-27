package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

//import com.gluonhq.charm.glisten.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

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

	    private Connection con = null;
	    private PreparedStatement ps = null;
		private ResultSet rs = null;

		public MyController() {
			con = ConnectionDB.connect();
		}
		
		 //action to register
	    @FXML
	    void signUp(ActionEvent event) throws IOException{
	    	Parent root = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));

			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Register");
			stage.show();
	    }
	    
	    //action to attempt to login
	    //@MICHAELLA LOOK HERE FOR SQL
	    @FXML
	    void logIn(ActionEvent event) {
	    	// decipher inputed username & password
			String userName = txtUserName.getText().trim();
			String passwd = Password.getText().trim();

			// SQL connect now
			String sql = "SELECT * user WHERE userName = ? AND passwd = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, passwd);
				rs = ps.executeQuery();

				if (rs.next()) {
					// this where new page fxml gets loaded
					Parent root = FXMLLoader.load(getClass().getResource("MainPageFXML.fxml"));

					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Main Page");
					stage.show();

				} else {
					// show error --> try again
					// NEED TO CREATE WRONG PASSWORD FXML
					Parent root = FXMLLoader.load(getClass().getResource("WrongTryAgainFXML.fxml"));

					Stage wrongStage = new Stage();
					wrongStage.setScene(new Scene(root));
					wrongStage.setTitle("Wrong Username or Password");
					wrongStage.centerOnScreen();
					wrongStage.show();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	   

	    //Action to retrieve forgotten password
	    @FXML
	    void retrievePwd(ActionEvent event) throws IOException {
	    	// load forgot password page
			Parent root = FXMLLoader.load(getClass().getResource("ForgotPasswordFXML.fxml"));

			Stage wrongStage = new Stage();
			wrongStage.setScene(new Scene(root));
			wrongStage.setTitle("Retrieve Password");
			wrongStage.centerOnScreen();
			wrongStage.show();
		}

}
