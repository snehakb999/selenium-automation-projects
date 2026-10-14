package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestClass extends BaseClass {

    

    @Test(priority = 1)
    public void totalLinks() {

        int count = page.getTotalLinks();

        System.out.println("Total links : " + count);

        Assert.assertTrue(count > 0, "No links found");
    }


    
    @Test(priority = 2)
    public void brokenLinks() {

        page.checkBrokenLinks();

        System.out.println("Broken link checking completed");
    }


    

    @Test(priority = 3)
    public void clickPlayground() {

        page.clickPlayground();

        System.out.println("Playground clicked successfully");
    }


    

    @Test(priority = 4)
    public void switchToNewTab() {

        page.clickPlayground();

        page.switchToNewTab();

        System.out.println("Switched to new tab");
    }


    

    @Test(priority = 5)
    public void verifyTitle() {

        page.clickPlayground();

        page.switchToNewTab();

        String title = page.getTitle();

        System.out.println("Page title : " + title);

        Assert.assertEquals(title, "demosite");
    }


    

    @Test(priority = 6)
    public void switchToParent() {

        page.clickPlayground();

        page.switchToNewTab();

        page.switchToParentWindow();

        System.out.println("Switched back to parent window");
    }


   

    @Test(priority = 7)
    public void verifyLogo() {

        page.clickPlayground();

        page.switchToNewTab();

        page.switchToParentWindow();

        boolean displayed = page.isLogoDisplayed();

        Assert.assertTrue(displayed, "Logo is not displayed");

        System.out.println("Logo is displayed");
    }


    

    @Test(priority = 8)
    public void clickSeleniumTraining() {

        page.clickSeleniumTraining();

        System.out.println("Selenium Training clicked successfully");
    }

}