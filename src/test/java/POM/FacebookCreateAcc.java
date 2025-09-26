package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookCreateAcc extends BaseClass {

	@FindBy(xpath = "//input[@name='firstname']") WebElement first;
	@FindBy(xpath = "//input[@name='lastname']") WebElement last;
	
	public FacebookCreateAcc(WebDriver driver) 
	{
		super(driver);
	}
	
	public void setfirstname(String ft)
	{
		first.sendKeys(ft);
	}
	public void setLastname(String lt)
	{
		last.sendKeys(lt);
	}
	public String getlabelFname()
	{
		return first.getDomProperty("value");
	}
	public String getlabelLastname()
	{
		return last.getDomProperty("value");
	}


}
