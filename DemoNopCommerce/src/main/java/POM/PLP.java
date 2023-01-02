package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import test_data.test_data;

public class PLP extends Base {
	
	test_data td;
	
	@FindBy(xpath="(//a[@href='/computers'])[1]")
	WebElement computerslink;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div/a/img")
	WebElement notebookslink;
	
	@FindBy(xpath="(//a[@href='/books'])[1]")
	WebElement books;
	
	@FindBy(xpath="//a[@class='viewmode-icon list']")
	WebElement listview;
	
	@FindBy(xpath="//label[@for='attribute-option-6'] ")
	WebElement filter_i5;
	
	@FindBy(xpath="//label[@for='attribute-option-9'] ")
	WebElement filter_8ram;
	
	@FindBy(xpath="//div[@class='details']/h2[@class='product-title']/a")
	WebElement Samsung;
	
	public PLP() {
		PageFactory.initElements(driver, this);
	}
	public void OpenPLPForNotebooks() {
		MouseActAndClick(computerslink);
		
		MouseActAndClick(notebookslink);
	}
	public void OpenPLPForNotebooksAndSortInListViewmode() {
		MouseActAndClick(computerslink);
		MouseActAndClick(notebookslink);
		listview.click();
	}
	public void OpenPLPForBooks() {
		MouseActAndClick(books);
	}
	public void CheckAreFilterWorksCorrectlyForNotebooks() {
		MouseActAndClick(computerslink);
		Wait(notebookslink);
		MouseActAndClick(notebookslink);
		filter_i5.click();
		filter_8ram.click();
		Wait(Samsung);
		MouseActAndClick(Samsung);
	}
	
	public void VerifyThatPLPForNotebooksIsDispayed() {
		String url_notebooks = "https://demo.nopcommerce.com/notebooks";
		Assert.assertEquals(driver.getCurrentUrl(), url_notebooks);
	}
	public void VerifyThatNotebooksProductsIsDispayedInList() {
		String notebooks_listview = "https://demo.nopcommerce.com/notebooks?viewmode=list&orderby=0&pagesize=6";
		Assert.assertEquals(driver.getCurrentUrl(), notebooks_listview);
	}
	public void VerifyThatFiltersForRAMAndCPUWorkingCorrectly() {
		driver.getCurrentUrl().contains("Samsung Series 9 NP900X4C-A06US 15-Inch Ultrabook (1.70 GHz Intel Core i5-3317U Processor, 8GB DDR3, 128GB SSD, Windows 8) Ash Black");
		
	}
	public void VerifyThatBooksProductsisDisplayed() {
		String BooksProducts = "https://demo.nopcommerce.com/books";
		Assert.assertEquals(driver.getCurrentUrl(), BooksProducts);
	}

}
