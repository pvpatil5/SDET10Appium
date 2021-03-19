package practice;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ParallelExecution {
	AndroidDriver driver;
	//protected static  ThreadLocal <AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	
	@Test
	@Parameters({"deviceName","platformVersion","UDID","port"})
	public  void parallel(String deviceName, String platformVersion, String UDID, String port ) throws Throwable 
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName",deviceName );
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName","Android" );
		cap.setCapability("platformVersion",platformVersion );
		cap.setCapability("UDID", UDID);
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");

		//cap.setCapability("noReset", false);// App starting from zero
		cap.setCapability("noReset", true); // App will start as it is available in phone

		URL url = new URL("http://localhost:"+port+"/wd/hub");
		driver = new AndroidDriver(url, cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Pavan");

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		Thread.sleep(2000);

		//scrolling("text","PG 3");


	}
	//	public void scrolling(String an , String av)
	//	{
	//		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + an + "(\"" + av + "\"))");
	//	}
}



