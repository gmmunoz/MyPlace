package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ViewListofPlacesYB_Controller {
	
	private DataConnection dcon = null;
	String user;
	 @SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;

	public ViewListofPlacesYB_Controller() throws Exception{
		dcon = new DataConnection();
		
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
    
    @FXML
    private Button seePlaces;
    
    @FXML
    private TextField userName;
    
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    void viewList(ActionEvent event) throws Exception {
    	user = userName.getText();
    	if(user == null) {
    		System.out.println("Please input userName!");
    	} else {
    		ResultSet rs = dcon.loadPlaces(user, 2);
    		
    		for(int i =0; i<rs.getMetaData().getColumnCount(); i++) {
    			final int j = i;
    			@SuppressWarnings("rawtypes")
				TableColumn col = new TableColumn<String,String>(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(((List) param.getValue()).get(j).toString());                        
                    }                    
                });

                PinnedPlaces.getColumns().addAll(col); 
                //System.out.println("Column ["+i+"] " + col);
            }

    		//now need to figure out rows situation
    		System.out.println(rs.next());
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+ row );
                data.add(row);    			
    		} 		
    	}

    	dcon.close();
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
    
    public class dataClass{
    //2 --> places YB
    }

}
