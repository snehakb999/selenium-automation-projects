package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerInfo {

	WebDriver driver;
	WebDriverWait wait;

	public PassengerInfo(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By countryCode = By.className("countryCode___68061e");
	By phoneNumber = By.name("Phone");
	By email = By.name("0_5");
	By stateDropdown = By.xpath("//label[@id='0_201-label']/parent::div");
	By passengerName = By.xpath("//input[@placeholder='Enter your Name']");

	By keralaOption = By.xpath("//div[@role='radio']//div[@class='listHeader___8d6700' and text()='Kerala']");
	By passengerAge = By.xpath("//input[@placeholder='Enter Age']");
	By femaleOption = By.xpath("//div[@role='radio'][.//span[text()='Female']]");
	By freeCancellation = By.id("fcConfirmText");
	By tripGuaranteeOption = By.id("insuranceRejectText");
	By travelInsuranceOption = By.id("insuranceConfirmText");
	By continueBooking = By.xpath("//button[contains(@aria-label,'Continue booking')]");

	public String verifyCountryCode() {

		WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(countryCode));

		return code.getText();
	}

	public String enterPhoneNumber(String number) {

		WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber));

		phone.sendKeys(number);

		return phone.getAttribute("value");
	}

	public String enterEmail(String emailId) {

		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(email));

		emailField.sendKeys(emailId);

		return emailField.getAttribute("value");
	}

	public void clickStateDropdown() {

		WebElement state = wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));

		state.click();
	}

	public String selectState() {

		WebElement kerala = wait.until(ExpectedConditions.elementToBeClickable(keralaOption));

		String selectedState = kerala.getText();

		kerala.click();

		return selectedState;
	}

	public String enterPassengerName(String name) {

		WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(passengerName));

		// Scroll down to the passenger name field
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", nameField);

		nameField.sendKeys(name);

		return nameField.getAttribute("value");
	}

	public String enterPassengerAge(String age) {

		WebElement ageField = wait.until(ExpectedConditions.visibilityOfElementLocated(passengerAge));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", ageField);

		ageField.sendKeys(age);

		return ageField.getAttribute("value");
	}

	public void selectFemale() {

		WebElement female = wait.until(ExpectedConditions.elementToBeClickable(femaleOption));

		female.click();
	}

	public void selectFreeCancellation() {

		WebElement cancellation = wait.until(ExpectedConditions.visibilityOfElementLocated(freeCancellation));

		// Scroll down to Free Cancellation
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", cancellation);

		wait.until(ExpectedConditions.elementToBeClickable(freeCancellation)).click();
	}

	public void rejectTripGuarantee() {

		WebElement insurance = wait.until(ExpectedConditions.visibilityOfElementLocated(tripGuaranteeOption));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", insurance);

		wait.until(ExpectedConditions.elementToBeClickable(tripGuaranteeOption)).click();
	}

	public String getTripGuaranteeStatus() {

		WebElement insurance = wait.until(ExpectedConditions.presenceOfElementLocated(tripGuaranteeOption));

		return insurance.getAttribute("aria-checked");
	}

	public void selectTravelInsurance() {

		WebElement insurance = wait.until(ExpectedConditions.visibilityOfElementLocated(travelInsuranceOption));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", insurance);

		wait.until(ExpectedConditions.elementToBeClickable(travelInsuranceOption)).click();
	}

	public String getTravelInsuranceStatus() {

		WebElement insurance = wait.until(ExpectedConditions.presenceOfElementLocated(travelInsuranceOption));

		return insurance.getAttribute("aria-checked");
	}

	public void clickContinueBooking() {

		WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(continueBooking));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", continueButton);

		wait.until(ExpectedConditions.elementToBeClickable(continueBooking)).click();
	}
}
