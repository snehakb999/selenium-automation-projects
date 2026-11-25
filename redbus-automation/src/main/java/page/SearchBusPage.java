package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBusPage {
	WebDriver driver;
	WebDriverWait wait;

	public SearchBusPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By routeHeading = By.cssSelector("span[role='text'][aria-label='Bengaluru to Kochi']");
	// By busCount = By.cssSelector("span.subtitle___710c33");
	By busCount = By.xpath("//span[contains(normalize-space(),'buses')]");
	By showBusesButton = By.xpath("//button[@aria-label='Show buses']");
	By ksrtcBusCount = By.className("groupCount__ind-search-RTCHeader-module-scss-VJS+4");// 6buses
	// By viewSeatsButton = By.xpath("//button[@aria-label='View seats for Diamond
	// Tours and Travels']");//diamond tours
	By viewSeatsButton = By.xpath("//button[contains(@aria-label,'View seats for')]");// for any private bus

	public String getRouteHeading() {

		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(routeHeading));
		return heading.getAttribute("aria-label");
	}

	public String getBusCount() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(busCount)).getText();
	}

	public void clickShowBuses() {

		wait.until(ExpectedConditions.elementToBeClickable(showBusesButton)).click();

	}

	public String getKsrtcBusCount() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(ksrtcBusCount)).getText();

	}

	public void clickViewSeats() {

		wait.until(ExpectedConditions.elementToBeClickable(viewSeatsButton)).click();

	}

}
