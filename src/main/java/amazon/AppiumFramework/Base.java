package amazon.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public static AndroidDriver<AndroidElement>  driver;
	public static AndroidDriver<AndroidElement> Capabilities() throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\amazon\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		AppiumDriverLocalService appiumDriverLocalService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\ANU SAXENA\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort());
        appiumDriverLocalService.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        String device = (String) prop.get("device");
        String version = (String) prop.get("version");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        String appPackage = (String) prop.get("appPackage");
        String appActivity = (String) prop.get("appActivity");
        cap.setCapability("appPackage", appPackage);
        cap.setCapability("appActivity", appActivity);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumDriverLocalService.getUrl(), cap);
		return driver;
	}
	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}
}
