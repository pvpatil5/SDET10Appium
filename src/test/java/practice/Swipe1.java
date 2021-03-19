package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Swipe1 
{
	@Test
	public void swipe() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		cap.setCapability("appActivity", ".TouchScreenTestActivity");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver	driver =  new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		
		//vertical swipe
		driver.swipe(200, 200, 200, 1600, 500);
		//Horizontal Swipe
		driver.swipe(200, 1600, 900, 1600, 500);

	

	}
}