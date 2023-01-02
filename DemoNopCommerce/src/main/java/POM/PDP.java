package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class PDP extends Base {
	
	@FindBy(linkText="Jewelry")
    WebElement jewelry;
	
	@FindBy(xpath="//div[@class='details']/h2[@class='product-title']/a[contains(text(),'Flower Girl Bracelet')]")
	WebElement flower_bracelet;
	
	@FindBy(id="add-to-cart-button-41")
	WebElement AddToCartBracelet;
	
	@FindBy(xpath="//p[@class='content']/a[@href='/cart']")
	WebElement alert_card;
	
	@FindBy(linkText="Electronics")
	WebElement electornics;
	
	@FindBy(xpath="//div[@class='sub-category-item']/h2[@class='title']/a[contains(text(),'Camera & photo')]")
	WebElement camera_photo;
	
	@FindBy(xpath="//div[@class='details']/h2[@class='product-title']/a[contains(text(),'Leica T Mirrorless Digital Camera')]")
	WebElement leica;
	
	@FindBy(xpath="//a[contains(text(),'Add your review')]")
	WebElement review_leica;
	
	@FindBy(xpath="//div[@class='details']/h2[@class='product-title']/a[contains(text(),'Apple iCam')]")
	WebElement apple_iCam;
	
	public PDP() {
		PageFactory.initElements(driver, this);
	}
	
	public void OpenJewelryAndAddToCartProduct() {
		jewelry.click();
		flower_bracelet.click();
		ScrollToElementAndClick(AddToCartBracelet);
		Wait(alert_card);
		MouseActAndClick(alert_card);
	}
	public void VerifyThatProductFromJewwlryIsOnCard() {
		String desired_url = "https://demo.nopcommerce.com/cart";
		Assert.assertEquals(driver.getCurrentUrl(), desired_url);
		driver.getCurrentUrl().contains("Flower Girl Bracelet");
	}
	public void OpenPDPForAppleCamera() {
		electornics.click();
		Wait(camera_photo);
		camera_photo.click();
		apple_iCam.click();
	}
	public void VerifyThatPDPForAppleCameraIsDispayed() {
		String PDP_Apple_cam_url = "https://demo.nopcommerce.com/apple-icam";
		Assert.assertEquals(driver.getCurrentUrl(), PDP_Apple_cam_url);
	}
	public void AddReviewforLeicaWithoutLoginOnThePage() {
		electornics.click();
		Wait(camera_photo);
		camera_photo.click();
		leica.click();
		review_leica.click();
		
	}
	public void VerifyThatUserCannotWriteReviewWitoutRegistration() {
		driver.getCurrentUrl().contains("Only registered users can write reviews");
		
	}
}
