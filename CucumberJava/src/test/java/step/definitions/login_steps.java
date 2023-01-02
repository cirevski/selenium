package step.definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;


public class login_steps {

	WebDriver driver;
	
	@Before
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		
	}

	
	@Given("user is on home page")
	public void user_is_on_home_page() {
	     driver.get("https://www.saucedemo.com");
	}    
	@When("^user enters (.*) and (.*)")
	public void user_enters_username_and_password(String username, String password) {
	     driver.findElement(By.id("user-name")).sendKeys(username);
	     driver.findElement(By.id("password")).sendKeys(password);
	}   
    @And("user click on login button")
	public void user_click_on_login_button() {
	     driver.findElement(By.id("login-button")).click();
    }

    @Then("user is navigate on a inventory page")
	public void user_is_navigate_on_a_inventory_page() {
	     String expected = "https://www.saucedemo.com/inventory.html";
	     Assert.assertEquals(expected, driver.getCurrentUrl());
	}  
    
    @After
    public void close() {
    	driver.quit();
    
    }

}
