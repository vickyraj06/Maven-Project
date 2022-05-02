package com.Selenium.Training_TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterKey {

	public static void main(String[] args) throws AWTException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement txtbox=driver.findElement(By.xpath("//input[@name='q']"));
		
	//	txtbox.sendKeys("JAVA"+Keys.ENTER);
		
		//txtbox.sendKeys("JAVA \n");
		
		txtbox.sendKeys("JAVA");
		
		Robot rb = new Robot();
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
