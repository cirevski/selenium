package Lesson2.Selenium.testing;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;



public class Exercise1 {
	
	public static void main(String [] args) throws InterruptedException {
			
		
		//  Open the Chrome browser  //
		System.setProperty("webdriver.chrome.driver", "C:\\Chorme driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(20000);
		
		//  Navigate to the URL  //
		
		driver.get("https://demo.nopcommerce.com");
		
		/*TEST CASE N1
		Register new user with valid email-Test steps:*/
		
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//span[@class='male']")).click();
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("robot");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("robovski");
		driver.findElement(By.id("Email")).sendKeys("robot@gmail.com");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("Password")).sendKeys("int123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("int123456");
		driver.findElement(By.xpath("//div[@class='buttons']/button")).click();
		
		
		
		System.out.println("User is successfully registered on the page");
		String act_url=driver.getCurrentUrl();
			System.out.println(act_url);
			
		String desired_url="https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
		if (act_url.equals(desired_url))
		{System.out.println("PASS");
		}
		else {System.out.println("FAIL");
		}
	
		driver.quit();
		
		/*TEST CASE N2
		Register new user with different password and confirm passwork field*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chorme driver\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		
		//  Navigate to the URL  //
		
		driver1.get("https://demo.nopcommerce.com");
		//  Test steps:  //
		
		driver1.findElement(By.className("ico-register")).click();
		driver1.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("robot");
		driver1.findElement(By.id("LastName")).sendKeys("robovski");
		driver1.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[3]")).click();
		driver1.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[5]")).click();
		driver1.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[87]")).click();
		driver1.findElement(By.xpath("//input[@name='Email']")).sendKeys("robot@gmail.com");
		driver1.findElement(By.name("Company")).sendKeys("Interworks");
		driver1.findElement(By.id("Password")).sendKeys("int123456");
		driver1.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("int223456");
		driver1.findElement(By.id("register-button")).click();
		
		String actualurl = driver1.getCurrentUrl();
		String expectedurl = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		Assert.assertEquals(expectedurl, actualurl);
		
		System.out.println(actualurl);
		
		
		System.out.println("The user cannot register on the site, they receive an error message: The password and confirmation password do not match.");
		
		driver1.quit();
		
		/*TEST CASE N.3
		Register new user with empty confirm password*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chorme driver\\chromedriver.exe");
		
		WebDriver driver3 = new ChromeDriver();
		//  Navigate to the URL  //
		driver3.get("https://demo.nopcommerce.com");
		
		//  Test steps  //
		
		driver3.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver3.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("robot");
		driver3.findElement(By.xpath("//input[@type='text' and @id='LastName']")).sendKeys("robovski");
		driver3.findElement(By.xpath("//input[@name='Email']")).sendKeys("robot@gmail.com");
		driver3.findElement(By.id("Password")).sendKeys("int123456");
		driver3.findElement(By.xpath("//input[@name='Company']")).sendKeys("interworks");
		driver3.findElement(By.xpath("//input[@type='password' and @id='Password']")).sendKeys("int123456");
		driver3.findElement(By.id("register-button")).click();
		
		String actualurl1 = driver3.getCurrentUrl();
		String ecpectedurl1 = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		Assert.assertEquals(ecpectedurl1, actualurl1);
		
		System.out.println(actualurl1);
		
		System.out.println("A user cannot register with an empty 'Confirm password' field");
		System.out.println("The user receives the message:Password is required.");
		
		
		driver3.quit();
		
		/*TEST CASE N.4
		Register new user with empty LastName field
		 */
	
System.setProperty("webdriver.chrome.driver", "C:\\Chorme driver\\chromedriver.exe");
		
		WebDriver driver4 = new ChromeDriver();
		//  Navigate to the URL  //
		driver4.get("https://demo.nopcommerce.com");
		
		//  Test steps  //
		driver4.findElement(By.className("ico-register")).click();
		driver4.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver4.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("robot");
		driver4.findElement(By.xpath("//input[@name='Email']")).sendKeys("validpass");
		driver4.findElement(By.name("Company")).sendKeys("Interworks");
		driver4.findElement(By.name("Password")).sendKeys("auttesting");
		driver4.findElement(By.xpath("//input[@type='password' and @id='ConfirmPassword']")).sendKeys("auttesting");
		driver4.findElement(By.xpath("//button[@id='register-button']")).click();
		
		
		
		String actualurl2 = driver4.getCurrentUrl();
		String ecpectedurl2 = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		Assert.assertEquals(ecpectedurl2, actualurl2);
		
		System.out.println(actualurl2);
		
		System.out.println("User is prevented to loggin in and receives a message:Last name is required.");
		
		
	
		
		driver4.quit();
		
		
		
		
		
			
		
		
	}
}
