package Objects_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.Base;
import Test_data.test_data;

public class ShoppingCart extends Base {
	
	test_data td = new test_data();

	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[5]/a")
	WebElement book_category;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")
    WebElement add_to_cart;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	WebElement Shop_cart;
	
	@FindBy(xpath = "//button[@class= 'remove-btn']")
	WebElement remove;
	
	@FindBy(xpath = "//input[@class=\"qty-input\"]")
	WebElement quantity;
	
	@FindBy(id = "updatecart")
	WebElement update;
	
	@FindBy(xpath = "//div[@class='no-data']")
	WebElement empty_cart;
	
	public ShoppingCart() {
		PageFactory.initElements(driver, this);
	}


	public void RemoveProductWithRemoveCheckbox() {
		book_category.click();
		scrollToElement(add_to_cart);
		mouseAct(add_to_cart);
		wait(Shop_cart);
		Shop_cart.click();
		remove.click();
		
	}
	public void RemoveProductByEntering0Quantity(String quantity_num) {
		book_category.click();
		scrollToElementAndClick(add_to_cart);
		wait(Shop_cart);
		Shop_cart.click();
		mouseAct(quantity);
		quantity.clear();
		quantity.sendKeys(quantity_num);
		update.click();
		
	}
	
	public void VerifyThatShoppingCartIsEmpty() {
		String CartIsEmpty = "Your Shopping Cart is empty!";
		
		if (driver.getPageSource().contains(CartIsEmpty));{
		printText("Test PASS");
		}

	}	
}
	