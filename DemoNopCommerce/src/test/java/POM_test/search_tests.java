package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.search;
import test_data.test_data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class search_tests extends Base {
	search sr;
	test_data td;
  @Test
  public void tc_01() {
	  sr.MakeSureAdvancedSearchIsWorkingProperly(td.existing_product);
	  sr.VerifyThatAdvancedSearchWorking();
  }
  @Test
  public void tc_02() {
	  sr.SearchForExistingProduct(td.existing_product);
	  sr.VerifyThatExistingProductIsDispayed();
  }
  @Test
  public void tc_03() {
	  sr.SearchForNonexistingProduct(td.nonexisting_product);
	  sr.VerifyThatUserReceivedAMessageToSearchingForANonexistentProduct();
  }
  @Test
  public void tc_04() {
	  sr.SearchProductsUsingOneCharacter(td.letter);
	  sr.VerifyThatSearchFunctionHaveCharactersLimit();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  sr = new search();
	  td = new test_data();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
