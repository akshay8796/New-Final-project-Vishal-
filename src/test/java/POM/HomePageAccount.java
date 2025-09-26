package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAccount extends BaseClass {
	@FindBy(xpath = "//h2[text()='My Account']") WebElement Myaccount;
	@FindBy(xpath = "(//a[text()='Logout'])[2]") WebElement logout;
	@FindBy(xpath = "//div[@class='list-group']//a") List<WebElement> group;
	
	public HomePageAccount(WebDriver driver) {
		super(driver);
	}
	
	public Boolean DisplayMyAccount()
	{
		try {
			return (Myaccount.isDisplayed());
		}
		catch(Exception e){
			return false;
		}

	}
	
	public void ClickOnlogout()
	{
		logout.click();
	}
	
	public List<WebElement> groupcontainsElement()
	{
		            List<WebElement> list = group;
		           return list;
	}
	
	
}
