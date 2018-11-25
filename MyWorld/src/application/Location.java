package application;

import org.json.simple.JSONArray;

//this class is what is pinned to a location list
public class Location {
	private Place place;
	private String name;
	private String address;
	private String comment;
	private String picture; //for another iteration
	
	public Location(Place input_place, String input_comment, String input_picture) {
		name = input_place.getPlaceName();
		address = input_place.getPlaceAddress();
		comment = input_comment;
		picture = input_picture;
	}
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getComment() {
		return comment;
	}
	public String getPicture() {
		return picture;
	}
	
	public void printLocation() {
		System.out.println(name);
		System.out.println(place);
		System.out.println(comment);
		System.out.println(picture);
	}
}
