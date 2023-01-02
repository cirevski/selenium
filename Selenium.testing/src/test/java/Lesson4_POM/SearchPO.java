package Lesson4_POM;

import org.testng.annotations.Test;

import Base.Base;
import Objects_Repository.Search;
import Test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class SearchPO extends Base {
	
	test_data td;
	Search se;
	
  @Test
  public void SeachForExistingProduct() {
	  
	  
	  se.SearchForExistingProduct(td.valid_search);
	  se.VerifyThatNikeProductsisDisplayed();
  } 
  @Test
  public void SearchForNonExistingProducts() {
	  
	  
	  se.SearchForNonexistingProduct(td.invalid_search);
	  se.VerifyThatProductisNotAvailable();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopcommerce();
	 
	  se = new Search();
	  td = new test_data();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}