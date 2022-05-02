package com.Selenium.Training_TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calenadar {

	public static void main(String[] args) {


		ChromeOptions co= new ChromeOptions();
		//co.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("http://www.leafground.com/pages/Calendar.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement txtbox=driver.findElement(By.xpath("//input[@id='datepicker']"));
		
		txtbox.click();
		
		String month="November 2022";
		
		String date="6";
		
		while(true) {
			
			String actual_month=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			
			if (actual_month.equals(month)) {
				
				break;
			}
			else {
				
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				
				
			}
			
			
			
		}
		
		List<WebElement> actual_date = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		
		for (WebElement dt : actual_date) {
			
			System.out.println(dt.getText());
			
			if(dt.getText().equals(date)) {
				
				System.out.println(dt.getText());
				dt.click();
				break;
				
			}
			
		}
				
		
		
		
		
		

	}

}
