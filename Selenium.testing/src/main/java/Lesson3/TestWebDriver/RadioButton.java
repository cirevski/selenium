package Lesson3.TestWebDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RadioButton {
	
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
	 WebElement radio1_checked = driver.findElement(By.id("my-radio-2"));
	 radio1_checked.click();
	 
	 boolean isRadio1UnChecked = driver.findElement(By.id("my-radio-1")).isEnabled();
	 Assert.assertTrue(isRadio1UnChecked, "The radio button is checked");
	 
	 
 }
 
 @Test
 public void Test_02 () {
	 WebElement radio2_default = driver.findElement(By.id("my-radio-2"));
	 radio2_default.click();
	 
	 boolean isRadio2Checked =  driver.findElement(By.id("my-radio-2")).isSelected();
	 Assert.assertTrue(isRadio2Checked, "The radio button is checked");
 }
  
  

  
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
  }

}
