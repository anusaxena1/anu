package amazon.AppiumFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.ShoppingPage;
import utilities.Utility;

public class AmazonSecond extends Base {
	
	/**
	 * Test for the searching the product and navigating to product page 
	 */
	
	@Test(dataProvider = "InputData3", dataProviderClass = TestData.class)
	public void testSearch(String input) throws IOException {
	AndroidDriver<AndroidElement> driver = Capabilities();
	HomePage hPage = new HomePage(driver);
	Utility uPage = new Utility(driver);
	hPage.getSearchBox().sendKeys(input);
	uPage.scrollToText("VIVO Universal LCD Flat Screen TV Table Top VESA Mount Stand Black | Base fits 22... 4.5 out of 5 stars 6,081");
	hPage.vivo.get(44).click();
    }
	
	/**
	 * Test for the navigating the see all buy button and clicking the button 
	 */
	@Test
	public void testSeeAll() throws IOException{ 
		AndroidDriver<AndroidElement> driver = Capabilities();
		ProductPage pPage = new ProductPage(driver);
		Utility uPage = new Utility(driver);
		uPage.scrollToText("See All Buying Options");
		pPage.getSeeAll().click();	
		
	}
	
	/**
	 * Test for adding the product to cart page  
	 * @throws IOException 
	 */
	@Test
	public void testAddProduct() throws IOException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		ShoppingPage sPage = new ShoppingPage(driver);
		sPage.getAddtoCart().click();
	}
	
	/**
	 * Test for navigating the cart page 
	 * @throws IOException 
	 */
	@Test
	public void testCartPage() throws IOException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		ShoppingPage sPage = new ShoppingPage(driver);
		sPage.getCartPage().click();
	}
	
	/**
	 * Test for validating the selected product on the cart page
	 * @throws IOException 
	 */
	
	@Test
	public void testValidateProduct() throws IOException{
		AndroidDriver<AndroidElement> driver = Capabilities();
		CartPage cPage = new CartPage(driver);
		String expected=cPage.getsProduct().get(1).getText();
		assertEquals("VIVO Universal LCD Flat Screen TV Table Top VESA Mount Stand Black | Base fits 22... 4.5 out of 5 stars 6,081",expected);
	}
	
}
