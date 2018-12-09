package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class YGInfo_Controller {

	private DataConnection dcon = null;

	public YGInfo_Controller() throws Exception{
		dcon = new DataConnection();
	}
	

    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;

    @FXML
    private Label nameLabel;

    @FXML
    private Label addyLabel;

    @FXML
    private Label comLabel;

    @FXML
    private Button seeInfoBut;

    @FXML
    void handleDisplayInfo(ActionEvent event) throws Exception {
    	TrackingInfo selectInfo = new TrackingInfo();
    	AccountTracker currUser = new AccountTracker();
    	String name = selectInfo.getPlaceName();
    	
    	//set Name label
    	nameLabel.setText(selectInfo.getPlaceName());
    	//System.out.println("see if "+ selectInfo.getPlaceName());
    	
    	//set Addy label
    	ArrayList<ArrayList<String>> list = dcon.loadPlaces(currUser.getUser(),2);
		for(int i = 0; i < list.size(); i++ ) {    		    	
			if(list.get(i).get(0).equalsIgnoreCase(name)) {   		
				String addy = dcon.loadPlaces(currUser.getUser(), 2).get(i).get(1);    	
				//System.out.println(addy);
				addyLabel.setText(addy);
				break;
				}
		}
    	
    	//set Comment Label
    	String comment = dcon.loadComment(currUser.getUser(), selectInfo.getPlaceName(), 2);
    	//System.out.println(comment);
    	comLabel.setText(comment);
    	   	    	
    }
    
    @FXML
    void LogoutUser(ActionEvent event) {
    	System.out.println("You have officially logged out!");
        Stage stage = (Stage) LogoutBut.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SendUsertoPrevPage(ActionEvent event) throws Exception {
    	//now load previous page
		AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Options.fxml"));
		backgroundRoot.getChildren().setAll(pane);
    }
}
	
