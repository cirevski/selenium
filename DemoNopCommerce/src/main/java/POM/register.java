package POM;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import test_data.test_data;

public class register extends Base {
	
	test_data td = new test_data();
	
	@FindBy(xpath="//a[@class='ico-register']")
	WebElement RegisterPage;

	@FindBy(id="FirstName")
	WebElement FirstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(id="gender-male")
	WebElement GenderMale;
	
	@FindBy(id="gender-female")
	WebElement GenderFemale;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Company")
	WebElement company;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement DayofBirth;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement MonthofBirth;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement YearofBirth;
	
	@FindBy(id="Password")
	WebElement pass;
	
	@FindBy(id="ConfirmPassword")
	WebElement confpass;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement messageRegSucc;
	
	@FindBy(id="Email-error")
	WebElement errorEmail;
	
	@FindBy(id="Password-error")
	WebElement errorpass;
	
	public register() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void RegisterWithValidCredentials(String Firstname, String Lastname, String Email, String password, String ConfirmPass) {
		RegisterPage.click();
		FirstName.sendKeys(Firstname);
		LastName.sendKeys(Lastname);
		email.sendKeys(Email);
		pass.sendKeys(password);
		confpass.sendKeys(ConfirmPass);
		registerButton.click();
		
	}
	public void VeryfyThatUserIsRegistered () {
		String desired = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, desired);	
	}
	public void VeryfyThatUserCannotRegisterWithInvalidEmail() {
		errorEmail.isDisplayed();
		driver.getCurrentUrl().contains("Wrong email");
		
	}
	public void VeryfiThatUserCannotRegisterWithInvalidPassword() {
		errorpass.isDisplayed();
		driver.getCurrentUrl().contains("Password must meet the following rules:\r\n"
				+ "\r\n"
				+ "must have at least 6 characters");
	}
	public void RegisterWithInvalidEmail (String firstname, String lastname, String Email, String password, String confirmpass) {
		RegisterPage.click();
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		email.sendKeys(Email);
		pass.sendKeys(password);
		confpass.sendKeys(confirmpass);
		registerButton.click();
	}
	public void DateOfBirthAndGenderFunctionsWorksCorrectly (String firstname, String lastname, String Email, String password, String confirmpass) {
		RegisterPage.click();
		GenderMale.click();
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		SelectDropdown(DayofBirth, "5");
		SelectDropdown(MonthofBirth, "4");
		SelectDropdown(YearofBirth, "1997");
		email.sendKeys(Email);
		pass.sendKeys(password);
		confpass.sendKeys(confirmpass);
		registerButton.click();
		
		
	}
	public void RegisterWithInvalidPassAndConfirmpass (String firstname, String lastname, String Email, String Company, String password, String confirmpass) {
		RegisterPage.click();
		GenderFemale.click();
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		email.sendKeys(Email);
		company.sendKeys(Company);
		pass.sendKeys(password);
		confpass.sendKeys(confirmpass);
		registerButton.click();
		
	}
}
