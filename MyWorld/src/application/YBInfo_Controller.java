package application;

import java.io.IOException;
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
    void handleDisplayInfo(ActionEvent event) {
    	TrackingInfo selectInfo = new TrackingInfo();
    	System.out.println(selectInfo.getPlaceName());
    	nameLabel.setText(selectInfo.getPlaceName());
    	//AccountTracker currUser = new AccountTracker();	
    }
    
//    void initialize() throws Exception {
//    	AccountTracker currUser = new AccountTracker();
//    	ArrayList<ArrayList<String>> list = dcon.loadPlaces(currUser.getUser(),1);
//		for(int i = 0; i < list.size(); i++ ) {
//			if(list.)
//			String name = dcon.loadPlaces(currUser.getUser(), 1).get(i).get(0);
//			//data.add(name);
//			//System.out.println(name);
//			nameLabel.setText(name);
//		}
//    }
    
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
