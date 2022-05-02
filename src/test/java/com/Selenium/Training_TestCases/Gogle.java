package com.Selenium.Training_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Gogle {

	public static void main(String[] args) {
		
		ChromeOptions co = new ChromeOptions();
		
		co.addArguments("headless");
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://www.google.com/");
		
		WebElement text=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
		
		String textname=text.getAttribute("alt");
		
		System.out.println(textname);

	}

}
