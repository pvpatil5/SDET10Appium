package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserStaclSample
{

	@Test
	public void browserstack() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "pavanpatil2");
		caps.setCapability("browserstack.key", "CHAnHaZMHgmzKmpDweBN");

		// Set URL of the application under test
		caps.setCapability("app", "bs://fc2f99cc2e973a54ae591c51a96cd60c78f40047");

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "Java Android");
		caps.setCapability("name", "first_test");


		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), caps);


		/* Write your Custom code here */

		WebElement element=driver.findElementByAccessibilityId("Views");

		driver.tap(1, element, 500);

		driver.findElementByAccessibilityId("Controls").click();

		driver.findElementByAccessibilityId("2. Dark Theme").click();

		driver.hideKeyboard();

		driver.findElementByXPath("//android.widget.TextView[@text='Mercury']").click();

		//driver.findElementByXPath("//android.widget.CheckedTextView[@text='Earth']").click();

		List<AndroidElement> options=	driver.findElementsByClassName("android.widget.CheckedTextView");

		System.out.println("no. of options present="+options.size());

		String exp= "Jupiter";

		for(MobileElement e : options) 
		{
			String actual=	e.getText();
			if(actual.equals(exp)) 
			{
				e.click();
				break;
			}
		}

		// Invoke driver.quit() after the test is done to indicate that the test is completed.
		driver.quit();

	}

}

