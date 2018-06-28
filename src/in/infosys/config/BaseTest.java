package in.infosys.config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
public class BaseTest 
{


		public static AndroidDriver<AndroidElement>  capabilities() throws MalformedURLException
		{
			

		AndroidDriver<AndroidElement>  driver;
		
			// TODO Auto-generated method stub
		 File appDir = new File("src");
	     File app = new File(appDir, "eBay.apk");
	     
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	     capabilities.setCapability(MobileCapabilityType.FULL_RESET,"True");
	     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "S4");
	     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	     driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 
	     
	     
	     return driver;
		}
		

		

	
}
