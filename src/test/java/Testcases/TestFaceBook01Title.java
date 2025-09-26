package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.FaceBookHome;

public class TestFaceBook01Title extends BaseClassTest{
	
	
	@Test
	public void testTitleFacebook()
	{
		FaceBookHome home=new FaceBookHome(driver);
		home.ClickOnCreateAcc();
		
		Assert.assertEquals("Sign up for Facebook", driver.getTitle());
		
	}
}
