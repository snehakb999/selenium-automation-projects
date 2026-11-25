package test;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseClass;
import utils.TestData;

public class HomePageTest extends BaseClass {
	// Verify homepage title

	@Test(priority = 1)
	public void titleVerification() {

		String title = home.getTitle();
		Assert.assertTrue(title.contains("redBus"), "Homepage title verification failed");
		System.out.println("Title verified: " + title);
	}

	@Test(priority = 2)
	public void fromCityTest() {

		home.enterFromCity(TestData.SOURCE);// bengaluru
		String actualSource = home.getFromCityValue();
		Assert.assertEquals(actualSource, TestData.SOURCE, "Source city verification failed");
		System.out.println("Source city entered: " + actualSource);
	}

	@Test(priority = 3)
	public void toCityTest() {

		home.enterToCity(TestData.DESTINATION);// kochi
		String actualDestination = home.getToCityValue();
		Assert.assertEquals(actualDestination, TestData.DESTINATION, "Destination city verification failed");
		System.out.println("Destination city entered: " + actualDestination);
	}

	// date picker opens

	@Test(priority = 4)
	public void datePickerTest() {

		home.openDatePicker();
		System.out.println("Date picker clicked successfully");
	}

	@Test(priority = 5)
	public void fromCitySelectionTest() {
		home.enterFromCity(TestData.SOURCE);// bengaluru
		home.selectCitySuggestion();
		String actualSource = home.getFromCityValue();
		Assert.assertEquals(actualSource, TestData.SOURCE, "Source city selection failed");
		System.out.println("Source city selected: " + actualSource);
	}

	@Test(priority = 6)
	public void toCitySelectionTest() {

		home.enterToCity(TestData.DESTINATION);
		home.selectDestinationCitySuggestion();
		String actualDestination = home.getToCityValue();
		Assert.assertEquals(actualDestination, TestData.DESTINATION, "Destination city selection failed");
		System.out.println("Destination city selected: " + actualDestination);
	}

	@Test(priority = 7)
	public void journeyDateSelectionTest() {

		home.openDatePicker();
		home.navigatetoAnyMonth();
		home.selectJourneyDate();
		String actualDate = home.getJourneyDate();
		Assert.assertTrue(actualDate.contains(TestData.JOURNEY_DATE), "Journey date verification failed");
		System.out.println("Selected journey date: " + actualDate);

	}

	@Test(priority = 8)
	public void searchButtonTest() {

		home.clickSearch();
		System.out.println("Search button clicked successfully");

	}

	@Test(priority = 9)
	public void completeBusSearchTest() {

		home.searchBuses();
		Assert.assertTrue(driver.getCurrentUrl().contains("/bus-tickets/"), "Search results page did not open");
		System.out.println("Complete bus search executed");
	}

}
