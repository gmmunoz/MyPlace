package application;

	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MyApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{	
		try {
		Parent root = FXMLLoader.load(getClass().getResource("MyPlace_login.fxml"));

        primaryStage.setTitle("My Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}



