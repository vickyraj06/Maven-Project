package com.Selenium.Training_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_006_RadioButton {
	
	
	WebDriver driver=null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/radio.html");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}
	
	
	@Test
	public void Test_RadioButton() {
		
		
		WebElement rb1=driver.findElement(By.xpath("//input[@id='yes']"));
		
		System.out.println(rb1.isSelected());
		
		rb1.click();
		
		System.out.println(rb1.isSelected());
	}

}
