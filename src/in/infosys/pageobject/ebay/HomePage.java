package in.infosys.pageobject.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
		public HomePage(AppiumDriver driver)
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
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
	

}
