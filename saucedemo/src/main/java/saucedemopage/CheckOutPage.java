package saucedemopage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	  
	
	By titleCheck=By.cssSelector("[data-test='title']");
	By frstname=By.id("first-name");
	By lstname=By.id("last-name");
	By zipid=By.id("postal-code");
	By continuebtn=By.id("continue");
	By finishbtn=By.id("finish");
	
	public String checkTitleVerify() {
		return driver.findElement(titleCheck).getText();
	}
	public void setValuesCheckOut(String name,String lastname,String zip) {
		driver.findElement(frstname).sendKeys(name);
		driver.findElement(lstname).sendKeys(lastname);
		driver.findElement(zipid).sendKeys(zip);
		
	}
	public void continueBtnClick() {
		 driver.findElement(continuebtn).click();
	}
	public void finishBtnClick() {
		 driver.findElement(finishbtn).click();
	}
	

}
