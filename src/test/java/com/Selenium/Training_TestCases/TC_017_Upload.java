package com.Selenium.Training_TestCases;





import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_017_Upload {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions co = new ChromeOptions();
		co.merge(ds);
		//ChromeOptions co = new ChromeOptions();
		//co.setHeadless(true);

		driver = new ChromeDriver();


		driver.get("http://www.leafground.com/pages/upload.html");

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}


	@Test(expectedExceptions = InvalidArgumentException.class)
	public void Test_Upload()   {


		WebElement uploadbutton=driver.findElement(By.xpath("//input[@name='filename']"));
		
	

		uploadbutton.sendKeys("C:\\eclipse-workspace\\com.Selenium.Training\\calendar.png");




	}

}
