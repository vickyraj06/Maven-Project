package com.Selenium.Training_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessBrowser {
	
	WebDriver driver ;
	
	@BeforeClass
	public void setup() {
		
		driver = new HtmlUnitDriver();
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("headless");
		
	//	driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mvnrepository.com/");
		
		
	}
	
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
		
	}
	
	
	@Test
	public void headlessbrowser() {
		
		WebElement text=driver.findElement(By.xpath("//a[normalize-space()='Aspect Oriented']"));
		
		text.click();
		
		System.out.println("TITLE OF PAGE IS :"+ driver.getTitle());
	}

}
