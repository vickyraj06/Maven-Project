package com.Selenium.Training_TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_23_Dropdown {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		
		ChromeOptions cop = new ChromeOptions();
		cop.addArguments("disable-notifications");

		driver= new ChromeDriver(cop);

	}

	@AfterClass
	public void teardown() {

		driver.quit();
		
	}

	@Test
	public void Dropdown() throws InterruptedException {

		
		driver.get("https://www.redbus.in/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		WebElement txtbox=driver.findElement(By.xpath("//input[@id='src']"));

		txtbox.sendKeys("chenna");

		List<WebElement>
		drp=driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']/li"));

		int drpsize = drp.size();

		System.out.println(drpsize);

		for (WebElement drplist : drp) {

			String drplist_text = drplist.getText();

			System.out.println(drplist_text);

			if (drplist_text.equals("Porur, Chennai")){

				drplist.click(); break; } }



		WebElement txtbox1=driver.findElement(By.xpath("//input[@id='dest']"));

		txtbox1.click();

		txtbox1.sendKeys("thiru");

		List<WebElement> drp1=driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']/li"));

		int drpsize1 = drp1.size();

		System.out.println(drpsize1);

		for (WebElement drplist : drp1) {

			String drplist_text = drplist.getText();

			System.out.println(drplist_text);

			if (drplist_text.equals("Thiruchendur")){

				drplist.click();
				break;
			}
		}

		String date="Dec 2021";
		
		while(true) {
			
			WebElement text_date=driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/td[2]"));
			
			if(text_date.getText().equals(date)) {
				
				break;
			}
			else {
				
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
			}
		}
		
		List<WebElement> text_day=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr/td"));
		
		String day="9";
		
		for (WebElement daylist : text_day) {
			
			if(daylist.getText().equals(day)) {
				
				daylist.click();
				break;
				
			}
			
		}

		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
	}

}
