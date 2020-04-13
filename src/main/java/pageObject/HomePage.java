package pageObject;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private WebElement searchbox;
	
	public WebElement getSearchBox() {
		System.out.println("Trying to enter any search to the search box");
		return searchbox;
	}
	
	@AndroidFindBy(className = "android.view.View")
	public List<WebElement> vivo;

}
