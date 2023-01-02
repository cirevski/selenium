package step.definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class register_steps {
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://demo.nopcommerce.com");
		
	}
	@Given("user is on register page")
	public void user_is_on_register_page() {
		
	    driver.findElement(By.xpath("//a[@class='ico-register']")).click();
	}
	@When("user enters valid firstname, lastname, email, password and confirm password")
	public void user_enters_valid_credentials() {
	
		driver.findElement(By.id("FirstName")).sendKeys("robot");
		driver.findElement(By.id("LastName")).sendKeys("robovski");
		driver.findElement(By.id("Email")).sendKeys("robot@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("lozinka");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("lozinka");
	}
	@And("clcik on register button")
	public void clcik_on_register_button() {
	   
	    driver.findElement(By.id("register-button")).click();
	}

	@Then("he is registered successfuly on the page")
	public void he_is_registered_successfuly_on_the_page() {
	    
	    String register_successful = driver.findElement(By.id("//div[@class='result']")).getText();
	    System.out.println(register_successful);
	}
	@When("user enters invalid firstname, lastname, email, password and confirm password")
	public void user_enters_invalid_credentials() {
		driver.findElement(By.id("FirstName")).sendKeys("robot");
		driver.findElement(By.id("LastName")).sendKeys("robovski");
		driver.findElement(By.id("Email")).sendKeys("robot.com");
		driver.findElement(By.id("Password")).sendKeys("lo");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("lo");
	}

	@And("click on register button")
	public void click_on_register_button() {
	    
	    driver.findElement(By.id("register-button")).click();
	}

	@Then("he receive a error message")
	public void he_receive_a_error_message() {
	    
	    String error_mess = driver.findElement(By.id("ConfirmPassword-error")).getText();
	    System.out.println(error_mess);
	}


}
