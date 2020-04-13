package amazon.AppiumFramework;

import java.io.IOException;

import org.aspectj.lang.annotation.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.LoginPage;
import pageObject.WelcomePage;

		

public class Amazonfirst extends Base {
	    
	   /**
	   * Test for Login Page
	   * @throws IOException 
	   */
		@Test
		public void testLogin() throws IOException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		LoginPage lPage = new LoginPage(driver);
		lPage.getSignIn().click();
	    }
		
		/**
		 * Test for Welcome Page and sending already registered account number
		 * @throws IOException 
		 */
		@Test(dataProvider = "InputData1", dataProviderClass = TestData.class)
		public void testWelcome(String input) throws IOException {
			AndroidDriver<AndroidElement> driver = Capabilities();
			WelcomePage wPage = new WelcomePage(driver);
			wPage.getEditText().sendKeys(input);
			wPage.getContinue().click();	
	        }
		
		/**
		 * Test for Welcome Page and sending password into the password field
		 * @throws IOException 
		 */
		@Test(dataProvider = "InputData2", dataProviderClass = TestData.class)
		public void testPass(String input) throws IOException {
			AndroidDriver<AndroidElement> driver = Capabilities();
			WelcomePage wPage = new WelcomePage(driver);
			wPage.getPass().sendKeys(input);
			wPage.getSubmit().click();
		    }
		
		
}
