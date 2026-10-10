package saucedemobase;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import saucedemopage.CartPage;
import saucedemopage.CheckOutPage;
import saucedemopage.HomePage;

public class BaseClass {
	protected static WebDriver driver;
	protected HomePage home;
	protected CartPage cart;
	protected CheckOutPage check;
	
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	

	@BeforeSuite
	public void setUp() {
		reporter=new ExtentSparkReporter("./Reports/myreport1.html");
		reporter.config().setDocumentTitle("Automationreport");
		reporter.config().setReportName("functionaltest");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname","localhost");
		extent.setSystemInfo("OS","windows10");
		extent.setSystemInfo("testername","sneha");
		extent.setSystemInfo("Browsername","Chrome");
		
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver=new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
	}
	
	@BeforeMethod
	public void objectReference() {
		home=new HomePage(driver);
		cart=new CartPage(driver);
		check=new CheckOutPage(driver);
		
		
		
	}
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"Test case failed: "+result.getName());
			test.log(Status.FAIL,"Failure Reason : "+result.getThrowable());
			String screenshotpath =
	                screenshotMethod(driver, result.getName());

	        test.addScreenCaptureFromPath(screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.SKIP,"Test case skipped: "+result.getName());
			
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,"Test case passed: " +result.getName());
		}
		
	}
	public static String screenshotMethod(
	        WebDriver driver,
	        String screenshotname) throws IOException {

	    File src =
	            ((TakesScreenshot) driver)
	            .getScreenshotAs(OutputType.FILE);

	    String destination =
	            "./Screenshot/" + screenshotname + ".jpeg";
	    
	    File screenshot = new File(destination);

	    FileHandler.copy(src, screenshot);

	    return screenshot.getAbsolutePath();
	}
	
	@AfterSuite
	public void tearDownReport() {
	    extent.flush();
	}

}
