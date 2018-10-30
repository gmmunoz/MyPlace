package test;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class Login_TestFX extends ApplicationTest{

    Stage stage;
    Parent root;

    @Override
    public void start(Stage stage){
        this.stage = stage;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/MyPlace_login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("My Application");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /* Test that text shows up in textfield */
    @Test
    void valid_texfield(){

        //when
        clickOn("#txtUserName");
        write("testing");

        //then
        verifyThat("#txtUserName", hasText("testing"));

    }

    /* Test valid login: valid username and password */
    //@Test
	/*void valid_login() {
		final boolean expected = true;

		//when
		clickOn("#txtUserName");
		//write("email"); //put in sample login
        clickOn("#password");
        //write("password");
        clickOn("#loginBut");


        //then
        //assertThat();

        fail("Not yet implemented");
	}*/

	/* Test invalid login: valid username and invalid password */

    /*void invalid_password() {
        final boolean expected = true;
        clickOn("#login");
        //write(); //put in sample login
        fail("Not yet implemented");
    }*/

	/* Test invalid login: invalid username and invalid password */



}
