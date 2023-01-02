package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class shopping extends Base {
	
	
	@FindBy(linkText = "Books")
	WebElement book_category;
	
	@FindBy(xpath="//div[@class='details']/h2[@class='product-title']/a[contains(text(),'Fahrenheit 451 by Ray Bradbury')]")
	WebElement book_fahrenheit;
	
	@FindBy(id="add-to-cart-button-37")
	WebElement AddToCart;
	
	@FindBy(xpath = "//p[@class='content']/a")
    WebElement alert_addToCart;
	
	@FindBy(xpath= "//td[@class='remove-from-cart']/button")
	WebElement remove;
	
	@FindBy(xpath="//td[@class='quantity']/input")
	WebElement quantity;
	
	@FindBy(id = "updatecart")
	WebElement update;
	
	@FindBy(xpath="//div[@class='common-buttons']/button[contains(text(),'Continue shopping')]")
	WebElement continue_shopp;
	
	
 
	public shopping() {
		PageFactory.initElements(driver, this);
	}
	
	public void RemoveProductFromCardWithRemoveCheckbox() {
		book_category.click();
		book_fahrenheit.click();
		ScrollToElementAndClick(AddToCart);
		Wait(alert_addToCart);
		MouseActAndClick(alert_addToCart);
		remove.click();
	}
	public void VerifyThatRemoveCheckboxWorksAndShoppingcartIsEmpty() {
		driver.getCurrentUrl().contains("Your Shopping Cart is empty!");
	}
	public void WhenUserIncreasesQuantityofProductIsIncreasingPriceAlso(String Quantity) {
		book_category.click();
		book_fahrenheit.click();
		ScrollToElementAndClick(AddToCart);
		Wait(alert_addToCart);
		MouseActAndClick(alert_addToCart);
		quantity.clear();
		quantity.sendKeys(Quantity);
		update.click();
	}
	public void VerifyThatPriceIsIncreaseWhenUserInceaseQuantity() {
		driver.getCurrentUrl().contains("$135.00");
	}
	public void ContinueShoppingButtonWorksCorrectly() {
		book_category.click();
		book_fahrenheit.click();
		ScrollToElementAndClick(AddToCart);
		Wait(alert_addToCart);
		MouseActAndClick(alert_addToCart);
		continue_shopp.click();
		
		
	}
	public void VerifyThatContinueShoppingButtonWorksCorrectlyAndNavigateUserToPreviousPage() {
		String desired_url = "https://demo.nopcommerce.com/books";
		Assert.assertEquals(driver.getCurrentUrl(), desired_url);
	}
}
