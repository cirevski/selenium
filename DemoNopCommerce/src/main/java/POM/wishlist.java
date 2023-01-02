package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class wishlist extends Base {
	
	@FindBy(linkText = "Books")
	WebElement books;	
	
	@FindBy(linkText = "Apparel")
	WebElement apparel;
	
	@FindBy(id = "product_attribute_6")
	WebElement size;
	
	@FindBy(id = "product_attribute_7")
	WebElement color;
	
	//@FindBy(xpath = "//p[@class='content']/a")
	//WebElement alert_forNike;
	
	@FindBy(xpath = "(//span[@class='attribute-square-container'])[1]")
	WebElement natural_print;
	
	@FindBy(xpath = "//div[@class='sub-category-item']/h2[@class='title']/a[contains(text(),'Shoes')]")
	WebElement shoes;
	
	@FindBy(xpath = "//div[@class='details']/h2[@class='product-title']/a[contains(text(),'Floral')]")
	WebElement nike_floral;
	
	@FindBy(id = "add-to-wishlist-button-24")
	WebElement add_toWishNike;
	
	@FindBy(xpath = "//div[@class='details']/h2[@class='product-title']/a[contains(text(),'First Prize Pies')]")
	WebElement FirstPrizePies;
	
	@FindBy(id="add-to-wishlist-button-38")
	WebElement add_toWish;
	
	@FindBy(xpath = "//p[@class='content']/a")
	WebElement alert_wish;
	
	@FindBy(xpath = "//button[@name='addtocartbutton']")
	WebElement addToCard;
	
	@FindBy(xpath = "//td[@class='add-to-cart']/input")
	WebElement checkbox_addtocard;
	
	
	
	
	
	public wishlist() {
		PageFactory.initElements(driver, this);
	}
	

	public void CheckAddProductsToCartFromWishlistPageFunctionalityIsWorkingCorrectly() {
		books.click();
		FirstPrizePies.click();
		add_toWish.click();
		Wait(alert_wish);
		MouseActAndClick(alert_wish);
		MouseActAndClick(checkbox_addtocard);
		addToCard.click();
				
		
	}
	public void VerifyTheProductSuccesfullyAddedTo_add_to_cart_page () {
		
		String expected_url = "https://demo.nopcommerce.com/cart";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}
	public void TryToAddToWishListNikeFloralWithoutChoosingSizeColorPrint () {
		apparel.click();
		shoes.click();
		nike_floral.click();
		ScrollToElementAndClick(add_toWishNike);
	}
	public void VerifyThatUserCannotAddToWishListNikeFloralWithoutChoosingSizeColorPrint () {
		driver.getCurrentUrl().contains("Please select Size\r\n"
				+ "\r\n"
				+ "Please select Color\r\n"
				+ "\r\n"
				+ "Please select Print");
	}
	public void TryToAddToWishListNikeFloralWithChoosingSizeColorPrint () {
		apparel.click();
		shoes.click();
		nike_floral.click();
		JavascriptExecutor s = (JavascriptExecutor) driver;
		s.executeScript("window.scrollBy(0,450)");
		SelectDropdown(size, "15");
		SelectDropdown(color, "17");
		natural_print.click();
		ScrollToElementAndClick(add_toWishNike);
		Wait(alert_wish);
		MouseActAndClick(alert_wish);
		
	}
	public void VerifyThatNikeFloralisAddedToWishList () {
		driver.getCurrentUrl().contains("Nike Floral Roshe Customized Running Shoes");
		
	}
	

}
