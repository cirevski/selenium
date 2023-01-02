package Lesson4_POM;

import org.testng.annotations.Test;

import Base.Base;
import Objects_Repository.PDP;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class PDP_PO extends Base{
	
	PDP pdp;

	
  @Test
  public void Open_Product_Details_for_a_Product() {
	  
	  pdp.Open_Product_Details_for_a_Product();
	  pdp.VeryfyThatAsusPLPisDisplayed();
  }  
  @Test
  public void Write_and_submit_review_for_product_without_login_in() {
	 
	  pdp.Write_and_submit_review_for_product_without_login_in();
	  pdp.VerifyThatUserCannotWriteReviewWithoutLoginIn();
  }
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopcommerce();
	 
	  pdp = new PDP();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
