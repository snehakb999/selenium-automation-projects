package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class SeatSelectionTest extends BaseClass {
	
	@Test(priority = 1)
	public void seatSelectTest() {
		home.searchBuses();
		search.clickViewSeats();
		seat.selectSeat();
		String status = seat.getSeatSelectionStatus();
	    Assert.assertEquals(status, "true", "Seat selection failed");
	   
	    System.out.println("Seat selected successfully: " + status);
	    seat.clickBoardingDropButton();
		
	}

}
