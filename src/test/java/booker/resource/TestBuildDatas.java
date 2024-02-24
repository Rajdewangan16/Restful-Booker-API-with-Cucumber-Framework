package booker.resource;

import booker.pojo.Bookingdates;
import booker.pojo.CreateBooking;

public class TestBuildDatas {

	public static CreateBooking createBookingPayload(String firstname , String lastname, int totalprice , boolean depositpaid ) {
		Bookingdates bd = new Bookingdates();
		bd.setCheckin("2023-09-09");
		bd.setCheckout("2024-01-01");
		
		CreateBooking cb = new CreateBooking();
		
		cb.setFirstname(firstname);
		cb.setLastname(lastname);
		cb.setTotalprice(totalprice);
		cb.setDepositpaid(depositpaid);
		cb.setBookingdates(bd);
		cb.setAdditionalneeds("Breakfast");
		return cb;
	}
	
	public static CreateBooking updateBookingPayload(String firstname , String lastname, int totalprice , boolean depositpaid) {
		Bookingdates bd = new Bookingdates();
		bd.setCheckin("2023-09-09");
		bd.setCheckout("2024-01-01");
		
		CreateBooking cb = new CreateBooking();
		
		cb.setFirstname(firstname);
		cb.setLastname(lastname);
		cb.setTotalprice(totalprice);
		cb.setDepositpaid(depositpaid);
		cb.setBookingdates(bd);
		cb.setAdditionalneeds("Breakfast");
		return cb;
	}
	public static String tokenPayload() {
		return "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
	}
}
