package Objects_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Test_data.test_data;

public class PDP extends Base{
	
	
	test_data td = new test_data();
    
		
    
    @FindBy(xpath="(//a[@href='/notebooks'])[1]")
    WebElement category_notebook;
	
	@FindBy(xpath="//img[@alt='Picture of Asus N551JK-XO076H Laptop']")
	WebElement asus;
	
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")
	WebElement cam_photo_sub;
	
	@FindBy(xpath=("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a"))
	WebElement leica;
	
	@FindBy(xpath="//a[contains(text(),'Add your review')]")
	WebElement rewiew;
	
	@FindBy(linkText = "Computers")
    WebElement category_com;
	
	@FindBy(linkText=("Electronics"))
	WebElement ele_category;
	
	public PDP() {
		PageFactory.initElements(driver, this);
	}
 
	public void Open_Product_Details_for_a_Product() {
		
		category_com.click();
		mouseAct(category_notebook);
		wait(asus);
		scrollToElementAndClick(asus);
		
	}
	public void VeryfyThatAsusPLPisDisplayed() {
		 String desired_url = "https://demo.nopcommerce.com/asus-n551jk-xo076h-laptop";   
		  System.out.println(desired_url);
		  Assert.assertEquals(driver.getCurrentUrl(), desired_url);
		  System.out.println("Product details page is displayed for Asus N551JK-XO076H Laptop");
	}
	public void Write_and_submit_review_for_product_without_login_in() {
		ele_category.click();
		cam_photo_sub.click();
		scrollToElement(leica);
		mouseAct(leica);
		rewiew.click();
	}
	public void VerifyThatUserCannotWriteReviewWithoutLoginIn() {
		String desired_mess = "Only registered users can write reviews";
		 String error_mess = driver.findElement(By.xpath("//li[contains(text(),'Only registered users can write reviews')]")).getText();
		 Assert.assertEquals(error_mess, desired_mess);
		 System.out.println(error_mess);
	}

}