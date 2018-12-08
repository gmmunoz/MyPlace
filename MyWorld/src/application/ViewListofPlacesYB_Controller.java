package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewListofPlacesYB_Controller {
	
	private Stage window;
	private DataConnection dcon = null;

	public ViewListofPlacesYB_Controller() throws Exception{
		dcon = new DataConnection();
		initialize();
	}
	
    @FXML
    private AnchorPane backgroundRoot;

    @FXML
    private Button LogoutBut;

    @FXML
    private Button SendBackBut;

    @FXML
    private Button AddBut;

    @FXML
    private TableView<String> PinnedPlaces;
    
    private ObservableList<Place> data = FXCollections.observableArrayList();
    
    @FXML
    private Button seePlaces;
    
    @FXML
    private TextField userName;
    
    
    @FXML
    private TableColumn<String, String> columnName;
    
    @SuppressWarnings("unchecked")
	void initialize() throws Exception{
    	columnName.setCellValueFactory(c -> new SimpleStringProperty(new String("HELLO")));
		PinnedPlaces = new TableView<String>();
		PinnedPlaces.setId("WORKS");
    	PinnedPlaces.getColumns().addAll(columnName);
    	/*AccountTracker currUser = new AccountTracker();
    	ArrayList<ArrayList<String>> list = dcon.loadPlaces(currUser.getUser(),1);
		for(int i = 0; i < list.size(); i++ ) {
			String name = dcon.loadPlaces(currUser.getUser(), 1).get(i).get(0);
			String address = dcon.loadPlaces(currUser.getUser(), 1).get(i).get(1);
    		data.add(new Place(name,address));
    		System.out.println(name + " " + address);
		}*/
		/*columnName = new TableColumn<Place, String>();
		columnName.setCellValueFactory(new PropertyValueFactory<Place, String>("name"));
		
		//TableColumn<Place, String> addressColumn = new TableColumn<>("address");
		//addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		PinnedPlaces = new TableView<Place>();
		PinnedPlaces.setItems(data);
		PinnedPlaces.getColumns().addAll(columnName); */
		
//	dcon.close();
    }
    
	@FXML
    void viewList(ActionEvent event) throws Exception {
//		
//    	user = userName.getText();
//    	if(user == null) {
//    		System.out.println("Please input userName!");
//    	} else {
//    		ArrayList<ArrayList<String>> list = dcon.loadPlaces(user,1);
//    		for(int i = 0; i < list.size(); i++ ) {
//        		String name = dcon.loadPlaces(user, 1).get(i).get(0);
//        		//System.out.println(name);
//        		data.add(name);
//    		}
//    		System.out.print(data);
//    		PinnedPlaces.setItems(data);
//    	}
//    	dcon.close();
	}


    @FXML
    void AddPlace(ActionEvent event) throws IOException {
    	//now load Add a place page
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/SearchPlace.fxml"));
    	backgroundRoot.getChildren().setAll(pane);
    }

    @FXML
    void LogoutUser(ActionEvent event) {
    	System.out.println("You have officially logged out!");
        Stage stage = (Stage) LogoutBut.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SendUsertoPrevPage(ActionEvent event) throws IOException {
    	//now load previous page
    			AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/MainFramework.fxml"));
    			backgroundRoot.getChildren().setAll(pane);
    }
    

}
