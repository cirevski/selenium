package Lesson4_POM;

import org.testng.annotations.Test;

import Base.Base;
import Objects_Repository.Wishlist;
import Test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class WishlistPO extends Base {
	test_data td = new test_data(); 
	
	Wishlist wl;
	
	
  @Test
  public void AddToCard() {
	  
	  wl.Check_Add_products_to_Cart_from_wishlist_page_functionality_is_working_correctly();
	  wl.VerifyThe_product_succesfully_added_to_add_to_cart_page();
  }
  
  @Test
  public void  Quantity_Grow() {
	  
	  wl.Check_if_the_total_price_is_calculated_correctly(td.quantity_num);
	  wl.VerifyThatPriceGrowsFiveTimes();
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopcommerce();
	 
	  wl = new Wishlist();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
