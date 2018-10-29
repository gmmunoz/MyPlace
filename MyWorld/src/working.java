
public class working {
	/*
    //action to attempt to login
    //@MICHAELLA LOOK HERE FOR SQL
    @FXML
    public boolean logIn(ActionEvent event) throws IOException {
    	String email = txtUserName.getText();
        String password = Password.getText();

        //query
        String sql = "SELECT * user WHERE userName = ? AND passwd = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
            	// this where new page fxml gets loaded
				Parent root = FXMLLoader.load(getClass().getResource("MainPageFXML.fxml"));

				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("Main Page");
				stage.show();
                return true;

            } else {
            	// show error --> try again
				// NEED TO CREATE WRONG PASSWORD FXML
				Parent root = FXMLLoader.load(getClass().getResource("WrongTryAgainFXML.fxml"));

				Stage wrongStage = new Stage();
				wrongStage.setScene(new Scene(root));
				wrongStage.setTitle("Wrong Username or Password");
				wrongStage.centerOnScreen();
				wrongStage.show();
				return false;
			}

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }	


    //Action to retrieve forgotten password
    @FXML
    void retrievePwd(ActionEvent event) throws IOException {
    	// load forgot password page
		Parent root = FXMLLoader.load(getClass().getResource("ForgotPasswordFXML.fxml"));

		Stage wrongStage = new Stage();
		wrongStage.setScene(new Scene(root));
		wrongStage.setTitle("Retrieve Password");
		wrongStage.centerOnScreen();
		wrongStage.show();
	}
*/
}
