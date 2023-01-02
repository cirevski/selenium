package Lesson3.TestWebDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class MauseOver3 {
	
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
  public void Test_01 () {
	  
	  WebElement color = driver.findElement(By.xpath("//input[@type='color']"));
	  
	  Actions act = new Actions(driver);
	  
	  act.moveToElement(color);
	  act.click(color).build().perform();
	 
	  
	  
  }
  
  @Test
  public void Test_02() {
	  WebElement text = driver.findElement(By.xpath("//input[@id='my-text-id']"));
	  
	  Actions act1 = new Actions(driver);
	  
	  act1.moveToElement(text);
	  act1.click().sendKeys("Hello").build().perform();
	  

	  
  }
  
  @Test
  public void Test_03() {
	  WebElement file = driver.findElement(By.name("my-file"));
	  Actions act2 = new Actions(driver);
	  
	  act2.moveToElement(file);
	  act2.click().build().perform();
	  
	  System.out.println("The file selection window is open");
  }
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
  }

}
