package base;

import java.io.File;
import java.io.IOException;

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

import page.BoardingAndDroppingPage;
import page.HomePage;
import page.PassengerInfo;
import page.SearchBusPage;
import page.SeatSelectionPage;

public class BaseClass {
	protected  WebDriver driver;
	protected WebDriverWait wait;
	protected HomePage home;
	protected SearchBusPage search;
	protected SeatSelectionPage seat;
	protected BoardingAndDroppingPage page;
	protected PassengerInfo info;
	
	public static ExtentSparkReporter reporter;
    public static ExtentReports extent;
    public static ExtentTest test;


	@BeforeSuite
	public void reportsetUp() {
		reporter = new ExtentSparkReporter("./Reports/myreport1.html");

        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("RedBus Functional Testing");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("hostname", "localhost");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("testername", "Sneha");
        extent.setSystemInfo("Browsername", "Chrome");
		
		
	}
		
		
	 @BeforeMethod
	    public void setUp() {

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.redbus.in/");

	        home = new HomePage(driver);
	        search = new SearchBusPage(driver);
	        seat = new SeatSelectionPage(driver);
	        page = new BoardingAndDroppingPage(driver);
	        info = new PassengerInfo(driver);
	    }
	 @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {

	        test = extent.createTest(result.getName());

	        if (result.getStatus() == ITestResult.FAILURE) {

	            test.log(Status.FAIL, "Test case failed: " + result.getName());
	            test.log(Status.FAIL, "Failure Reason: " + result.getThrowable());

	            String screenshotpath = screenshotMethod(driver, result.getName());

	            test.addScreenCaptureFromPath(screenshotpath);
	        }
	        else if (result.getStatus() == ITestResult.SKIP) {

	            test.log(Status.SKIP, "Test case skipped: " + result.getName());
	        }
	        else if (result.getStatus() == ITestResult.SUCCESS) {

	            test.log(Status.PASS, "Test case passed: " + result.getName());
	        }

	        if (driver != null) {
	        	
	            driver.quit();
	        }
	    }

	    public static String screenshotMethod(
	            WebDriver driver,
	            String screenshotname) throws IOException {

	        File folder = new File("./Screenshot/");

	        if (!folder.exists()) {
	            folder.mkdirs();
	        }

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String destination = "./Screenshot/" + screenshotname + ".jpeg";

	        File screenshot = new File(destination);

	        FileHandler.copy(src, screenshot);

	        return screenshot.getAbsolutePath();
	    }
	    
	    @AfterSuite
	    public void tearDownReport() {

	        extent.flush();
	    }
}


	
//	@AfterMethod
//    public void tearDown() {
//
//     if (driver != null) {
//           driver.quit();
//       }
//   }


