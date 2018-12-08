package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class YBInfo_Controller {

	private DataConnection dcon = null;
	
	public YBInfo_Controller() throws Exception {
		dcon = new DataConnection();
		//initialize();
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
    	
    	//set Name label
    	nameLabel.setText(selectInfo.getPlaceName());
    	//System.out.println("see if "+ selectInfo.getPlaceName());
    	
    	//set Addy label
//    	ArrayList<ArrayList<String>> list = dcon.loadPlaces(currUser.getUser(),1);
//		for(int i = 0; i < list.size(); i++ ) {    		    	
//			//placename compared to one selected
//			if(list.get(0).get(i) == selectInfo.getPlaceName()) {   		
//				String addy = dcon.loadPlaces(currUser.getUser(), 1).get(0).get(i);    		
//				addyLabel.setText(addy);
//			}
//		}
    	
    	//set Comment Label
    	String comment = dcon.loadComment(currUser.getUser(), selectInfo.getPlaceName(), 1);
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
		AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/ViewListofPlacesYB.fxml"));
		backgroundRoot.getChildren().setAll(pane);
    }
}
