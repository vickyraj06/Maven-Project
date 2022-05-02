package com.Selenium.Training_TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_Dropdown {
	
	@Test
	public void Drop() {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement drp1=driver.findElement(By.id("dropdown1"));
		
		Select a = new Select(drp1);
		
		a.selectByIndex(2);
		
		a.selectByValue("4");
		
		a.selectByVisibleText("Selenium");
		
		List<WebElement> drpoptions=a.getOptions();
		
		
		
		for (WebElement drpvalue: drpoptions) {
			
			System.out.println(drpvalue.getText());
		}
		
		int size=drpoptions.size();
		
		System.out.println(drpoptions.size());
		System.out.println(size);
		
	
		
		
		
	}

}
