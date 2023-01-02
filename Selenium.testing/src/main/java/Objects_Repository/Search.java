package Objects_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Test_data.test_data;

public class Search extends Base {

	
	test_data td = new test_data();
	
	@FindBy(id ="small-searchterms")
	WebElement Search_input;
	
	@FindBy(xpath = "//button[@class='button-1 search-box-button']")
	WebElement click_search;
	
	@FindBy(id="small-searchterms")
	WebElement search_Field;
	
	public Search() {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchForExistingProduct(String search_data) {
		search_Field.click();
		Search_input.sendKeys(search_data);
		click_search.click();
	}
	public void SearchForNonexistingProduct(String search_data) {
		search_Field.click();
		Search_input.sendKeys(search_data);
		click_search.click();
	}
	public void VerifyThatNikeProductsisDisplayed() {
		String act_url=driver.getCurrentUrl();
		System.out.println(act_url);
		
		String expected_url = "https://demo.nopcommerce.com/search?q=Nike";
		
		Assert.assertEquals(act_url, expected_url);
	}
	
	public void VerifyThatProductisNotAvailable() {
		
		String actualurl2 = driver.getCurrentUrl();
		String expectedurl2 = "https://demo.nopcommerce.com/search?q=Sony";
		Assert.assertEquals(expectedurl2, actualurl2);
		
		System.out.println(actualurl2);
		
		System.out.println("The user receives a message:No products were found that matched your criteria.");
	}
	
	

}
