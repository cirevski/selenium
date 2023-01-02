package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.register;
import test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class register_tests extends Base {
	
	test_data td;
	register reg;
	
  @Test
  public void TC_01() {
	  
	  reg.RegisterWithValidCredentials(td.FirstNameva, td.LastNameva, td.emailva, td.passva, td.confpassva);
	  reg.VeryfyThatUserIsRegistered();
  }
  
  @Test
  public void TC_02() {
	  reg.RegisterWithInvalidEmail(td.FirstNameva, td.LastNameva, td.emailin, td.passva, td.confpassva);
	  reg.VeryfyThatUserCannotRegisterWithInvalidEmail();
	  
  }
  
  @Test
  public void TC_03() {
	  reg.RegisterWithInvalidPassAndConfirmpass(td.FirstNameva, td.LastNameva, td.emailva, td.company, td.passin, td.passin);
	  reg.VeryfiThatUserCannotRegisterWithInvalidPassword();
	  
  }
  
  @Test
  public void TC_o4() {
	  reg.DateOfBirthAndGenderFunctionsWorksCorrectly(td.FirstNameva, td.LastNameva, td.email2, td.passva, td.confpassva);
	  reg.VeryfyThatUserIsRegistered();
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  td = new test_data();
	  reg = new register();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
