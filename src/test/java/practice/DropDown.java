package practice;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DropDown 
{

	//AndroidDriver driver;

	@Test
	public void dropDown() throws Throwable 
	{
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("UDID", "emulator-5554");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "ApiDemos");

		//cap.setCapability("noReset", false);// App starting from zero
		cap.setCapability("noReset", true); // App will start as it is available in phone

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, cap);


		Thread.sleep(3000); 
		WebElement element=driver.findElementByAccessibilityId("Views");

		driver.tap(1, element, 500);

		driver.findElementByAccessibilityId("Controls").click();

		driver.findElementByAccessibilityId("2. Dark Theme").click();

		driver.hideKeyboard();

		driver.findElementByXPath("//android.widget.TextView[@text='Mercury']").click();

		//driver.findElementByXPath("//android.widget.CheckedTextView[@text='Earth']").click();

		List<MobileElement> options=	driver.findElementsByClassName("android.widget.CheckedTextView");

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


	}
}


