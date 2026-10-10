package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import saucedemobase.BaseClass;

public class CartPageTest extends BaseClass {

	@Test(priority = 7)
	public void titleVerify() {
		test = extent.createTest("Verify Cart Page Title");
		String text = cart.titleCartVerify();
		Assert.assertEquals(text, "Your Cart");
		test.log(Status.PASS, "Cart page title verified successfully: " + text);
	}

	@Test(priority = 8)
	public void btnEnabled() {
		test = extent.createTest("Verify Continue Button Enabled");
		boolean btn1result = cart.continueButtonisEnabled();
		Assert.assertTrue(btn1result);
		test.log(Status.PASS, "Continue button is enabled");
	}

	@Test(priority = 9)
	public void btn2Enabled() {
		test = extent.createTest("Verify checkout Button Enabled");
		boolean btn2result = cart.checkoutButtonisEnabled();
		Assert.assertTrue(btn2result);
		test.log(Status.PASS, "checkout button is enabled");
		
	}

	@Test(priority = 10)
	public void checkButtonClick() {
		test = extent.createTest("Click checkout Button");
		cart.checkBtnClick();
		test.log(Status.PASS, "checkout button clicked successfully");

	}

}
