package Lesson4_POM;

import org.testng.annotations.Test;

import Base.Base;
import Objects_Repository.login;
import Test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginPO extends Base {
	
	
	login lg;
	test_data td;
	
  @Test
  public void enterValidEmailandPass() {
	 
	  lg.enterValidEmailandPass(td.valid_logemail, td.valid_logpassword);
	  lg.VerifyThatUserIsLogin();
	   
  }
  
  @Test
  public void enterValidEmailandInvalidPass() {
	 
	  lg.enterValidEmailandInvalidPass(td.valid_logemail,td.invalid_logpassword );
	  lg.VerifyThatUserisnotLogin();}
  
  
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopcommerce();
	  
	  lg = new login();
	  td = new test_data();
  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
