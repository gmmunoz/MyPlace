package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import application.SearchInput;

public class SearchInput_Test {
	
	private SearchInput testCheck = new SearchInput();

	@Test
	void search_valid() throws Exception{
		String name = "pizza";
		String city = "chicago";
		
		//if both name and city are valid inputs
		assertEquals(true, testCheck.OKCheck(name, city));
		
	}
	
	@Test
	void blankFields_present() throws Exception{
		String blank = "";
		String name = "cycling";
		String city = "new york";
		String invalidName = "zjdk$jf";
		String invalidCity = "asd@f asj!";
		
		//all of these tests demonstrate that with a valid city or name, if at least one
		//text field is empty, then an error message appears and the user cannot continue
		//execute the search
		assertEquals(true, testCheck.CheckBlankFields(blank, city));
		assertEquals(true, testCheck.CheckBlankFields(name, blank));
		assertEquals(true, testCheck.CheckBlankFields(blank, blank));
		
		//these tests demonstrate that even with an invalid city or name as input, 
		//the program takes priority in checking if there are any blank fields first
		assertEquals(true, testCheck.CheckBlankFields(blank, invalidCity));
		assertEquals(true, testCheck.CheckBlankFields(invalidName, blank));
		
		//valid inputs--both text fields are filled, user can retrieve search results
		assertEquals(false, testCheck.CheckBlankFields(name, city));
	}
	
	@Test
	void specialCharacters_present() throws Exception{
		String name = "salad";
		String nameInvalid = "s@l$a*d";
		String city = "miami";
		String cityInvalid = "$m(!am#i";
		
		//at least one input is invalid and contains a special character
		assertEquals(true, testCheck.CheckCharacters(name, cityInvalid));
		assertEquals(true, testCheck.CheckCharacters(nameInvalid, city));
		assertEquals(true, testCheck.CheckCharacters(nameInvalid, cityInvalid));
		
		//both inputs do not contain special characters
		assertEquals(false, testCheck.CheckCharacters(name, city));
		
	}
	
}
