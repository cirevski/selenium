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

public class search_steps {
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		
		
	}
	@Given("User is on home page")
	public void user_is_on_home_page() {
	    
		driver.get("https://www.saucedemo.com");
	}

	@When("^user enters (.*)")
	public void user_enters_Nike(String products) {
	    
	    driver.findElement(By.id("small-searchterms")).sendKeys(products);
	}

	@And ("click search button")
	public void click_search_button() {
	    
	    driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	}

	@Then("is displayed search results")
	public void is_displayed_search_results() {
	    
	    System.out.println("Search results is displayed");
	}

	
	
	@After
	public void close() {
		driver.quit();
	}

}
/*	Ова ме бунеше во конзола ми даваше да ги вметнам по овој редолсед
	@Given("User is on home page")
	public void user_is_on_home_page() {
	    
		driver.get("https://www.saucedemo.com");
	}

	@When("user enters Nike")
	public void user_enters_Nike() {
	    
	    driver.findElement(By.id("small-searchterms")).sendKeys("Nike");
	}

	@When("click search button")
	public void click_search_button() {
	    
	    driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	}

	@Then("is displayed search results")
	public void is_displayed_search_results() {
	    
	    System.out.println("Search results is displayed");
	}

	@When("user enters Asus")
	public void user_enters_Asus() {
	   
		driver.findElement(By.id("small-searchterms")).sendKeys("Asus");
	}

	@When("user enters Sony")
	public void user_enters_Sony() {
	    
		driver.findElement(By.id("small-searchterms")).sendKeys("Sony");
	}

	@When("user enters erikson")
	public void user_enters_erikson() {
	    
		driver.findElement(By.id("small-searchterms")).sendKeys("erikson"); */
