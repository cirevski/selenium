package Lesson4_POM;

import org.testng.annotations.Test;

import Base.Base;
import Objects_Repository.ShoppingCart;
import Test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ShoppngCartPO extends Base {
	
	test_data td;
	ShoppingCart sc;
	
	
  @Test
  public void TC_01() {
	  
	  sc.RemoveProductWithRemoveCheckbox();
	  sc.VerifyThatShoppingCartIsEmpty();
  }
  @Test
  public void TC_02() {
	  
	  sc.RemoveProductByEntering0Quantity(td.quantity_num2);
	  sc.VerifyThatShoppingCartIsEmpty();
  }
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopcommerce();
	   sc = new ShoppingCart();
	   
	   td = new test_data();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}


