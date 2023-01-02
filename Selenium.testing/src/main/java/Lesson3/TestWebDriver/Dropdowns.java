package Lesson3.TestWebDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Dropdowns {
	
	WebDriver driver;
	  
	String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
	String browser = "chrome" ; 
	
  
  @BeforeMethod
  public void beforeMethod() {
	  if (browser == "chrome") {
		  driver = WebDriverManager.chromedriver().create();
	  }
	  else if (browser == "edge") {
		  driver = WebDriverManager.edgedriver().create();
	  }
		  
	  driver.get(url);
	  driver.manage().window().maximize();
  }
  
  @Test
  public void Test_01() {
	  
	  WebElement DDown_select = driver.findElement(By.xpath("//select[@class='form-select']"));
	  Select select = new Select(DDown_select);
	  
	  select.selectByValue("2");
	  System.out.println("We choose number Two");
	  
	  select.selectByIndex(3);
	  System.out.println("Second we choose number three, but this time by index");
	  
	  
  }
  @Test
  public void Test_02() {
	  
	 WebElement DDown_datalist = driver.findElement(By.name("my-datalist"));
	 DDown_datalist.sendKeys("New York");
	  
	 System.out.println("I really love this city");
	  
  }
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.quit();
  }

}
