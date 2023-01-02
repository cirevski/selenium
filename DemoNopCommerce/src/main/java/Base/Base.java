package Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public String home_url = "https://demo.nopcommerce.com/";
	
	public void OpenNopCommerce() {
		
		driver = WebDriverManager.chromedriver().create();
		driver = new ChromeDriver();
		driver.get(home_url);
		driver.manage().window().maximize();
		
	}
	public void MouseActAndClick(WebElement element) {
		Actions b = new Actions(driver);
		b.moveToElement(element).click().perform();
	}
	public void Wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void PrintElement(WebElement element) {
		System.out.println(element);
	}
	public void PrintText(String text) {
		System.out.println(text);
	}
	public void ScrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
		
	}
	public void ScrollToElementAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
		element.click();
	}
	public void SelectDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public void FindAlertAndClick() {
		Alert e = driver.switchTo().alert();
		e.accept();
		
		
	}
	
	
	

}
