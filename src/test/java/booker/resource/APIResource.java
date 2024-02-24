package booker.resource;

public enum APIResource {

	AuthAPI("https://restful-booker.herokuapp.com/auth"),
	CreateBookingAPI("https://restful-booker.herokuapp.com/booking"),
	GetBookingAPI("https://restful-booker.herokuapp.com/booking/{id}"),
	PutBookingAPI("https://restful-booker.herokuapp.com/booking/{id}"),
	DeleteBookingAPI("https://restful-booker.herokuapp.com/booking/{id}");
	
	private String resource;
	
	APIResource(String resource) {
		this.resource = resource;	
	}
	
	public String getResource() {
		return resource; 
	}
}
