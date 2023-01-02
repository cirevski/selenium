package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import test_data.test_data;

public class checkout extends Base {
	
	register reg = new register();
	test_data td = new test_data();
	login log = new login();
	
	@FindBy(linkText="Jewelry")
    WebElement jewelry;
	
	@FindBy(xpath="//div[@class='details']/h2[@class='product-title']/a[contains(text(),'Flower Girl Bracelet')]")
	WebElement flower_bracelet;
	
	@FindBy(id="add-to-cart-button-41")
	WebElement AddToCartBracelet;
	
	@FindBy(xpath="//p[@class='content']/a[@href='/cart']")
	WebElement alert_card;
	
	@FindBy(id = "termsofservice")
	WebElement termsCheckbutt;
	
	@FindBy(id = "checkout")
	WebElement checkout_butt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zip;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement num;
	
	@FindBy(xpath = "//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']")
	WebElement billing_continueButt;
	
	@FindBy(id = "shippingoption_1")
	WebElement delivery;
	
	@FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
	WebElement shipping_button;
	
	@FindBy(id = "paymentmethod_1")
	WebElement credit_card;
	
	@FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
	WebElement payment_button;
	
	@FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
	WebElement payment_button2;
	
	@FindBy(xpath = "(//button[@class='button-1 new-address-next-step-button' and contains(text(),'Continue')])[1]")
	WebElement billing_sameaddressButton;
	
	@FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
	WebElement pay_info_button;
	
	@FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
	WebElement confirm_order;
	
	@FindBy(xpath = "//div[@class='buttons']/button[@class='button-1 checkout-as-guest-button']")
	WebElement CheckoutAsGuest;
	
	public checkout() {
		PageFactory.initElements(driver, this);
	}
	
	public void When_user_is_registered_on_the_page_Checkout_function_Billing_address_contains_users_personal_data() {
		reg.RegisterWithValidCredentials(td.FirstNameva, td.LastNameva, td.emailva, td.passva, td.confpassva);
		log.LoginWithValidCredentials(td.emailva, td.passva);
		jewelry.click();
		flower_bracelet.click();
		ScrollToElementAndClick(AddToCartBracelet);
		Wait(alert_card);
		MouseActAndClick(alert_card);
		ScrollToElementAndClick(termsCheckbutt);
		checkout_butt.click();
	}
	public void The_user_should_be_redirected_to_Billing_address_page_and_billing_address_should_contains_users_personal_data_as_first_name_last_name_and_email () {
		driver.getCurrentUrl().contains("robot");
		driver.getCurrentUrl().contains("robovski");
		driver.getCurrentUrl().contains("robot@gmail.com");
	}
	public void When_user_left_empty_Payment_information_he_cannot_go_to_next_step (String City, String Address, String PostalCode, String Phonenum) {
		
		reg.RegisterWithValidCredentials(td.FirstNameva, td.LastNameva, td.emailva, td.passva, td.confpassva);
		log.LoginWithValidCredentials(td.emailva, td.passva);
		jewelry.click();
		flower_bracelet.click();
		ScrollToElementAndClick(AddToCartBracelet);
		Wait(alert_card);
		MouseActAndClick(alert_card);
		ScrollToElementAndClick(termsCheckbutt);
		checkout_butt.click();
		Wait(country);
		JavascriptExecutor s = (JavascriptExecutor) driver;
		s.executeScript("window.scrollBy(0,700)");
		SelectDropdown(country, "157");
		city.sendKeys(City);
		address.sendKeys(Address);
		zip.sendKeys(PostalCode);
		num.sendKeys(Phonenum);
		billing_continueButt.click();
		Wait(delivery);
		delivery.click();
		MouseActAndClick(shipping_button);
		Wait(credit_card);
		credit_card.click();
		payment_button.click();
		Wait(payment_button2);
		payment_button2.click();
		
	}
	public void The_user_should_be_enable_to_go_step_forward_and_he_receive_a_message_Enter_cardholder_name (){
		
		driver.getCurrentUrl().contains("Enter cardholder name\r\n"
				+ "Wrong card number\r\n"
				+ "Wrong card code");
		payment_button2.click();
		String expected_url = "https://demo.nopcommerce.com/onepagecheckout#opc-payment_info";
		Assert.assertEquals(driver.getCurrentUrl(), expected_url);
		
	}
	public void user_with_inputing_valid_credentials_for_all_requered_fiels_can_successfully_make_a_order() {
		
		log.LoginWithValidCredentials(td.emailva, td.passva);
		jewelry.click();
		flower_bracelet.click();
		ScrollToElementAndClick(AddToCartBracelet);
		Wait(alert_card);
		MouseActAndClick(alert_card);
		ScrollToElementAndClick(termsCheckbutt);
		checkout_butt.click();
		billing_sameaddressButton.click();
		Wait(shipping_button);
		shipping_button.click();
		Wait(payment_button);
		payment_button.click();
		Wait(pay_info_button);
		pay_info_button.click();
		Wait(confirm_order);
		confirm_order.click();
		
		
		
	}
	public void Verify_that_user_successfully_ordreder_his_product() {

		driver.getCurrentUrl().contains("Your order has been successfully processed!");
		
	}
	public void When_the_user_is_not_registered_on_the_page_for_the_Checkout_functionality_he_have_option_to_continue_like_a_guest() {
		jewelry.click();
		flower_bracelet.click();
		ScrollToElementAndClick(AddToCartBracelet);
		Wait(alert_card);
		MouseActAndClick(alert_card);
		ScrollToElementAndClick(termsCheckbutt);
		checkout_butt.click();
		ScrollToElementAndClick(CheckoutAsGuest);
	}
	public void Verify_that_user_is_redirected_to_another_page_and_should_be_able_to_continue_with_step_forward_with_Checkout_functionality_after_choose_CHECKOUT_AS_GUEST () {
		String expected_url = "https://demo.nopcommerce.com/onepagecheckout#opc-billing";
		Assert.assertEquals(driver.getCurrentUrl(), expected_url);
	}
			

}
