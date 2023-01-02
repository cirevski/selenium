package Lesson4_POM;

import org.testng.annotations.Test;

import Base.Base;
import Objects_Repository.Register;
import Objects_Repository.RegisterHomePage;
import Test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class RegisterPO extends Base {
	
	RegisterHomePage rhp;
	test_data td;
	Register re;
	
  
  @BeforeMethod
  public void Start() {
	  OpenNopcommerce();
	  rhp = new RegisterHomePage();
	  re = new Register();
	  td = new test_data();
	  
	  
  }

  @Test
  public void RegisterWithVAlidCredentials() {
	  rhp.OpenNopcommerce();
	  rhp.navigateToLoginPage();
	  re.RegisterNewUser(td.valid_first_name, td.valid_last_name, td.valid_email, td.valid_password, td.valid_confirmpass);
	  re.verifyRegisterisSuccessful();
  }
  
  @Test
  public void RegisterWithDifferentConfirmpass() {
	  rhp.OpenNopcommerce();
	  rhp.navigateToLoginPage();
	  re.RegisterwithInvalidConfirmpass(td.valid_first_name, td.valid_last_name, td.valid_email, td.company, td.valid_password, td.invalid_confirmpass);
	  re.verifyRegisterisUnsuccessful();
  }
  
  
  @AfterMethod
  public void End() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
	  driver.quit();
  }

}
