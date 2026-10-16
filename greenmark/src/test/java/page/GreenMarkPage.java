package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenMarkPage {
	WebDriver driver;
	WebDriverWait wait;

	public GreenMarkPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}


	By menuLinks = By.xpath("//*[@id='menuLinkName']");
	By totalLinks = By.tagName("a");
	By search = By.id("srchtxtsticky");
	By searchButton = By.cssSelector("button[seleniumid='sel_srcBtn']");
	By dropBtn = By.xpath("//div[contains(@class,'dropdown-div')]//div[contains(@class,'yIE7_value-holder')]");
	By sortOptions = By.xpath("//div[contains(@class,'dropdown-div')]//li[contains(@class,'bZrx_list-item')]");
	By newestOption = By.xpath("//li[contains(@class,'bZrx_list-item')][.//div[normalize-space()='Newest']]");
	By shampooProduct = By.xpath("//div[@id='productdiv']//div[contains(@class,'listing-single-product')][1]//a");
	By addToCart = By.xpath("//button[contains(@class,'add-to-cart-btn')]");
	By cartCount = By.cssSelector(".cart-count-val");
	By goToCart = By.xpath("//button[.//span[normalize-space()='GO TO CART']]");

	public String getTitle() {
		return driver.getTitle();
	}

	public void getMenuNames() {
		List<WebElement> menus = driver.findElements(menuLinks);

		for (WebElement menu : menus) {
			System.out.println(menu.getText());
		}

	}
	public boolean areMenusDisplayed() {

	    List<WebElement> menus = driver.findElements(menuLinks);

	    return !menus.isEmpty();
	}

	public int getMenuLinks() {
		return driver.findElements(totalLinks).size();

	}

	public void searchProduct(String product) {

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
		searchBox.sendKeys(product);
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		button.click();

	}
	public boolean isShampooDisplayed() {

	    WebElement shampoo = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(shampooProduct)
	    );

	    return shampoo.isDisplayed();
	}

	public void dropClick() {

		WebElement drop = wait.until(ExpectedConditions.elementToBeClickable(dropBtn));
		drop.click();
	}

	public int getSortOptionsCount() {
		return driver.findElements(sortOptions).size();
		

	}

	public void selectNewest() {

		WebElement newest = wait.until(ExpectedConditions.elementToBeClickable(newestOption));

		newest.click();
	}
	

	public void selectShampooProduct() {

		WebElement shampoo = wait.until(ExpectedConditions.elementToBeClickable(shampooProduct));
		shampoo.click();
	}
	public boolean isAddToCartDisplayed() {

	    WebElement addCartButton = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(addToCart)
	    );

	    return addCartButton.isDisplayed();
	}

	public String getAddToCartText() {

		WebElement addCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
		return addCartButton.getText();
	}

	public boolean isAddToCartEnabled() {

		WebElement addCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));

		return addCartButton.isEnabled();
	}

	public void clickAddToCart() {

		WebElement addCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCart));

		addCartButton.click();
	}

	public String getCartCount() {

		WebElement count = wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount));

		return count.getText();
	}
	public String getCurrentUrl() {
	    return driver.getCurrentUrl();
	}

	public void clickCart() {
		wait.until(ExpectedConditions.elementToBeClickable(goToCart)).click();
	}

}
