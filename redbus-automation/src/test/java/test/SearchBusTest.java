package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class SearchBusTest extends BaseClass {

	@Test(priority = 1)
	public void routeHeadingTest() {

		home.searchBuses();
		String actualRoute = search.getRouteHeading();
		Assert.assertEquals(actualRoute, "Bengaluru to Kochi");
		System.out.println("Route verified: " + actualRoute);
	}

	@Test(priority = 2)
	public void busCountTest() {

		home.searchBuses();
		String actualCount = search.getBusCount();
		Assert.assertTrue(actualCount.contains("buses"), "Bus count verification failed");
		System.out.println("Bus count: " + actualCount);

	}

	@Test(priority = 3)
	public void ksrtcBusTest() {

		home.searchBuses();
		search.clickShowBuses();
		System.out.println("KSRTC Show buses clicked successfully");
	}

	@Test(priority = 4)
	public void ksrtcBusCountTest() {

		home.searchBuses();
		search.clickShowBuses();
		String actualCount = search.getKsrtcBusCount();
		Assert.assertEquals(actualCount, "(6 buses)");
		System.out.println("KSRTC bus count: " + actualCount);
	}

	@Test(priority = 5)
	public void privateBusTest() {

		home.searchBuses();
		search.clickViewSeats();
		System.out.println("View seats clicked successfully");

	}

}
