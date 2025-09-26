package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BaseClass {

	@FindBy(xpath = "//input[@id='input-email']") WebElement Email;
	@FindBy(xpath = "//input[@type='password']")WebElement password;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginbutton;
	
	public Loginpage(WebDriver driver) {
		super(driver);
		
	}
	
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	public void setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void ClickOnLoginButton()
	{
		loginbutton.click();
	}
}
