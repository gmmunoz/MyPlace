package application;

import java.util.ArrayList;

public class TestPlaceSearch {
	
	public static void main(String[] args) throws Exception {
		PlaceSearch test = new PlaceSearch("", "Chicagho");
		
		ArrayList<Place> search_results = test.getResults();
		
		int no_results = search_results.size();
		
		for (int i = 0; i < no_results; i++) {
			search_results.get(i).printPlace();
		}
	}	
}
