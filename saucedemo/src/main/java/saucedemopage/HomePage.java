package saucedemopage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By titlename = By.cssSelector("[data-test='title']");
	By dropdown = By.cssSelector("[data-test='product-sort-container']");
	By addtocart = By.xpath("//button[text()='Add to cart']");// we are using button text to identify all buttons with
																// name add to cart
	By addtocarticon=By.cssSelector("[data-test='shopping-cart-link']");
			

	public String titleCheck() {
		return driver.findElement(titlename).getText();
	}

	public void dropClick() {
		driver.findElement(dropdown).click();
	}

	public void selectSortOption(String option) {

		Select value = new Select(driver.findElement(dropdown));
		value.selectByVisibleText(option);

	}

	public void selectAllProducts() {

		while (driver.findElements(addtocart).size() > 0) {

			driver.findElements(addtocart).get(0).click();

		}
	}
	
	public void addtoCartClick() {
		driver.findElement(addtocarticon).click();
	}
	

}
