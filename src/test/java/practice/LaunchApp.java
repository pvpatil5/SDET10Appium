package practice;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class LaunchApp
{
	@Test
	public void launch() throws Throwable 
	{
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", ".cal.AllInOneCalculatorActivity");

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/button1").click();
		
		driver.findElementById("com.miui.calculator:id/btn_5_s").click();
		
		driver.findElementByAccessibilityId("plus").click();
		
		driver.findElementById("com.miui.calculator:id/btn_3_s").click();

	}
}
