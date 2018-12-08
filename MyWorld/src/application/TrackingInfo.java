package application;

public class TrackingInfo {

	private String placeName;
//	private String address;
//	private String comment;
	
	public TrackingInfo(String placeName_in) {
		placeName = placeName_in;
	}
	
	public TrackingInfo() {
		this.getPlaceName();
	}
	
	public String getPlaceName() {
		return placeName;
	}
	
}
