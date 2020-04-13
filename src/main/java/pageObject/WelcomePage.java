package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage {

	public WelcomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement editBox;
	
	@AndroidFindBy(id = "continue")
	private WebElement continuebtn;
	
	@AndroidFindBy(id = "ap_password")
	private WebElement password;
	
	@AndroidFindBy(id = "signInSubmit")
	private WebElement signSubmit;
	
	public WebElement getEditText() {
		System.out.println("Trying to enter edit text box field under Login option");
		return editBox;
	}
	
	public WebElement getContinue() {
		System.out.println("Selecting the continue button");
		return continuebtn;
	}
	
	public WebElement getPass() {
		System.out.println("Entering password into the password field");
		return password;
	}
	
	public WebElement getSubmit() {
		System.out.println("Selecting the password field");
		return getSubmit();
	}
	
	
}
