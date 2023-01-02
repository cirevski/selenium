package Lesson3.TestWebDriver;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class PDP3 {

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
	  else {
		  System.out.println("The browser is not available");
	  }
		  
	  driver.get(url);
	  driver.manage().window().maximize();
	  
	 
  }
  @Test
  public void Open_Product_Details_for_a_Product() {
	  
	 
	  WebElement com_category = driver.findElement(By.linkText("Computers"));
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(com_category).build().perform();
	  
	  WebElement notebook_sub = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));	  
	  action1.moveToElement(notebook_sub);
	  action1.click().build().perform();
	  
	  WebElement asus = driver.findElement(By.xpath("//img[@alt='Picture of Asus N551JK-XO076H Laptop']"));
	  asus.click();
	  
	  String desired_url = "https://demo.nopcommerce.com/asus-n551jk-xo076h-laptop";
	  System.out.println(desired_url);
	  Assert.assertEquals(driver.getCurrentUrl(), desired_url);
	  System.out.println("Product details page is displayed for Asus N551JK-XO076H Laptop");
	  
  }
	
 @Test
 public void Write_and_submit_review_for_product_without_login_in() {
	 
	     WebElement ele_category = driver.findElement(By.linkText("Electronics"));
		 Actions action2 = new Actions(driver);
		 action2.moveToElement(ele_category).build().perform();
		 
		 WebDriverWait wait = new WebDriverWait(driver, 5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/camera-photo'])[1]")));
		 
		 WebElement cam_photo_sub = driver.findElement(By.xpath("(//a[@href='/camera-photo'])[1]"));
		 action2.moveToElement(cam_photo_sub);
		 action2.click().build().perform();
		 
		 
		 WebElement leica = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a"));
		 leica.click();
		 
		 WebElement review = driver.findElement(By.xpath("//a[contains(text(),'Add your review')]"));
		 review.click();
		 
		 String desired_mess = "Only registered users can write reviews";
		 String error_mess = driver.findElement(By.xpath("//li[contains(text(),'Only registered users can write reviews')]")).getText();
		 Assert.assertEquals(error_mess, desired_mess);
		 System.out.println(error_mess);
		 
		
	  
  }
 
 @Test
 public void   Check_the_renting_capability_of_product_page_with_rent_end_date_smaller_than_rent_start_date   () {
                           
	 driver.getCurrentUrl();
	 WebElement jewelry_category = driver.findElement(By.linkText("Jewelry"));
	 Actions action3 = new Actions(driver);
	 action3.moveToElement(jewelry_category).build().perform();
	 action3.click().build().perform(); 
	 	 
	 WebElement rent = driver.findElement(By.xpath("//button[contains(text(),'Rent')]"));
	 action3.moveToElement(rent).build().perform();
	 action3.click().build().perform(); 
	 
	 JavascriptExecutor scroll = (JavascriptExecutor)driver;
	 scroll.executeAsyncScript("window.scroll(0,300)");
	 
	 WebElement start_date = driver.findElement(By.xpath("//*[@id=\"rental_start_date_40\"]"));
	 start_date.click();
	 start_date.sendKeys("12/01/2020");
	 
	 WebElement end_date = driver.findElement(By.xpath("//*[@id=\"rental_end_date_40\"]"));
	 end_date.click();
	 end_date.sendKeys("12/03/2020");
	 
	 WebElement quantity = driver.findElement(By.xpath("//input[@aria-label='Enter a quantity']"));
	 quantity.click();
	 quantity.sendKeys("2");
	 
	 WebElement rent_product = driver.findElement(By.id("add-to-cart-button-40"));
	 rent_product.click();
	 
	 
	/* 
	 Integer.parseInt(start_date);
	 Integer.parseInt(end_date);
	 
	 if (start_date < end_date) {
	 System.out.println("Rental start date is less than end date");
	 }
	 else if (start_date > end_date) {
		 System.out.println("FALSE");
	 }
             
	 */
	 
 }
 
 @Test
 public void Check_if_the_product_is_displayed_with_all_the_products_for_the_specific_tag() {
	 	 		
	 WebElement computers = driver.findElement(By.linkText("Computers"));
	 Actions action4 = new Actions(driver);
	 action4.moveToElement(computers).build().perform();
	 action4.click().build().perform();
	 
	 WebElement notebooks = driver.findElement(By.xpath("(//a[@title='Show products in category Notebooks'])[1]"));
	 action4.moveToElement(notebooks).build().perform();
	 action4.click().build().perform();
	 
	 WebElement product_asus = driver.findElement(By.xpath("//div/h2/a[contains(text(),'Asus N551JK-XO076H Laptop')]"));
	 product_asus.click();
	 
	 WebElement awesome_tag = driver.findElement(By.xpath("//a[@href='/awesome']"));
	 awesome_tag.click();
	 
	 WebElement adobe_photoshop = driver.findElement(By.xpath("//a[contains(text(),'Adobe Photoshop CS4')]"));
	 adobe_photoshop.click();
	
	 String expected_url4 = "https://demo.nopcommerce.com/adobe-photoshop-cs4";
	 System.out.println(expected_url4);
	 Assert.assertEquals(driver.getCurrentUrl(), expected_url4);
	 System.out.println("Product details is displayed for Adobe Photoshop CS4");
	 
     driver.getCurrentUrl();
     
     boolean isDisplayed = driver.findElement(By.xpath("//a[@href='/awesome']")).isDisplayed();
	 
     if (isDisplayed) {
		 System.out.println("awesome tag is present there too");
	 }
	 else  {
		 System.out.println("FAIL");
	 }
		
	
	 
 }
  
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
	  
  }

}
