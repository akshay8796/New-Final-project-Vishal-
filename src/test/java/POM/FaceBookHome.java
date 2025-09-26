package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaceBookHome extends BaseClass {

	@FindBy(xpath = "//a[text()='Create new account']") WebElement Myaccount;
	
	
	public FaceBookHome(WebDriver driver) 
	{
	  super(driver);
	}
	
	public void ClickOnCreateAcc()
	{
		Myaccount.click();
	}

}
