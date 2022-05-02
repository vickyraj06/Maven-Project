package com.Selenium.Training_TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Selenium.Training_PageObjects.LoginPage;
import com.Selenium.Training_Utilities.XLUtils;



public class TC_22_LoginPage_DDT extends BaseClass{

	
	@DataProvider(name="testdata")
	public Object[][] GetExceldata() throws IOException{
		
		String path="C:\\eclipse-workspace\\com.Selenium.Training\\src\\test\\java\\com\\Selenium\\Training_TestData\\testdata.xlsx";
		
		int rowcount = XLUtils.getRowCount(path,"sheet1");
		
		int cellcount = XLUtils.getCellCount(path,"sheet1", 1);
		
		Object logindata[][]= new Object[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return logindata;
		
	}
	
	
	@Test(dataProvider ="testdata")
	public void Test_Login_DDT(String user,String pass)    {

		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		lp.setusername(user);
		
		lp.setpassword(pass);
		
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
