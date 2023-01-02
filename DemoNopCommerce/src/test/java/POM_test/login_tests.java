package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.login;
import POM.register;
import test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class login_tests extends Base{
	
	register reg;
	test_data td;
	login log;
	
  @Test
  public void TC_01() {
	  reg.RegisterWithValidCredentials(td.FirstNameva, td.LastNameva, td.emailva, td.passva, td.confpassva);
	  log.LoginWithValidCredentials(td.emailva, td.passva);
	  log.VerifyThatUserIsLoggedIn();
  }
 
  @Test
  public void TC_02() {
	  log.LoginWithInvalidCredentials(td.emailin, td.passin);
	  log.VerifyThatUserCannotLoginOnThePageAndRecieveAMessage();
  }
 
  @Test
  public void TC_03() {
	  log.CheckIfTheForgotenPasswordLiknWorks(td.emailva);
	  log.VerifyThatForgotenPasswordLinkWorking();
  }
 
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  td = new test_data();
	  log = new login();
	  reg = new register();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
