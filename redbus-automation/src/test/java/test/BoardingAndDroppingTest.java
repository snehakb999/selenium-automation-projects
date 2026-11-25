package test;

import org.testng.annotations.Test;

import base.BaseClass;

public class BoardingAndDroppingTest extends BaseClass {

	@Test
	public void boardingAndDroppingPointSelectionTest(){

		home.searchBuses();
		search.clickViewSeats();
		seat.selectSeat();
		seat.clickBoardingDropButton();
		page.selectBoardingPoint();
		page.selectDroppingPoint();
		

	}
}