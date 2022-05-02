package com.Selenium.Training_TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Flipkart {
	
	WebDriver driver;

    @BeforeClass
	public void setup() {

    	driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}


	@AfterClass
	public void teardown() {

	//	driver.quit();
	}
	
	@Test
	public void Test_Flipkart() {
		
		//driver.findElement(By.xpath("//a[@class='_1_3w1N']")).click();
		
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("hi");

		/*
		 * List<WebElement> drpvalues = driver.findElements(By.xpath(
		 * "//div[@class='autocomplete-results-container']/div"));
		 * 
		 * drpvalues.size();
		 * 
		 * for (WebElement drp : drpvalues) { System.out.println(drp.getText());
		 * 
		 * if(drp.getText().equals("headset")) {
		 * 
		 * drp.click(); break; }
		 * 
		 * }
		 */

	}

}
