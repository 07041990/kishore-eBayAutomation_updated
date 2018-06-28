package in.infosys.pageobject.ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {
	
	
	public CheckoutPage(AppiumDriver driver)
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
		
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Checkout']")
	public WebElement  checkout_button;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/item_title")
	public WebElement  check_title;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/item_price")
	public WebElement  check_price;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/toolbar_close_button")
	public WebElement  checkout_close_button;
	

	
		

}
