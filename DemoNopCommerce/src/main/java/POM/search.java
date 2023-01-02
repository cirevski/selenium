package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class search extends Base {
	
	@FindBy(id ="small-searchterms")
	WebElement search_field;
	
	@FindBy(xpath = "//button[@class='button-1 search-box-button']")
	WebElement click_search;
	
	@FindBy(id="advs")
	WebElement advanced_search;
	
	@FindBy(id="cid")
	WebElement category;
	
	@FindBy(id="mid")
	WebElement manufacturer;
	
	@FindBy(xpath="//button[@class='button-1 search-button']")
	WebElement search_advancedbutton;
	
	
	
	public search() {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchForExistingProduct(String product) {
		search_field.sendKeys(product);
		click_search.click();
	}
	public void VerifyThatExistingProductIsDispayed() {
		String desired_url = "https://demo.nopcommerce.com/search?q=nike";
		Assert.assertEquals(driver.getCurrentUrl(), desired_url);
	}
	public void SearchForNonexistingProduct(String product) {
		search_field.sendKeys(product);
		click_search.click();
	}
	public void VerifyThatUserReceivedAMessageToSearchingForANonexistentProduct() {
		driver.getCurrentUrl().contains("No products were found that matched your criteria.");
	}
	public void MakeSureAdvancedSearchIsWorkingProperly(String product) {
		search_field.sendKeys(product);
		click_search.click();
		advanced_search.click();
		SelectDropdown(category, "10");
		SelectDropdown(manufacturer, "3");
		search_advancedbutton.click();
		
	}
	public void VerifyThatAdvancedSearchWorking() {
		String desired_url = "https://demo.nopcommerce.com/search?q=nike&advs=true&cid=10&mid=3&advs=false&isc=false&sid=false";
		Assert.assertEquals(driver.getCurrentUrl(), desired_url);
	}
	public void SearchProductsUsingOneCharacter(String character) {
		search_field.sendKeys(character);
		click_search.click();
		
	}
	public void VerifyThatSearchFunctionHaveCharactersLimit() {
		driver.getCurrentUrl().contains("Search term minimum length is 3 characters");
	}

}
