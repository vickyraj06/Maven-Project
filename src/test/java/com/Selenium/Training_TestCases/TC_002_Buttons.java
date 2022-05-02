package com.Selenium.Training_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_002_Buttons {
	
	WebDriver driver=null;
	
	@BeforeClass
	public void setup() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("disable-notifications");
		co.addArguments("start-maximized");

	
		driver = new ChromeDriver(co);
		
		driver.get("http://www.leafground.com/pages/Button.html");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}
	
	
	@Test(groups = {"functional"})
	public void Test_Buttons() {
		
	
		WebElement button1=driver.findElement(By.xpath("//button[@id='home']"));
		
		button1.click();
		
		driver.navigate().back();
		
		
		
		WebElement button2=driver.findElement(By.xpath("//button[@id='position']"));
		
		int x=button2.getLocation().getX();
		int y= button2.getLocation().getY();
		
		System.out.println("LOCATION OF X :"+ x +"  LOCATION OF Y :"+ y);
		
		
		
		
		WebElement button3=driver.findElement(By.xpath("//button[@id='color']"));
		
		String butcolor = button3.getCssValue("background-color");
		
		String butclr = Color.fromString(butcolor).asHex();
		
		System.out.println(butclr);
		
		
		
		WebElement button4=driver.findElement(By.xpath("//button[@id='size']"));
		
		int h=button4.getSize().getHeight();
		
		int w=button4.getSize().getWidth();
		
		System.out.println("HEIGHT :"+ h +"  WIDTH:"+ w);

		driver.quit();
		
	
	}

}
