package Lesson2.Selenium.testing;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.junit.Assert;


public class Login {
	
	public static void main(String [] args) throws InterruptedException {
		
		/*TC.01
		Enter 
		Valid Email and
		invalid Password*/
		
		//Open Edge browser//
		System.setProperty("webdriver.edge.driver", "C:\\Edge driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		Thread.sleep(5000);
		//  Navigate to the URL  //
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		// Test Steps //
		
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("robot@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("int112233");
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		
		String act_url=driver.getCurrentUrl();
		System.out.println(act_url);
		
		String expected_url="https://demo.nopcommerce.com/login?returnurl=%2F";
				if (act_url.equals(expected_url))
					{System.out.println("PASS");}
				else {
					System.out.println("FAIL");
				}
		
		System.out.println("The user receives the message:Login was unsuccessful. Please correct the errors and try again.");
		
		driver.quit();
		
		/* TC.02 
		   Enter 
           Valid Email and
           Empty Password
		 */
				
		//Open Edge browser//
	
		System.setProperty("webdriver.edge.driver", "C:\\Edge driver\\msedgedriver.exe");
		WebDriver driver1 = new EdgeDriver();
		
	    //  Navigate to the URL  //
			driver1.manage().window().maximize();
			driver1.get("https://demo.nopcommerce.com/");
			
		// Test Steps //	
		
		driver1.findElement(By.xpath("//a[@class='ico-login']")).click();	
		driver1.findElement(By.xpath("//input[@id='Email']")).sendKeys("robot@gmail.com");
		driver1.findElement(By.xpath("//input[@id='Password']")).click();
		driver1.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		
		String act_url1 = driver1.getCurrentUrl();
		String desired_url1 = "https://demo.nopcommerce.com/login?returnurl=%2F";
		Assert.assertEquals(desired_url1, act_url1);
		
		System.out.println(act_url1);
		
		
		System.out.println("The user cannot login on the page and receives a message:Login was unsuccessful. Please correct the errors and try again.");
		
		driver1.quit();
		
		/*TC.03
		 Enter 
         Empty Email and
         Valid Password
		 */
		
		//Open Edge browser//
				System.setProperty("webdriver.edge.driver", "C:\\Edge driver\\msedgedriver.exe");
				WebDriver driver2 = new EdgeDriver();
				
		
		//  Navigate to the URL  //
				driver2.manage().window().maximize();
				driver2.get("https://demo.nopcommerce.com/");	
				
				
		// Test Steps //
				
		
		driver2.findElement(By.className("ico-login")).click();	
		driver2.findElement(By.id("Email")).click();
		driver2.findElement(By.id("Password")).sendKeys("int123456");
		driver2.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		
		String actualurl2 = driver2.getCurrentUrl();
		String expectedurl2 = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		Assert.assertEquals(actualurl2,expectedurl2);
		
		System.out.println(expectedurl2);
		
		/*
		 
		 String actualurl2 = driver2.getCurrentUrl();
		System.out.println(actualurl2);
		String expectedurl2 = "https://demo.nopcommerce.com/login?returnurl=%2F";
			if (actualurl2.equals(expectedurl2))
			{
				System.out.println("PASS");
			}
			else {
				System.out.println("FAIL");
			}
		*/
		
		
		System.out.println("The user cannot login on the page and receives a message: Please enter your email");
		
		driver2.quit();
				
				
				
				
				
	

	

	
	

	
	
	}
}
