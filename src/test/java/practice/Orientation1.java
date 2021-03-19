package practice;

import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class Orientation1 
{
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

		System.out.println(driver.getOrientation());

		driver.rotate(ScreenOrientation.LANDSCAPE);
		System.out.println(driver.getOrientation());
		driver.rotate(ScreenOrientation.PORTRAIT);

		System.out.println("-----------------------------");

			driver.getConnection();
		driver.setConnection(Connection.AIRPLANE);

		driver.setConnection(Connection.ALL);

		driver.setConnection(Connection.WIFI);

		driver.setConnection(Connection.DATA);
		
		System.out.println("------------------------");
		
		driver.isAppInstalled("");


	}
}