package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class RegisterController {
	
	ObservableList<String> questionList1 = FXCollections.observableArrayList("What is the name of your first pet?", "What is your mother's maiden name?","What is your dream job?");
		
	ObservableList<String> questionList2 = FXCollections.observableArrayList("What is your favorite color?", "What is your father's middle name?","What was your childhood nickname?");
	
	@FXML
    private AnchorPane backgroundRoot;
	
	@FXML
	private TextField txtUserName;
	  
	@FXML	
	private Button regBut;
	
	@FXML	
	private PasswordField Password;
		 
	@FXML	
	private ComboBox<String> Question1;
	
	@FXML	
	private ComboBox<String> Question2;
	
	@FXML
    private TextField q2answer;

    @FXML
    private TextField q1answer;
    
    @FXML
    private Button backBut;
    
    private DataConnection con = new DataConnection();
	
	
	 @FXML
	    void initialize() {
		 Question1.setValue("Security Question #1");
		 Question1.setItems(questionList1);
		 
		 Question2.setValue("Security Question #2");
		 Question2.setItems(questionList2);
		 
		ChangeListener max_length_listener = new ChangeListener(txtUserName, 20); //set max length for user name at 20 characters
		txtUserName.textProperty().addListener(max_length_listener);
		
		ChangeListener max_length_pass_listener = new ChangeListener(Password, 20); //set max length for user name at 20 characters
		Password.textProperty().addListener(max_length_pass_listener);
	 }
	@FXML	
	void handleRegBut(ActionEvent event) throws Exception {

		//NEED to save info into database (username/pwd/questions 1&2)
		//here is where you add info & save it to DB
		String userName = txtUserName.getText().trim();
		String passwd = Password.getText().trim();
		String q1_ans = q1answer.getText().trim();
		String q2_ans = q2answer.getText().trim();
		
		if (con.addUser(userName, passwd, q1_ans, q2_ans) == 3) {
			System.out.println("You are now registered! Now try to login! ");  
			//return to login page
			try {
				AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MyPlace_login.fxml"));
				backgroundRoot.getChildren().setAll(pane);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		else if (con.addUser(userName, passwd, q1_ans, q2_ans) == 2) {
			System.out.println("Username taken, please try again with new username");
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/UsernameTakenFXML.fxml"));
    		backgroundRoot.getChildren().setAll(pane);
		}
		else if (con.addUser(userName, passwd, q1_ans, q2_ans) == 1) {
			System.out.println("No fields can be left blank");
			
			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/FieldsLeftBlankFXML.fxml"));
    		backgroundRoot.getChildren().setAll(pane);
		}
	}
	
	@FXML
	void handleBackBut(ActionEvent event) throws Exception {
		System.out.println("Clicking back button");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MyPlace_login.fxml"));
		backgroundRoot.getChildren().setAll(pane);
	}
}
