package com.Selenium.Training_TestCases;




import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {
		
		ChromeOptions cos = new ChromeOptions();
		
	//	cos.addArguments("disable-notifications");

		driver = new ChromeDriver(cos);

		driver.get("https://www.yatra.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

	driver.quit();
	}

	
	@Test
	public void Test_Windows() {

		
	//	driver.findElement(By.xpath("//a[normalize-space()='Mobiles']")).click();

	


	}

}
