package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import saucedemobase.BaseClass;

public class CheckOutTest extends BaseClass{
	
	
	@Test(priority = 11)
	public void titleVerifyCheck() {
		test = extent.createTest("Verify Checkout Page Title");
		String titleC=check.checkTitleVerify();
		Assert.assertEquals(titleC,"Checkout: Your Information");
		test.log(Status.PASS, "Checkout page title verified successfully: " + titleC);
	}
	
	@Test(priority = 12)
	public void setValuesinField() {
		test = extent.createTest("Enter checkout information");
		check.setValuesCheckOut("sneha","jhon","89765");
		test.log(Status.PASS, "Checkout information entered successfully");
	}
	@Test(priority = 13)
	public void buttonisClick() {
		test = extent.createTest("Click Continue Button");
		check.continueBtnClick();
		test.log(Status.PASS, "Continue Button is clicked successfully");
	}
	@Test(priority = 14)
	public void finishbuttonisClick() {
		 test = extent.createTest("Click Finish Button");
		check.finishBtnClick();
		test.log(Status.PASS, "Finish Button is clicked successfully");
	}


}
