
package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import utils.TestData;

public class PassengerInfoTest extends BaseClass {
	public void navigateToPassengerInfo() {

		home.searchBuses();
		search.clickViewSeats();
		seat.selectSeat();
		seat.clickBoardingDropButton();
		page.selectBoardingPoint();
		page.selectDroppingPoint();
	}

	@Test(priority = 1)
	public void contactDetailsTest() {

		navigateToPassengerInfo();

		// country code
		String actualCode = info.verifyCountryCode();

		Assert.assertTrue(actualCode.contains("+91") && actualCode.contains("IND"), "Country code is not +91 (IND)");
		String actualPhone = info.enterPhoneNumber(TestData.PHONE_NUMBER);

		Assert.assertEquals(actualPhone, TestData.PHONE_NUMBER, "Phone number is not entered correctly");
		String actualEmail = info.enterEmail(TestData.EMAIL);

		Assert.assertEquals(actualEmail, TestData.EMAIL, "Email is not entered correctly");
		info.clickStateDropdown();

		String actualState = info.selectState();

		Assert.assertEquals(actualState, TestData.STATE, "State selection failed");
	}

	@Test(priority = 2)
	public void passengerDetailsTest() {

		navigateToPassengerInfo();

		// passenger name
		String actualName = info.enterPassengerName(TestData.PASSENGER_NAME);

		Assert.assertEquals(actualName, TestData.PASSENGER_NAME, "Passenger name is not entered correctly");

		// age
		String actualAge = info.enterPassengerAge(TestData.PASSENGER_AGE);

		Assert.assertEquals(actualAge, TestData.PASSENGER_AGE, "Passenger age is not entered correctly");

		// Select Female
		info.selectFemale();
	}

	@Test(priority = 3)
	public void addOnsTest() {

		navigateToPassengerInfo();

		// Free Cancellation
		info.selectFreeCancellation();

		// Trip Guarantee
		info.rejectTripGuarantee();

		String actualStatus = info.getTripGuaranteeStatus();

		Assert.assertEquals(actualStatus, "true", "Don't add Trip Guarantee was not selected");

		// Travel Insurance
		info.selectTravelInsurance();

		String status = info.getTravelInsuranceStatus();
		Assert.assertEquals(status, "true", "Travel Insurance was not selected");

		// Continue booking
		info.clickContinueBooking();
	}

}
