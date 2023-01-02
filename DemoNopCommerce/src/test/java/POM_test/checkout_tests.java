package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.checkout;
import POM.login;
import POM.register;
import test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class checkout_tests extends Base {
	test_data td;
	register reg;
	login log;
	checkout ct;

  @Test
  public void tc_01() {
	  ct.When_the_user_is_not_registered_on_the_page_for_the_Checkout_functionality_he_have_option_to_continue_like_a_guest();
	  ct.Verify_that_user_is_redirected_to_another_page_and_should_be_able_to_continue_with_step_forward_with_Checkout_functionality_after_choose_CHECKOUT_AS_GUEST();
	  
  }
	
  @Test
  public void tc_02() {
	  ct.When_user_is_registered_on_the_page_Checkout_function_Billing_address_contains_users_personal_data();
	  ct.The_user_should_be_redirected_to_Billing_address_page_and_billing_address_should_contains_users_personal_data_as_first_name_last_name_and_email();
  }
  @Test
  public void tc_03() {
	  ct.When_user_left_empty_Payment_information_he_cannot_go_to_next_step(td.City, td.Address, td.Zip, td.number);
	  ct.The_user_should_be_enable_to_go_step_forward_and_he_receive_a_message_Enter_cardholder_name();
  }
  @Test
  public void tc_04() {
	  ct.user_with_inputing_valid_credentials_for_all_requered_fiels_can_successfully_make_a_order();
	  ct.Verify_that_user_successfully_ordreder_his_product();
  }

 

  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  td = new test_data();
	  reg = new register();
	  log = new login();
	  ct = new checkout();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
