package Lesson3.TestWebDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CheckBoxes3 {
	
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
  WebElement box1_checked = driver.findElement(By.xpath("//input[@id='my-check-1']"));
	 box1_checked.click();//uncheck the box.
	 
	 boolean isBox1Checked = driver.findElement(By.xpath("//input[@id='my-check-1']")).isEnabled();
	 Assert.assertTrue(isBox1Checked, "The box is not selected");
  }
  @Test
  public void Test_02 () {
  WebElement Box2_default = driver.findElement(By.id("my-check-2"));
	 Box2_default.click();
	 
	 boolean isBox2Checked = driver.findElement(By.id("my-check-2")).isSelected();
	 Assert.assertTrue(isBox2Checked, "The box is checked");
  }
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
  }

}
