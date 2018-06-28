package in.infosys.pageobject.ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import in.infosys.config.BaseTest;
import in.infosys.testcases.ebay.ReusedElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage  {
	
		public HomePage(AppiumDriver driver)
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	
			
	@AndroidFindBy(id ="com.ebay.mobile:id/sign_in_title")
	public WebElement  Sign_in_title;
		
	@AndroidFindBy(id = "com.ebay.mobile:id/edit_text_username")
	public WebElement  Sign_in_text;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/edit_text_password")
	public WebElement Sign_in_password;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
	public WebElement Sign_in_button;
	
	
	@AndroidFindBy(id = "com.ebay.mobile:id/button_google_deny")
	public WebElement no_link;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
	public WebElement second_sign_in;
	

	
	
	public String username = "portalqateam@gmail.com";
	public String password = "portal@123";
	public String serch_key = "65-inch TV";
	
	public void sign_in (AndroidDriver<AndroidElement> driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement Sign_in,no_thanks,cart_image;
		
	ReusedElements.click(driver, By.id("com.ebay.mobile:id/button_sign_in") );	
	
	
	Assert.assertTrue(Sign_in_text.isDisplayed());
	Assert.assertTrue(Sign_in_text.isDisplayed());
	
	Sign_in_text.sendKeys(username);
		
	Sign_in_password.sendKeys(password);
	
	ReusedElements.click(driver, By.id("com.ebay.mobile:id/button_sign_in") );
    no_thanks = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.ebay.mobile:id/button_google_deny"))));
    
    Assert.assertTrue(no_thanks.isDisplayed());
	Reporter.log("User successfully signed in", true);
    
    no_thanks.click();
	}
	
	

}
