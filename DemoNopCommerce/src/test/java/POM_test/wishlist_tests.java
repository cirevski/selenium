package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.wishlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class wishlist_tests extends Base {
	wishlist wl;
	
  @Test
  public void tc_01() {
	  wl.CheckAddProductsToCartFromWishlistPageFunctionalityIsWorkingCorrectly();
	  wl.VerifyTheProductSuccesfullyAddedTo_add_to_cart_page();
  }
  @Test
  public void tc_02() {
	  wl.TryToAddToWishListNikeFloralWithChoosingSizeColorPrint();
	  wl.VerifyThatNikeFloralisAddedToWishList();
  }
  @Test
  public void tc_03() {
	  wl.TryToAddToWishListNikeFloralWithoutChoosingSizeColorPrint();
	  wl.VerifyThatUserCannotAddToWishListNikeFloralWithoutChoosingSizeColorPrint();
  }
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  wl = new wishlist();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
