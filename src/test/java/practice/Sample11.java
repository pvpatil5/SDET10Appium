package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Sample11 {

	public  AndroidDriver<AndroidElement> driver;
	@Test
	public void  testgeneral ()throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "pavanpatil2");
		caps.setCapability("browserstack.key", "CHAnHaZMHgmzKmpDweBN");

		// Set URL of the application under test
		caps.setCapability("app", "bs://936afcf324167f9081174bbd1e559b374687ad19");

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "Java Android");
		caps.setCapability("name", "first_test");


		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		driver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), caps);


		/* Write your Custom code here */

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Pavan");

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		Thread.sleep(2000);

		scrolling("text","PG 3");


		// Invoke driver.quit() after the test is done to indicate that the test is completed.
		driver.quit();

	}
	public void scrolling(String an , String av)
	{
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + an + "(\"" + av + "\"))");
	}

}


