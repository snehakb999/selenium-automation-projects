package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatSelectionPage {
	WebDriver driver;
	WebDriverWait wait;
	String selectedSeatId;

	public SeatSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// By seat = By.id("U3");
	By seat = By.xpath(
			"//span[@role='button' and contains(@aria-label,'availability available') and @aria-pressed='false']");
	By boardingDropButton = By.xpath("//button[@aria-label='Select boarding & dropping points']");

	public void selectSeat() {

		WebElement availableSeat = wait.until(ExpectedConditions.elementToBeClickable(seat));
		selectedSeatId = availableSeat.getAttribute("id");
		availableSeat.click();

	}

	public String getSeatSelectionStatus() {

		return driver.findElement(By.id(selectedSeatId)).getAttribute("aria-pressed");

	}

	public void clickBoardingDropButton() {

		wait.until(ExpectedConditions.elementToBeClickable(boardingDropButton)).click();

	}

}
