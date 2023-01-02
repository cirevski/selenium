package Objects_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Test_data.test_data;

public class PLP extends Base{
	
	test_data td = new test_data();
	
	
	@FindBy(xpath = "(//a[@href='/computers'])[1]")
	WebElement com_category;	
    
    @FindBy(xpath="(//a[@href='/notebooks'])[1]")
    WebElement category_notebook;
    
    @FindBy(xpath="//label[@for='attribute-option-6'] ")
    WebElement filter_i5;
    
    @FindBy(xpath="//label[@for='attribute-option-9'] ")
    WebElement ram_8G;
    
    @FindBy(xpath="//img[@alt='Picture of HP Envy 6-1180ca 15.6-Inch Sleekbook']")
    WebElement HP_Envy;
    
    public PLP () {
    	PageFactory.initElements(driver, this);
    }
    
    public void VerifyTheFilterOptionIsWorking() {
    
    com_category.click();
    category_notebook.click();
    filter_i5.click();
    ram_8G.click();
    
    }
    
    public void Confirm_that_HP_Notebook_can_be_found_in_computers_category_and_notebooks_sub_category() {
    com_category.click();
    category_notebook.click();
    scrollToElement(HP_Envy);
    HP_Envy.click();
    
    }
    
    public void VeryfyThatFiltersWorksCorrectly() {
    	String desired_url2 = "https://demo.nopcommerce.com/notebooks?viewmode=grid&orderby=0&pagesize=6";
   	    System.out.println(desired_url2);
   	    Assert.assertEquals(driver.getCurrentUrl(), desired_url2);
   	    System.out.println("Filtered option cleared and all the products in that category are displayed");	
    	
    }
    public void VerifyThatHP_EnvyPDPisDisplayed() {
        String expected_url1 = "https://demo.nopcommerce.com/hp-envy-6-1180ca-156-inch-sleekbook";
   	    System.out.println(expected_url1);
   	    Assert.assertEquals(driver.getCurrentUrl(), expected_url1);
   	    System.out.println("Product details page is displayed for HP Envy 6");
    }

}
