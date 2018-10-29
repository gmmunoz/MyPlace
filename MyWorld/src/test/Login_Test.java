package test;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.assertions.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Login_Test extends ApplicationTest{

    /*@Override
    public void start(Stage stage){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/MyPlace_login.fxml"));
            root.setId("login");
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("My Application");
        stage.setScene(new Scene(root));
        stage.show();
    }*/

    /* Test valid login: valid username and password */
	@Test
	/*void valid_login() {
		final boolean expected = true;
		clickOn("#login");
		//write().push(KeyCode.ENTER); //put in sample login

        //assertThat();

        fail("Not yet implemented");
	}*/
	
	/* Test invalid login: valid username and invalid password */
    @Test
    /*void invalid_password() {
        final boolean expected = true;
        clickOn("#login");
        //write(); //put in sample login
        fail("Not yet implemented");
    }*/
	
	/* Test invalid login: invalid username and invalid password */
	


}
