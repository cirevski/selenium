package Objects_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Test_data.test_data;

public class Wishlist extends Base {
	
	test_data td = new test_data();
	
	@FindBy(xpath = "(//a[@href='/books'])[1]")
	WebElement books;	
	
	@FindBy(xpath = "(//button[@class='button-2 add-to-wishlist-button'])[2]")
	WebElement add_toWish;
	
	@FindBy(xpath = "(//a[@href='/wishlist'])[1]")
	WebElement Wish_listPage;
	
	@FindBy(xpath = "//button[@name='addtocartbutton']")
	WebElement addToCard;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]/input")
	WebElement checkbox_addtocard;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[6]/input")
	WebElement quantity;
	
	@FindBy(xpath = "(//button[@name='updatecart'])[2]")
	WebElement update;
	
	@FindBy(xpath = "//span[@class='product-subtotal']")
	WebElement Value;
	
	public Wishlist() {
		PageFactory.initElements(driver, this);
	}
	

	public void Check_Add_products_to_Cart_from_wishlist_page_functionality_is_working_correctly() {
		books.click();
		wait(add_toWish);
		mouseAct(add_toWish);
		mouseAct(Wish_listPage);
		mouseAct(checkbox_addtocard);
		addToCard.click();		
		
	}
	public void VerifyThe_product_succesfully_added_to_add_to_cart_page () {
		
		String expected_url = "https://demo.nopcommerce.com/cart";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
		
	}
	public void Check_if_the_total_price_is_calculated_correctly (String Quantity) {
		books.click();
		wait(add_toWish);
		mouseAct(add_toWish);
		wait(Wish_listPage);
		mouseAct(Wish_listPage);
		quantity.clear();
		quantity.sendKeys(Quantity);
		update.click();
	}
	public void VerifyThatPriceGrowsFiveTimes () {
		
		
		Value.getText();
	
		print(Value);		
		
	}
}
