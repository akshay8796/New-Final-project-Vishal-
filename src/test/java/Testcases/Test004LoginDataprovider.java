package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.HomePageAccount;
import POM.Loginpage;
import Utilities.DataProviders;

public class Test004LoginDataprovider extends BaseClassTest{
	
	@Test(dataProvider ="LoginData",dataProviderClass = DataProviders.class, groups = {"Sanity"})
public void test_01(String email, String pwd, String exp)
{
		HomePage   home=new  HomePage(driver);
	    home.ClickonMyaccount();

	    home.ClickonLogin();
	   
	    Loginpage loginninja=new Loginpage(driver);
		loginninja.setEmail(email);
		loginninja.setpassword(pwd);
		loginninja.ClickOnLoginButton();
		
		HomePageAccount acc=new HomePageAccount(driver);
        Boolean targetPage = acc.DisplayMyAccount();

		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage == true) {
				acc.ClickOnlogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}			
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage == true) {
				acc.ClickOnlogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	              
		 
		
	}
}
