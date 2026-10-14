
package page;

	import java.net.HttpURLConnection;

import java.time.Duration;
	import java.util.List;
	import java.util.Set;
	import java.net.URI;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class PageClass {

	    WebDriver driver;
	    WebDriverWait wait;

	    public PageClass(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    

	    By totalLinks = By.tagName("a");

	    By playground = By.xpath("//a[normalize-space()='Playground']");

	    By logo = By.xpath("//img[@alt='Tools QA']");

	    By seleniumTraining = By.xpath("//a[contains(normalize-space(),'Selenium Training')]");


	    

	    public int getTotalLinks() {

	        return driver.findElements(totalLinks).size();
	    }


	    

	    public List<WebElement> getAllLinks() {

	        return driver.findElements(totalLinks);
	    }
	    public void checkBrokenLinks() {

	        List<WebElement> links = driver.findElements(totalLinks);

	        for (WebElement link : links) {

	            String url = link.getAttribute("href");

	            if (url == null || url.isEmpty()) {
	                continue;
	            }

	            try {
	                URI ob = new URI(url);

	                HttpURLConnection con =
	                        (HttpURLConnection) ob.toURL().openConnection();

	                int code = con.getResponseCode();

	                if (code >= 400) {
	                    System.out.println("Broken link -------- " + url);
	                }

	            } catch (Exception e) {
	                System.out.println("Broken link -------- " + url);
	            }
	        }
	    }

	    

	    public void clickPlayground() {

	        wait.until(ExpectedConditions.elementToBeClickable(playground)).click();
	    }



	    public void switchToNewTab() {

	        String parentWindow = driver.getWindowHandle();

	        Set<String> windows = driver.getWindowHandles();

	        for (String window : windows) {

	            if (!window.equals(parentWindow)) {

	                driver.switchTo().window(window);
	                break;
	            }
	        }
	    }


	    

	    public String getTitle() {

	        return driver.getTitle();
	    }


	    public void switchToParentWindow() {

	        Set<String> windows = driver.getWindowHandles();

	        String currentWindow = driver.getWindowHandle();

	        for (String window : windows) {

	            if (!window.equals(currentWindow)) {

	                driver.switchTo().window(window);
	                break;
	            }
	        }
	    }


	   
	    public boolean isLogoDisplayed() {

	        WebElement toolsqaLogo =
	                wait.until(ExpectedConditions.visibilityOfElementLocated(logo));

	        return toolsqaLogo.isDisplayed();
	    }


	    

	    public void clickSeleniumTraining() {

	        wait.until(ExpectedConditions.elementToBeClickable(seleniumTraining)).click();
	    }

	}
    
