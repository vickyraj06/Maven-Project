package com.Selenium.Training_TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class CssSelector {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/home.html");
		
		WebElement logo=driver.findElement(By.xpath("//img[@src='../images/testleaf_logo.png']"));
		
		logo.click();
		System.out.println(logo.getCssValue("color"));
		
		String color =logo.getCssValue("color");


		String hex =  Color.fromString(color).asHex();
				
				
		System.out.println(hex);
		
		String rgba = Color.fromString(color).asRgba();

		System.out.println(rgba);
		
	}

}
