package practice;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class MobileWeb
{

		@Test
		public void launchchrome() throws Throwable 
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "7.0");
			cap.setCapability("UDID", "d6c768cf9804");
//			cap.setBrowserName("Chrome");
//			cap.setCapability("browserName", "Chrome");
//			cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			
			//cap.setCapability("noReset", false);// App starting from zero
			cap.setCapability("noReset", true); // App will start as it is available in phone

			URL url = new URL("http://localhost:4723/wd/hub");
			AndroidDriver driver = new AndroidDriver(url, cap);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get("https://www.facebook.com");
			
//			Thread.sleep(2000);
//			dr.findElementByXPath("//input[@id='m_login_email']").sendKeys("qwerty");
//			Thread.sleep(2000);
//			WebElement element=	dr.findElement(By.id("m_login_password"));
//			element.sendKeys("123456");


		}

	}
