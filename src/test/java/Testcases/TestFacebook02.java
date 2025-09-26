package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.FaceBookHome;
import POM.FacebookCreateAcc;

public class TestFacebook02 extends BaseClassTest
{

	@Test
	public void testFacebookProperty()
	{
		FaceBookHome home=new FaceBookHome(driver);
		home.ClickOnCreateAcc();
		
		FacebookCreateAcc cret=new FacebookCreateAcc(driver);
		cret.setfirstname("akshay");
		cret.setLastname("Dhanedhar");
		
		String actualFirstname = cret.getlabelFname();
	    String ActualLastname = cret.getlabelLastname();
	    
	    Assert.assertEquals(actualFirstname, "akshay");
	    System.out.println(actualFirstname);
	}
	
	
}
