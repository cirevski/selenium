package Objects_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Test_data.test_data;



public class Register extends Base{
		

	test_data td = new test_data();
	
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement first_namefield;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement last_namefield;		
	
	@FindBy(id = "Email")
	WebElement email_field;
	
	@FindBy(xpath="//input[@name='Company']")
	WebElement input_company;
	
	@FindBy(id = "Password")
	WebElement password_field;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirm_passwordField;		
	
	@FindBy(xpath = "//div[@class='buttons']/button")
	WebElement REGISTER;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	WebElement error_mess; 
    
	@FindBy(xpath = "//input[@id='FirstName']")
    WebElement registerissuccessful;

	public Register() {
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterNewUser(String first_na, String last_na, String email, String password,String confirmpass) {
		
		first_namefield.sendKeys(first_na);
		last_namefield.sendKeys(last_na);
		email_field.sendKeys(email); 
		password_field.sendKeys(password);
		confirm_passwordField.sendKeys(confirmpass);
		REGISTER.click();
	}
	public void RegisterwithInvalidConfirmpass(String first_name, String last_name, String email,String company, String password,String confirmpass) {
		
		first_namefield.sendKeys(first_name);
		last_namefield.sendKeys(last_name);
		email_field.sendKeys(email);
		input_company.sendKeys(company);
		password_field.sendKeys(password);
		confirm_passwordField.sendKeys(confirmpass);
		REGISTER.click();	
	}
	
	public void verifyRegisterisSuccessful() {
		
		Assert.assertEquals(driver.getTitle(), td.homePageTitle);
		System.out.println("Your registration completed");
		
	}
	public void verifyRegisterisUnsuccessful() {
		Assert.assertEquals(driver.getTitle(), td.homePageTitle);
		System.out.println("The password and confirmation password do not match.");
	}
	
}

