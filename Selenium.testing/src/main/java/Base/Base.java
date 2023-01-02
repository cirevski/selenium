package Base;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	public static WebDriver driver;	
	public String home_url= "https://demo.nopcommerce.com";
	
	public void OpenNopcommerce() {
	
		driver = WebDriverManager.chromedriver().create();
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(home_url);
	}
	
	public void mouseAct(WebElement element) {
		Actions a = new Actions (driver);
		a.moveToElement(element).click().perform(); 
		
	}
	public void wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void scrollToElementAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
	}
	
	
	public void print(WebElement element) {
		System.out.println(element);
	}
	
	public void printText(String text) {
		System.out.println(text);
	}

}