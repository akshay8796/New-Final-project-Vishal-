package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.HomePageAccount;
import POM.Loginpage;
import Utilities.ExcelUtility;

public class Test001PageTitle extends BaseClassTest {

	  @Test(groups = {"Sanity", "Regression"})
public void TestPageTitle() throws IOException
{
	HomePage   home=new  HomePage(driver);
    home.ClickonMyaccount();

    home.ClickonLogin();
    ExcelUtility excel=new ExcelUtility("D:\\Akshay Dhanedhar\\eclips workspace\\FullFinalProject\\testData\\Openkart_LoginData.xlsx"); 
    Loginpage loginninja=new Loginpage(driver);
	loginninja.setEmail(excel.getCellData("Sheet1", 1, 0));
	loginninja.setpassword(excel.getCellData("Sheet1", 1, 1));
	loginninja.ClickOnLoginButton();
	HomePageAccount acc=new HomePageAccount(driver);
	
	  String actualTitle = driver.getTitle();
	    String expectedTitle = "My Account";

	    System.out.println("Actual Title: " + actualTitle);
	    System.out.println("Expected Title: " + expectedTitle);

	    Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

	    acc.ClickOnlogout();
}
	
}
