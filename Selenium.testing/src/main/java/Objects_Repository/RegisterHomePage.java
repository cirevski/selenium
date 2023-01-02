package Objects_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class RegisterHomePage extends Base {

	
	
	    
	
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerTopMenuLink;
		
		
		
		public RegisterHomePage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		
		public void navigateToLoginPage() {
			registerTopMenuLink.click();
		}
		
		
}
