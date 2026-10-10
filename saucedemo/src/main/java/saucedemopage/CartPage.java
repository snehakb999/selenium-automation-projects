package saucedemopage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	

	By titlecart = By.cssSelector("[data-test='title']");
	//By continuebtn = By.id("continue");
	By continuebtn = By.id("continue-shopping");
	By checkoutBtn = By.id("checkout");

	public String titleCartVerify() {
		return driver.findElement(titlecart).getText();
	}
	public boolean continueButtonisEnabled() {
		return driver.findElement(continuebtn).isEnabled();
	}
	public boolean checkoutButtonisEnabled() {
		return driver.findElement(checkoutBtn).isEnabled();
	}
	public void checkBtnClick() {
		driver.findElement(checkoutBtn).click();
	}

}
