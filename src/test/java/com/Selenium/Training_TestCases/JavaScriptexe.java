package com.Selenium.Training_TestCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptexe {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://mvnrepository.com/");
		
		//WebElement txtbox=driver.findElement(By.xpath("//input[@id='query']"));
		
	//	WebElement click =driver.findElement(By.xpath("//a[normalize-space()='Common Base']"));
		
		JavascriptExecutor jcs =(JavascriptExecutor) driver;
		
		//jcs.executeScript("arguments[0].value='raj'", txtbox);
		
		//jcs.executeScript("arguments[0].click();", click);
		
		jcs.executeScript("window.scrollBy(0,800)","");
		
		Thread.sleep(1000);

		jcs.executeScript("window.scrollBy(0,-800)","");
		
		Thread.sleep(1000);
		
		WebElement go=driver.findElement(By.xpath("//a[normalize-space()='PDF Libraries']"));
		
		jcs.executeScript("arguments[0].scrollIntoView();",go);
		
	
		
		Thread.sleep(1000);
		
		jcs.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(1000);
		
		driver.quit();
	
	}

}
