package in.infosys.pageobject.ebay;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {
	
	
	public SearchPage(AppiumDriver driver)
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id = "com.ebay.mobile:id/text")
	public WebElement  Sign_in_text;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/search_box")
	public WebElement  search_box;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/search_src_text")
	public WebElement  search_source;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/cell_collection_item")
	//public List<WebElement> second_item;
	public List<WebElement> second_item;
	
	//driver.findElementsById("com.ebay.mobile:id/cell_collection_item")
	@AndroidFindBy(id = "com.ebay.mobile:id/textview_item_name")
	public WebElement  title;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/textview_item_price")
	public WebElement  price;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/button_add_to_cart")
	public WebElement  add_to_cart_button;
	
	@AndroidFindBy(id = "android.widget.ImageView")
	public WebElement  cartbutton;
	  
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='65 inch tv 4k']")
	public WebElement search_list;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/menu_cart")
	public WebElement cart_image;

	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Remove']")
	public WebElement remove;
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement  remove_popup_button;
	
	public String search_text = "65-inch TV";
	//search key result = com.ebay.mobile:id/text
	//second_item = com.ebay.mobile:id/cell_collection_item.get(1)
//title = com.ebay.mobile:id/textview_item_name
//prise = com.ebay.mobile:id/textview_item_price
//	add_to_cart_button = com.ebay.mobile:id/button_add_to_cart
//	cartbutton = android.widget.ImageView
	
	public void Search (AndroidDriver<AndroidElement> driver)
	{
		CheckoutPage c = new CheckoutPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement cart_image = null;
		
		Assert.assertTrue(search_box.isDisplayed());
	    search_box.click();

	    search_source.sendKeys(search_text);


	    search_list.click();   
	       
	    
	    second_item.get(1).click();    	   
	    

	    Assert.assertTrue(title.isDisplayed());
	    Assert.assertTrue(price.isDisplayed());
	    
	    String s_Title = title.getText();
	    System.out.println(s_Title); 
	    String s_price = price.getText();	    
	    System.out.println(s_price);
	    
	    driver.findElementByAndroidUIAutomator
	    ("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.ebay.mobile:id/button_add_to_cart\"));").click();
	    

	    
	    
		cart_image = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.ebay.mobile:id/menu_cart"))));
	    
		cart_image.click();
			    
	   c.checkout_button.click();
	    

	    
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
	    
	    remove.click();
	    

	    remove_popup_button.click();

	}
}
