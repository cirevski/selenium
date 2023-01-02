package Lesson2.Selenium.testing;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;

public class Search_functionality {

	public static void main(String [] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
	
	// TC.01 - Search for existing product  //
		
		//   Open the Chrome browser  //
		
	//System.setProperty("webdriver.chrome.driver", "C:\\Chorme driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	Thread.sleep(20000);
	
	//WebElement search = driver.findElement(By.xpath("//input[@name='q']"));	
	//WebElement button = driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));
	
	//  Navigate to the URL  //
	
	driver.get("https://demo.nopcommerce.com");
	
	// Test Steps  //
	
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("nike");
	driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
	//search.sendKeys("nike");
	//button.click();
	
	
	// verify the URL  //
	
	String act_url=driver.getCurrentUrl();
	System.out.println(act_url);
	
	String desired_url="https://demo.nopcommerce.com/search?q=nike";
	
	Assert.assertEquals(act_url, desired_url);
	
	
	
	
	driver.close();
	driver.quit();
	
	// Open Chrome browser   //
	
	System.setProperty("webdriver.chrome.driver", "C:\\Chorme driver\\chromedriver.exe");
	WebDriver driver1 = new ChromeDriver();
	
	// TC.02 - Search for non-existing product  //
	
	//  Navigate to the URL   //
	driver1.get("https://demo.nopcommerce.com");
	
	// Test steps //
	
	driver1.findElement(By.xpath("//input[@placeholder='Search store']")).sendKeys("Sony");
	driver1.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
	
	String actualurl2 = driver1.getCurrentUrl();
	String expectedurl2 = "https://demo.nopcommerce.com/search?q=Sony";
	Assert.assertEquals(expectedurl2, actualurl2);
	
	System.out.println(actualurl2);
	
	System.out.println("The user receives a message:No products were found that matched your criteria.");
	
	driver1.quit();
	
	// Open Chrome browser  //
	System.setProperty("webdriver.chrome.driver", "C:\\Chorme driver\\chromedriver.exe");
	
	WebDriver driver2 = new ChromeDriver();
	
	// TC.03 - Test if search works for a less then 3 character keyword   //
	
	// Navigate to the URL //
	driver2.get("https://demo.nopcommerce.com");
	
	//   Test steps   //
	
	driver2.findElement(By.id("small-searchterms")).sendKeys("HP");
	driver2.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
	
	System.out.println("The user is redirected on:");
	
	String act_url1=driver2.getCurrentUrl();
	System.out.println(act_url1);
	
	String desired_url1="https://demo.nopcommerce.com/search?q=HP";
	if (act_url1.equals(desired_url1))
	{System.out.println("PASS");
	
	}
	else {
		System.out.println("FAIL");
	}
	System.out.println("and receives a message:Search term minimum length is 3 characters");
	

	driver2.quit();
	
	
	
	
	
			
	
	
	
	}
}
