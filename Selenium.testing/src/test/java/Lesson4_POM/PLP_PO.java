package Lesson4_POM;

import org.testng.annotations.Test;

import Base.Base;
import Objects_Repository.PLP;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class PLP_PO extends Base {
	
	PLP plp;
	
	
  @Test
  public void VerifyTheFilterOptionIsWorking() {
	  
	  
	  plp.VerifyTheFilterOptionIsWorking();
	  plp.VeryfyThatFiltersWorksCorrectly();
  }
  
  @Test
  public void Confirm_that_HP_Notebook_can_be_found_in_computers_category_and_notebooks_sub_category() {
	  
	 
	  plp.Confirm_that_HP_Notebook_can_be_found_in_computers_category_and_notebooks_sub_category();
	  plp.VerifyThatHP_EnvyPDPisDisplayed();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  OpenNopcommerce();
	  plp = new PLP();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
