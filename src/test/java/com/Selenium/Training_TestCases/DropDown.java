package com.Selenium.Training_TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement drp=driver.findElement(By.xpath("//select[@id='dropdown1']"));
		
		Select select = new Select(drp);
		
		select.selectByIndex(1);
		
		Thread.sleep(1000);
		
		select.selectByVisibleText("Appium");
		
		Thread.sleep(1000);
		
		select.selectByValue("3");
		
		List<WebElement> drplist=select.getOptions();
		
		for (WebElement webElement : drplist) {
			
			System.out.println(webElement.getText());
			
		}

	}

}
