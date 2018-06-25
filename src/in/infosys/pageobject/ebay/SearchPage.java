package in.infosys.pageobject.ebay;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {

	
	public SearchPage(AppiumDriver driver)
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
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
	
	
}
