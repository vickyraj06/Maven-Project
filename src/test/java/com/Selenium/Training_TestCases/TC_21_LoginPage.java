package com.Selenium.Training_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Selenium.Training_PageObjects.LoginPage;



public class TC_21_LoginPage extends BaseClass{


	@Test
	public void Test_Login() throws InterruptedException    {

		LoginPage lp = new LoginPage(driver);
		
		lp.setusername(username);
		
	
		
		lp.setpassword(password);
		
		lp.clicklogin();
		

		if (driver.getTitle().equals("murugaraj")) {

			Assert.assertTrue(true);
			lp.clicklogout();

		}
		
		else {

			Assert.assertTrue(false);
			
			
		}



	}

}
