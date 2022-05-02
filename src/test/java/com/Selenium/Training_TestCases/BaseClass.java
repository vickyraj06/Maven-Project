package com.Selenium.Training_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Selenium.Training_Utilities.ReadConfig;

public class BaseClass {


	ReadConfig rc=new ReadConfig();
	
	public String baseurl=rc.GetBaseurl();
	
	public String username=rc.GetUsername();
	
	public String password=rc.GetPassword();
	
	public static WebDriver driver;
	
	

	@BeforeClass
	@Parameters("browsername")
	public void setup(String browsername) {
		
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browsername.equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
			
		}else {
			
			driver = new ChromeDriver();
		}

		

		driver.get(baseurl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();



	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}


}
