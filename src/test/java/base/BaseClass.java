package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import page.PageClass;

public class BaseClass {
	 protected WebDriver driver;
	    protected WebDriverWait wait;
	    protected PageClass page;

	    
	    @BeforeMethod
	    public void setUp() {

	        driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("https://www.toolsqa.com/");
	        page = new PageClass(driver);
	    }
	    @AfterMethod
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
