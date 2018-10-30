package application;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class ChangeListener implements javafx.beans.value.ChangeListener<String> {
	
    private int maxLength;
    private TextField textField;


    public ChangeListener(TextField textField, int maxLength) {
        this.textField= textField;
        this.maxLength = maxLength;
    }


    public int getMaxLength() {
        return maxLength;
    }
	
	public void changed(ObservableValue<? extends String> observableValue, 
		    String oldValue, String newValue) {


		    /* To check if the value is null then return */
		    if (newValue == null){
		        return;
		    }

		    /* Check the length of new value length is less then defined max length then set the new value to the text field, else keep old value in text field. */
		    
		    if (newValue.length() > maxLength) {
		        textField.setText(oldValue);
		    } else {
		        textField.setText(newValue);
		    }
		}

}
