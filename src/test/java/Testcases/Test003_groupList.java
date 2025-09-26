package Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.HomePageAccount;
import POM.Loginpage;
import Utilities.ExcelUtility;

public class Test003_groupList  extends BaseClassTest
{

	  @Test(groups = {"Sanity", "Regression"})
public void test003_GrouListValidation() throws IOException
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
	       List<WebElement> list = acc.groupcontainsElement();
	       int expectedRowCount = excel.getRowCount("Sheet2");

	        // Sanity check: Ensure size match between expected and actual list
	        Assert.assertEquals(list.size(), expectedRowCount, "Mismatch in number of elements on UI and Excel data");

	        for (int i = 0; i < expectedRowCount; i++) {
	            String expectedText = excel.getCellData("Sheet2", i + 1, 0).trim();
	            String actualText = list.get(i).getText().trim();

	            Assert.assertEquals(actualText, expectedText, "Text mismatch at index " + i + ": Expected [" + expectedText + "] but found [" + actualText + "]");
}
}
}
