package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardingAndDroppingPage {

	WebDriver driver;
	WebDriverWait wait;

	public BoardingAndDroppingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Locators
	By boardingPoint = By
			.xpath("//ul[@aria-label='Boarding points']//div[@role='radio' and contains(@aria-label,'Bommasandra')]");
	By droppingPoint = By
			.xpath("//ul[@aria-label='Dropping points']//div[@role='radio' and contains(@aria-label,'Kalamassery')]");

	// Select boarding point
	public void selectBoardingPoint() {

		WebElement point = wait.until(ExpectedConditions.elementToBeClickable(boardingPoint));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", point);

		// Click Bommasandra
		point.click();
		wait.until(ExpectedConditions.attributeToBe(boardingPoint, "aria-checked", "true"));
	}

	public void selectDroppingPoint() {

		WebElement point = wait.until(ExpectedConditions.elementToBeClickable(droppingPoint));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", point);

		point.click();

		// wait.until(ExpectedConditions.attributeToBe(droppingPoint, "aria-checked",
		// "true"));

	}

}