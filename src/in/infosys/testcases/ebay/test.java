package in.infosys.testcases.ebay;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class test extends BaseTest{
	
	@Test
	public  void ebaytest() throws MalformedURLException, InterruptedException
	{
		
		AndroidDriver<AndroidElement>  driver = capabilities();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    
		
	    HomePage h = new HomePage(driver);
	    SearchPage s = new SearchPage(driver);
	    CheckoutPage c = new CheckoutPage(driver);
	    
	    
	    WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement Sign_in,no_thanks;
	   
//sign in 
	    
		Sign_in = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.ebay.mobile:id/button_sign_in"))));
		Sign_in.click();

		Assert.assertTrue(h.Sign_in_text.isDisplayed());
		Assert.assertTrue(h.Sign_in_text.isDisplayed());
		
		h.Sign_in_text.sendKeys(h.username);

		h.Sign_in_password.sendKeys(h.password);
		
	    h.second_sign_in.click();
	    
  
	    no_thanks = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.ebay.mobile:id/button_google_deny"))));
	    
	    Assert.assertTrue(no_thanks.isDisplayed());
		Reporter.log("User successfully signed in", true);
	    
	    no_thanks.click();
	    
	    
	    
//search
	    Assert.assertTrue(s.search_box.isDisplayed());
	    s.search_box.click();

	    s.search_source.sendKeys(s.search_text);
	    Thread.sleep(5000);

	    s.search_list.click();   
	    
	    Thread.sleep(5000);
	   
	    
	    s.second_item.get(1).click();    	   
	    
	    Thread.sleep(5000);
	    Assert.assertTrue(s.title.isDisplayed());
	    Assert.assertTrue(s.price.isDisplayed());
	    
	    String s_Title = s.title.getText();
	    System.out.println(s_Title); 
	    String s_price = s.price.getText();	    
	    System.out.println(s_price);
	    
	    driver.findElementByAndroidUIAutomator
	    ("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.ebay.mobile:id/button_add_to_cart\"));").click();
	    Assert.assertTrue(s.cart_image.isDisplayed());
	    Thread.sleep(4000);
	    s.cart_image.click();
	    
	    Thread.sleep(4000);
//checkout	    
	    c.checkout_button.click();
	    
	    Thread.sleep(9000);
	     
	/*    System.out.println(c.check_title.getText());
	
	    System.out.println(c.check_prise.getText());*/
	    
	    String c_Title = c.check_title.getText();
	    System.out.println(c_Title); 
	    String c_price = c.check_price.getText();	    
	    System.out.println(c_price);
	   	
	    
	  //Compare product data vs checkout data
	    
		   
	    if(s_Title.equals(c_Title)) 
	    {
	    
	    	System.out.println("!!!!!!!pass tittle!!!!!!!");
	    	Assert.assertTrue(true, c_Title);
			Reporter.log("Title string comparred successfully", true);
	    }
	    
	    if(s_price.equals(c_price)) 
	    {
	    	System.out.println("$$$$$$$$$$pass price!!!!!!!");
	    	Assert.assertTrue(true, c_price);
			Reporter.log("Price string comparred successfully", true);
	    }
	    
	    c.checkout_close_button.click();
	    
	    s.remove.click();
	    
	    Thread.sleep(2000);
	    s.remove_popup_button.click();

	  
	    
	}
}