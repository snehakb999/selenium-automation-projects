package saucedemotest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import saucedemobase.BaseClass;
import saucedemopage.LoginPage;
import utility.ExcelUtils;

public class LoginTest extends BaseClass {

	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {
		String path = "C:\\Users\\vishnu\\Documents\\login.xlsx";
		return ExcelUtils.getCellData(path, "Sheet1");
	}

	@Test(dataProvider = "loginData",priority = 1)
	public void login(String username, String pass) {

		test = extent.createTest("loginTest");
		test.log(Status.INFO, "Entering username: " + username);
	    test.log(Status.INFO, "Entering password");

		LoginPage ob = new LoginPage(driver);
		ob.setValues(username, pass);
		ob.loginClick();
		test.log(Status.PASS, "Login test executed successfully");
	}

}
