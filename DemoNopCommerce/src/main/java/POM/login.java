package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import test_data.test_data;

public class login extends Base {
	
	test_data td;
	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginPage;
	
	@FindBy(id="Email")
	WebElement emailfield;
	
	@FindBy(id="Password")
	WebElement passfield;
	
	@FindBy(id="RememberMe")
	WebElement rememberMe;
	
	@FindBy(xpath="//a[@href='/passwordrecovery']")
	WebElement ForgotPassLink;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement loginButton;
	
	@FindBy(id="Email-error")
	WebElement errorEmail;
	
	public login() {
		PageFactory.initElements(driver, this);
	}
	
	public void LoginWithValidCredentials(String email, String password) {
		loginPage.click();
		emailfield.sendKeys(email);
		passfield.sendKeys(password);
		loginButton.click();
	}
	public void VerifyThatUserIsLoggedIn() {
		String desired_url = "https://demo.nopcommerce.com/";
		Assert.assertEquals(driver.getCurrentUrl(), desired_url);
		PrintText("User is successfully logged In");
	}
	public void CheckIfTheForgotenPasswordLiknWorks(String email) {
		loginPage.click();
		emailfield.sendKeys(email);
		ForgotPassLink.click();
	}
	public void VerifyThatForgotenPasswordLinkWorking() {
		String desired = "https://demo.nopcommerce.com/passwordrecovery";
		Assert.assertEquals(driver.getCurrentUrl(), desired);
	}
	public void LoginWithInvalidCredentials(String email, String password) {
		loginPage.click();
		emailfield.sendKeys(email);
		passfield.sendKeys(password);
		loginButton.click();
	}
	public void VerifyThatUserCannotLoginOnThePageAndRecieveAMessage() {
		
		errorEmail.isDisplayed();
		errorEmail.getText();
		PrintElement(errorEmail);
		
	}

}
