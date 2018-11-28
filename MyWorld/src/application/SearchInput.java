package application;

public class SearchInput {
	public SearchInput() {
		
	}
	//checks if any field is left blank in search
	public boolean CheckBlankFieldsFilled(String firstField, String secondField) throws Exception {
		try {
			if(firstField.isEmpty() || secondField.isEmpty()) {
				System.out.println("Please fill in both fields!");
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("Enter all of the fields");
		}
		return false;
		//true means that at least one field is left blank
		//false means that both fields (city and name) are filled in
	}
	
	//only checks for special characters in the input, not for valid entries in the
	//FourSquare database
	public boolean CheckCharacters(String firstField, String secondField) throws Exception{
		try {
			if(!isValid(firstField) || !isValid(secondField)) {
				System.out.println("Please enter valid entries!");
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("Only characters and numbers are allowed, not special characters");
		}
		return false;
		//true means that at least one field is left blank
		//false means that both fields (city and name) are filled in
	}
	public boolean isValid(String input) {
		return input.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
	}
	
	
}
