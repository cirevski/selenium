package Lesson2.Selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest2 {
  @Test
  public void Test1() {
	  System.out.println("This is test 1");
  }
  @Test
  public void Test2() {
	  System.out.println("This is test 2");
	  
  }
  @Test
  public void Test3() {
	  System.out.println("This is test 3");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is executed before Test");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is executed after each test");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is executed before each class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.print("This is ececuted after each class");
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
