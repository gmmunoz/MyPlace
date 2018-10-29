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
	    void initialize() {
		 Question1.setValue("Security Question #1");
		 Question1.setItems(questionList1);
		 
		 Question2.setValue("Security Question #2");
		 Question2.setItems(questionList2);
	 }
	@FXML	
	void handleRegBut(ActionEvent event) {

		//NEED to save info into database (username/pwd/questions 1&2)
		//here is where you add info & save it to DB
		
		//return to login page
		System.out.println("You are now registered! Now try to login! ");    			    		 		  		
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MyPlace_login.fxml"));
			backgroundRoot.getChildren().setAll(pane);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
				   
	}	
}
