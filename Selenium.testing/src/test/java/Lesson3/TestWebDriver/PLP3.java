package Lesson3.TestWebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PLP3 {

	  WebDriver driver;
	  
	
	String url = "https://demo.nopcommerce.com";
	String browser = "chrome" ; 
	
	  
  
  @BeforeMethod
  public void TestSetup() {
	  
	 if (browser == "chrome") {
		 driver = WebDriverManager.chromedriver().create();
	 }
	 else if (browser == "edge") {
		 driver = WebDriverManager.edgedriver().create();
	 }
	 else  {
		 System.out.println("The browser is not available");
	 }
	  
		  
	  driver.get(url);
	  driver.manage().window().maximize();
	  
	  
  }
  @Test
  public void Verify_TheFilter_Option_Is_Working() {
	  
	  WebElement com_category1 = driver.findElement(By.xpath("(//a[@href='/computers'])[1]"));
	  Actions action = new Actions(driver);
	  action.moveToElement(com_category1).build().perform();
	  
	  WebElement notebook_sub = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));
	  action.moveToElement(notebook_sub);
	  action.click().build().perform();
	  
	  WebElement filter_i5 = driver.findElement(By.xpath("//label[@for='attribute-option-6'] "));
	  WebElement filter_8ram = driver.findElement(By.xpath("//label[@for='attribute-option-9'] "));
	
	  
	  filter_i5.click();
	  filter_8ram.click();
	  
	  String desired_url = "https://demo.nopcommerce.com/notebooks?viewmode=grid&orderby=0&pagesize=6&specs=6%2C9";
	  System.out.println(desired_url);
	  Assert.assertEquals(driver.getCurrentUrl(), desired_url);
	  System.out.println("Currently shopping by: CPU Type: Intel Core i5, Memory: 8 GB");
	  		
	  
  }
	
 @Test
 public void Check_if_the_button_REMOVE_FILTER_is_clearing_the_filtered_choises() {
	 
	 WebElement com_category = driver.findElement(By.linkText("Computers"));
	 Actions action = new Actions(driver);
	 action.moveToElement(com_category).build().perform();
	 
	 WebElement notebook_sub = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));	  
	 action.moveToElement(notebook_sub);
	 action.click().build().perform();
	 
	 WebElement filter_i5 = driver.findElement(By.xpath("//label[@for='attribute-option-6'] "));
	 WebElement filter_8ram = driver.findElement(By.xpath("//label[@for='attribute-option-9'] "));
	 
	 
	 filter_i5.click();
	 filter_8ram.click();
	 filter_i5.click();
	 filter_8ram.click();
	 
	 String desired_url2 = "https://demo.nopcommerce.com/notebooks?viewmode=grid&orderby=0&pagesize=6";
	 System.out.println(desired_url2);
	 Assert.assertEquals(driver.getCurrentUrl(), desired_url2);
	 System.out.println("Filtered option cleared and all the products in that category are displayed");
	 		
 
	    
	  
  }
 
 @Test
 public void Verify_the_sorting_and_displaying_option_on_the_product_page_is_working_correctly() {
	 
	 WebElement com_category = driver.findElement(By.linkText("Computers"));
	 Actions action = new Actions(driver);
	 action.moveToElement(com_category).build().perform();
	 action.click().build().perform();
	 
	 WebElement notebook_sub = driver.findElement(By.linkText("Notebooks"));
	 action.moveToElement(notebook_sub);
	 action.click().build().perform();
	 
	 WebElement sort_by = driver.findElement(By.id("products-orderby"));
	 Select select = new Select(sort_by);
	 select.selectByValue("10");
	  
	  
	 WebElement displayPerPage = driver.findElement(By.id("products-pagesize"));
	 Select select1 = new Select(displayPerPage);
	 select1.selectByValue("3");
	 
	 WebElement productInList = driver.findElement(By.xpath("//a[@class='viewmode-icon list']"));
	 productInList.click();
	 
	 JavascriptExecutor scroll = (JavascriptExecutor)driver;
	 scroll.executeAsyncScript("window.scroll(0,800)");
	 
	 WebElement second_page = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div[2]/ul/li[2]/a"));
	 second_page.click();
	 
	 String expected_url = "https://demo.nopcommerce.com/notebooks?pagenumber=2&viewmode=list&orderby=10&pagesize=3";
	 System.out.println(expected_url);
	 Assert.assertEquals(driver.getCurrentUrl(), expected_url);
	 System.out.println("Products are displayed as list the next 3 products are displayed on the second page");
	 
	 
 }
 
 @Test
 public void Confirm_that_HP_Notebook_can_be_found_in_computers_category_and_notebooks_sub_category() {
	 
	 WebElement com_category = driver.findElement(By.linkText("Computers"));
	 Actions action = new Actions(driver);
	 action.moveToElement(com_category).build().perform();
	 action.click().build().perform();
	 
	 WebElement notebook_sub = driver.findElement(By.linkText("Notebooks"));
	 action.moveToElement(notebook_sub);
	 action.click().build().perform();
	 
	 WebElement HP_Envy = driver.findElement(By.xpath("//img[@alt='Picture of HP Envy 6-1180ca 15.6-Inch Sleekbook']"));
	 
	 HP_Envy.click();
	 
	 String expected_url1 = "https://demo.nopcommerce.com/hp-envy-6-1180ca-156-inch-sleekbook";
	 System.out.println(expected_url1);
	 Assert.assertEquals(driver.getCurrentUrl(), expected_url1);
	 System.out.println("Product details page is displayed for HP Envy 6");
	
	 
 }
  
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
	  
  }

}

