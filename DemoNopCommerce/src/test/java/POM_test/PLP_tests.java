package POM_test;

import org.testng.annotations.Test;

import Base.Base;
import POM.PLP;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class PLP_tests extends Base {
	
	PLP plp;
  @Test
  public void tc_01() {
	  plp.CheckAreFilterWorksCorrectlyForNotebooks();
	  plp.VerifyThatFiltersForRAMAndCPUWorkingCorrectly();
  }
  
  @Test
  public void tc_02() {
	  plp.OpenPLPForBooks();
	  plp.VerifyThatBooksProductsisDisplayed();
  }
  
  @Test
  public void tc_03() {
	  plp.OpenPLPForNotebooks();
	  plp.VerifyThatPLPForNotebooksIsDispayed();
  }
  
  @Test
  public void tc_04() {
	  plp.OpenPLPForNotebooksAndSortInListViewmode();
	  plp.VerifyThatNotebooksProductsIsDispayedInList();
  }
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopCommerce();
	  plp = new PLP();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
