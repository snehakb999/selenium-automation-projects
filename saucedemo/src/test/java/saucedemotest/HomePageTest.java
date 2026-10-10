package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import saucedemobase.BaseClass;

public class HomePageTest extends BaseClass {

	@Test(priority = 2)
	public void titleVerify() {
		test = extent.createTest("Verify title of homepage");
		String hometitle = home.titleCheck();
		Assert.assertEquals(hometitle, "Products");

		test.log(Status.PASS, "Title verification of home page is successful"+hometitle);
	}

	@Test(priority = 3)
	public void dropdownClick() {
		test = extent.createTest("Click dropdown");
		home.dropClick();
		test.log(Status.PASS, "Verified Dropdown is clcikable");
	}

	@Test(priority = 4)
	public void selectValue() {
		test = extent.createTest("Select Sort Option");
		home.selectSortOption("Price (low to high)");
		test.log(Status.PASS, "Price low to high option selected successfully");
	}

	@Test(priority = 5)
	public void allButtonsClick() {
		test = extent.createTest("Select All Products");

		home.selectAllProducts();

		test.log(Status.PASS, "All products selected and added to cart");
	}

	@Test(priority = 6)
	public void addtoCart() {
		test = extent.createTest("Clicking Add To Cart Icon");
		home.addtoCartClick();
		test.log(Status.PASS, "Add to cart is clicked");
		
	}

}
