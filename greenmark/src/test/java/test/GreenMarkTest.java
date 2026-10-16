package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class GreenMarkTest extends BaseClass {
	
	@Test(priority = 1)
	public void titleVerification() {
		String title=page.getTitle();
		Assert.assertTrue(title.contains("Green Mark Natural Solutions"));
		System.out.println("title verified : "+title);
	}
	@Test(priority = 2)
	public void menuDisplays() {
		
		page.getMenuNames();
		 boolean displayed = page.areMenusDisplayed();

		    Assert.assertTrue(displayed);

		    System.out.println("Menus are displayed successfully");
	}
	@Test(priority = 3)
	public void menuLinkCounts() {
		int linkcount= page.getMenuLinks();
		System.out.println("total link count = "+linkcount);
		Assert.assertTrue(linkcount > 0, "No links found on the page");
		
	}
	@Test(priority = 4)
	public void shampooSearch() {
		page.searchProduct("shampoo");
		boolean displayed = page.isShampooDisplayed();

	    Assert.assertTrue(displayed);

	    System.out.println("Shampoo search successful");
	}
	@Test(priority = 5)
	public void sortOptionsCount() {
		// Step 5: Search for "shampoo".
		// Note: Each test starts from the home page because @BeforeMethod is in baseclass
		// @BeforeMethod creates a fresh browser session, so this search must be performed again
		// before testing the Sort By dropdown.
		page.searchProduct("shampoo");
		page.dropClick();
		int count= page.getSortOptionsCount();
		Assert.assertEquals(count, 4);
	}
	
	@Test(priority = 6)
	public void selectNewest() {

	    page.searchProduct("shampoo");
	    page.dropClick();
	    page.selectNewest();

	    System.out.println("Newest option selected successfully");
	}
	@Test(priority = 7)
	public void selectShampooProduct() {

	    page.searchProduct("shampoo");
	    page.selectShampooProduct();
	    boolean displayed = page.isAddToCartDisplayed();

	    Assert.assertTrue(displayed);

	    System.out.println("Shampoo product page opened successfully");
	}
	
	@Test(priority = 8)
	public void verifyAddToCartText() {

	    page.searchProduct("shampoo");
	    page.selectShampooProduct();

	    String text = page.getAddToCartText();

	    System.out.println("Button text : " + text);

	    Assert.assertEquals(text, "Add to Cart");
	}
	@Test(priority = 9)
	public void verifyAddToCartEnabled() {

	    page.searchProduct("shampoo");
	    page.selectShampooProduct();

	    boolean enabled = page.isAddToCartEnabled();

	    System.out.println("Add to Cart enabled : " + enabled);

	    Assert.assertTrue(enabled);
	}
	@Test(priority = 10)
	public void clickAddToCart() {

	    page.searchProduct("shampoo");
	    page.selectShampooProduct();

	    page.clickAddToCart();
	    String count = page.getCartCount();

	    System.out.println("Cart count after adding product : " + count);

	    Assert.assertEquals(count, "1");

	}
	
	@Test(priority = 11)
	public void verifyCartCount() {

	    page.searchProduct("shampoo");
	    page.selectShampooProduct();
	    page.clickAddToCart();

	    String count = page.getCartCount();

	    System.out.println("Cart count : " + count);

	    Assert.assertEquals(count, "1");
	}
	
	@Test(priority = 12)
	public void verifyCartPage() {

	    page.searchProduct("shampoo");
	    page.selectShampooProduct();
	    page.clickAddToCart();
	    page.clickCart();
	    String url = page.getCurrentUrl();

	    System.out.println("Cart page URL : " + url);

	    Assert.assertTrue(url.toLowerCase().contains("cart"));
	}
	

}
