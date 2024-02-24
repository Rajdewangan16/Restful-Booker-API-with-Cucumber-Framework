package booker.hooks;

import booker.stepdefinations.StepDefinations;
import io.cucumber.java.Before;

public class Hook {

	@Before("@DeleteBooking or @UpdateBooking")
	public void beforeDeleteScenario() throws Exception {
		StepDefinations sd = new StepDefinations();
		if(StepDefinations.bookingId == 0) {
			sd.create_booking_payload_with("Smith", "Harley", 900, "true");
			sd.user_calls_with_http_request("CreateBookingAPI", "Post");
			sd.verify_the_bookingid_created_maps_to_with("Smith", "GetBookingAPI");
		}	
	}
}
