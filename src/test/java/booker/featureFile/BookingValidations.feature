Feature: Validating Booking API

@Regression @CreateBooking
Scenario Outline: Verify if Booking is being successfully added using BookingAPI
	
	Given Create Booking Payload with "<firstname>" "<lastname>" <totalprice> "<depositpaid>"
	When user calls "CreateBookingAPI" with "Post" http request
	Then API call is success with status code 200
	And verify the bookingid created maps to "<firstname>" with "GetBookingAPI"
	Examples:
	|firstname		|lastname		|totalprice		|depositpaid		|
	|Bob					|Harley			|700					|true						|
	
@Regression @UpdateBooking
Scenario Outline: Verify if Booking is being successfully updated using PutBookingAPI

	Given Create token Payload using "AuthAPI" with "Post" http request
	And Update Booking Payload with "<firstname>" "<lastname>" <totalprice> "<depositpaid>"
	When user calls "PutBookingAPI" with "Put" http request
	Then API call is success with status code 200
	Examples:
	|firstname		|lastname		|totalprice		|depositpaid		|
	|Bob					|Harley			|1200					|true						|
	
@Regression @DeleteBooking
Scenario: Verify if Booking is being successfully deleted using DeleteBookingAPI

	Given Create token Payload using "AuthAPI" with "Post" http request
	And Delete Booking Payload
	When user calls "DeleteBookingAPI" with "Delete" http request
	Then API call is success with status code 201
	