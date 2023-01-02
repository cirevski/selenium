package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.PDP;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class PDP_tests extends Base {
	PDP pdp;
	
  @Test
  public void TC_01() {
	  pdp.AddReviewforLeicaWithoutLoginOnThePage();
	  pdp.VerifyThatUserCannotWriteReviewWitoutRegistration();
  }
  @Test
  public void TC_02() {
	  pdp.OpenJewelryAndAddToCartProduct();
	  pdp.VerifyThatProductFromJewwlryIsOnCard();
  }
  @Test
  public void TC_o3() {
	  pdp.OpenPDPForAppleCamera();
	  pdp.VerifyThatPDPForAppleCameraIsDispayed();
  }
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  pdp = new PDP();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
