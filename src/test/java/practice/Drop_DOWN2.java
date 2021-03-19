package practice;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Drop_DOWN2
{
	AndroidDriver driver;

	@Test
	public void scrollbyswipe() throws Throwable 
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");

		//cap.setCapability("noReset", false);// App starting from zero
		cap.setCapability("noReset", true); // App will start as it is available in phone

		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(url, cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Pavan");
		
		driver.findElementById("android:id/text1").click();
		
		scrolling("text", "India");
		
		driver.findElementByXPath("//android.widget.TextView[@text='India']").click();
		
		
		WebElement image = driver.findElement(By.id(""));
		
		driver.zoom(image);
		
		
		
		driver.pinch(image);
		
	}
	public void scrolling(String an , String av)
	{
	driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + an + "(\"" + av + "\"))");
	}
	
}