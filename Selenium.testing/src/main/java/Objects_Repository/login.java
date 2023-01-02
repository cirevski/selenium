package Objects_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Test_data.test_data;

public class login extends Base {
	
	test_data td = new test_data();
	
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginTopMenuLink;
	
	@FindBy(id="Email")
	WebElement inp_email;
	
	@FindBy(id="Password")
	WebElement inp_password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement click_login;
	
	public login() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterValidEmailandPass(String email, String password) {
		loginTopMenuLink.click();
		inp_email.sendKeys(email);
		inp_password.sendKeys(password);
		click_login.click();
	}
	public void enterValidEmailandInvalidPass (String email, String password)	{
		loginTopMenuLink.click();
		inp_email.sendKeys(email);
		inp_password.sendKeys(password);
		click_login.click();
	}
	public void VerifyThatUserIsLogin() {
		
		Assert.assertEquals(driver.getTitle(), td.homePageTitle);
		System.out.println("User is login on the page");
		
	}
	
	public void VerifyThatUserisnotLogin() {	
		String act_url=driver.getCurrentUrl();
		System.out.println(act_url);
		String expected_url="https://demo.nopcommerce.com/login?returnurl=%2F";
		if (act_url.equals(expected_url))
			{System.out.println("PASS");}
		else {
			System.out.println("FAIL");
		}

System.out.println("The user receives the message:Login was unsuccessful. Please correct the errors and try again.");
		
	}
	
	
	

}
