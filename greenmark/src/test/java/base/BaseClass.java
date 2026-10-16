package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
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


import page.GreenMarkPage;


public class BaseClass {
	
	protected WebDriver driver;
	protected GreenMarkPage page;
	protected WebDriverWait wait;
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void extentsupport() {
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
	}
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method mthd) {
		
		
		driver=new ChromeDriver();
		driver.get("https://www.greenmarknatural.com/");
		page=new GreenMarkPage(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		test=extent.createTest(mthd.getName());
		
	}
	
	
	
	@AfterMethod(alwaysRun = true)
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
		driver.quit();
		
	}
	public static String screenshotMethod(
	        WebDriver driver,
	        String screenshotname) throws IOException {

	    File src =
	            ((TakesScreenshot) driver)
	            .getScreenshotAs(OutputType.FILE);

	    String destination =
	            "./Screenshot/" + screenshotname + ".jpeg";
	    
	    FileHandler.copy(src, new File(destination));
	    


	    return new File(destination).getAbsolutePath();
	    //return destination;
	}
	
	@AfterSuite
	public void tearDownReport() {
	    extent.flush();
	}

}

