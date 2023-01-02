package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	
	WebDriver driver = null;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void testTeardown() {
		driver.quit();
	}
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		driver.get("https://www.saucedemo.com/");
	    
	}

	@When("^user enters (.*) and (.*)")
	public void user_enters_valid_username_and_password(String username, String password) {
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
	    
	}

	@And("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	@Then("login should be successful")
	public void login_should_be_successful() {
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
	   
	}
	
	@Then("login should be unsuccessful")
	public void login_should_be_unsuccessful() {
		Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
	}
	



}
