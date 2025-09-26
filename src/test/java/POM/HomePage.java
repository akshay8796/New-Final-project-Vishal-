package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass
{

	@FindBy(xpath = "//span[text()='My Account']") WebElement Myaccount;
	@FindBy(xpath = "//a[text()='Login']") WebElement login;
	
	public HomePage(WebDriver driver) 
	{
	  super(driver);
	}
	
	public void ClickonMyaccount()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Account']")));
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Myaccount);
			wait.until(ExpectedConditions.elementToBeClickable(Myaccount));

			// Debug logs
			System.out.println("Displayed: " + Myaccount.isDisplayed());
			System.out.println("Enabled: " + Myaccount.isEnabled());

			// Use JS click instead of normal click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Myaccount);

		} catch (Exception e) {
			System.out.println("MyAccount click failed: " + e.getMessage());
		}
	}
	public void ClickonLogin()
	{
		login.click();
	}
}
