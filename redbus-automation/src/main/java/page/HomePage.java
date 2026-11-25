package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestData;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By fromCity = By.id("srcinput");

	By toCity = By.id("destinput");

	By datePicker = By.cssSelector("div[aria-label='Select date of journey']");

	By searchButton = By.cssSelector("button[aria-label='Search buses']");
	By citySuggestion = By.xpath("//div[@role='button' and contains(@aria-label,'Bengaluru (All Locations)')]");
	By destinationCitySuggestion = By.xpath("//div[@aria-label='Kochi']");
	By journeyDate = By.xpath("//div[@role='button' and @aria-label='Tuesday, December 1, 2026']");
	By nextMonth = By.xpath("//i[@role='button' and starts-with(@aria-label,'Next month')]");

	public String getTitle() {
		return driver.getTitle();
	}

	public String getFromCityValue() {
		return driver.findElement(fromCity).getAttribute("value");
	}

	public String getToCityValue() {
		return driver.findElement(toCity).getAttribute("value");
	}

	public void selectCitySuggestion() {

		wait.until(ExpectedConditions.elementToBeClickable(citySuggestion)).click();
	}

	// destination city

	public void enterToCity(String destination) {

		WebElement to = wait.until(ExpectedConditions.elementToBeClickable(toCity));

		to.sendKeys(destination);
	}

	// date picker

	public void openDatePicker() {

		wait.until(ExpectedConditions.elementToBeClickable(datePicker)).click();
	}
	// search

	public void clickSearch() {

		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}

	public void enterFromCity(String source) {

		WebElement from = wait.until(ExpectedConditions.elementToBeClickable(fromCity));
		from.sendKeys(source);
	}

	public void selectDestinationCitySuggestion() {
		wait.until(ExpectedConditions.elementToBeClickable(destinationCitySuggestion)).click();
	}

//	public void navigatetoAnyMonth() {
//
//		for (int i = 1; i <= 1; i++) {
//
//			wait.until(ExpectedConditions.elementToBeClickable(nextMonth)).click();
//
//		}
//	}

	public void navigatetoAnyMonth() {

		WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(nextMonth));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", next);
		wait.until(ExpectedConditions.elementToBeClickable(nextMonth)).click();
	}

	public void selectJourneyDate() {
		wait.until(ExpectedConditions.elementToBeClickable(journeyDate)).click();
	}

	public String getJourneyDate() {
		return driver.findElement(datePicker).getText();
	}

	// reusable method
	public void searchBuses() {

		enterFromCity(TestData.SOURCE);// bengaluru
		selectCitySuggestion();

		enterToCity(TestData.DESTINATION);// kochi
		selectDestinationCitySuggestion();

		openDatePicker();
		navigatetoAnyMonth();
		selectJourneyDate();

		clickSearch();
	}

}
