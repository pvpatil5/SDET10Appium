package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Tap {


	DesiredCapabilities cap = new DesiredCapabilities();
	AndroidDriver driver ;

@Test
	public void tapOnElement() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", ".cal.AllInOneCalculatorActivity");

		URL url = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(url, cap);

		TouchAction ta = new TouchAction(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MobileElement agreebtn	=(MobileElement) driver.findElementById("android:id/button1");

		ta.longPress(agreebtn).waitAction(500).release().perform();

		MobileElement btn5 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_5_s");

		ta.longPress(btn5).waitAction(500).release().perform();

		driver.findElementByAccessibilityId("plus").click();

		driver.findElementById("com.miui.calculator:id/btn_3_s").click();


	}


	public void taponelement(MobileElement element) 
	{

		driver.tap(1, element, 500);

	}

}