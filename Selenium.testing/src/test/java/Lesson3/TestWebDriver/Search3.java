package Lesson3.TestWebDriver;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class Search3 {
	
	 WebDriver driver;
	
	String url = "https://demo.nopcommerce.com";
	String browser = "chrome";
	
	
  @Test
  public void Search_for_Existing_Product() {
	  
	  WebElement search = driver.findElement(By.xpath("//input[@name='q']"));	
	  WebElement button = driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));
	  search.sendKeys("NIKE");
	  button.click();
	  
	  

	  String desired_url="https://demo.nopcommerce.com/search?q=nike";
	
	  String actual_url=driver.getCurrentUrl();
	 
	  if  (actual_url.equalsIgnoreCase(desired_url)) {
		  System.out.println("PASS");
	  }
	
	  else  {
		  System.out.println("FAIL");
	  }
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  if (browser == "chrome") {
		  driver = WebDriverManager.chromedriver().create();
	  }
	  else {
	  driver = WebDriverManager.edgedriver().create();
	  }
		  
	  
	  
	  driver.get(url);
	  
	  driver.manage().window().maximize();
	  
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  
	  driver.close();
	  driver.quit();
  }

}

