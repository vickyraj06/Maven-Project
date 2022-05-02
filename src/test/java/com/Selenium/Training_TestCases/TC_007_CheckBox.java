package com.Selenium.Training_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_007_CheckBox {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/checkbox.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_CheckBox() {

		WebElement cb = driver.findElement(By.xpath("//div[normalize-space()='Java']//input[@type='checkbox']"));
		
		WebElement cb1=driver.findElement(By.xpath("//div[normalize-space()='Option 1']//input[@type='checkbox']"));

		WebElement cb2=driver.findElement(By.xpath("//div[normalize-space()='Option 2']//input[@type='checkbox']"));
		
		WebElement cb3=driver.findElement(By.xpath("//div[normalize-space()='Option 3']//input[@type='checkbox']"));
		
		WebElement cb4=driver.findElement(By.xpath("//div[normalize-space()='Option 4']//input[@type='checkbox']"));
		
		WebElement cb5=driver.findElement(By.xpath("//div[normalize-space()='Option 5']//input[@type='checkbox']"));
		
		
		System.out.println(cb.isSelected());

		cb.click();

		System.out.println(cb.isSelected());
		
		
		cb1.click();
		
		cb2.click();
		
		cb3.click();
		
		cb4.click();
		
		cb5.click();
	}

}
