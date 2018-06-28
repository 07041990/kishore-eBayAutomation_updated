package in.infosys.testcases.ebay;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import in.infosys.config.BaseTest;

import in.infosys.pageobject.ebay.CheckoutPage;
import in.infosys.pageobject.ebay.HomePage;
import in.infosys.pageobject.ebay.SearchPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class test extends BaseTest{
	
	@Test
	public  void ebaytest() throws MalformedURLException, InterruptedException
	{
		
		AndroidDriver<AndroidElement>  driver = capabilities();
		
			
	    HomePage h = new HomePage(driver);
	    SearchPage s = new SearchPage(driver);

	   	   	   
//sign in 
	    	
		h.sign_in(driver);
	    
	    
//search
		s.Search (driver);
		
  
	    
	}
}