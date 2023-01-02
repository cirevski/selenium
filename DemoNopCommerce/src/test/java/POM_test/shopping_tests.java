package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.shopping;
import test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class shopping_tests extends Base {
	
	shopping shop;
	test_data td;
	
  @Test
  public void tc_01() {
	  shop.RemoveProductFromCardWithRemoveCheckbox();
	  shop.VerifyThatRemoveCheckboxWorksAndShoppingcartIsEmpty();
  }
  @Test
  public void tc_02() {
	  shop.WhenUserIncreasesQuantityofProductIsIncreasingPriceAlso(td.product_quantity);
	  shop.VerifyThatPriceIsIncreaseWhenUserInceaseQuantity();
  }
  @Test
  public void tc_03() {
	  shop.ContinueShoppingButtonWorksCorrectly();
	  shop.VerifyThatContinueShoppingButtonWorksCorrectlyAndNavigateUserToPreviousPage();
  }
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  shop = new shopping();
	  td = new test_data();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
