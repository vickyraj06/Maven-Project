package com.Selenium.Training_TestCases;




import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_012_Calendar   {

	

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Calendar.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_Calendar()  throws IOException  {


		WebElement click=driver.findElement(By.id("datepicker"));

		click.click();


		String year= "March 2025";

		String date ="27";


		
		while(true) {


			String month=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();


			if(month.equals(year)) {

				break;
			}

			else {


				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

			}


		}

		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));

		for (WebElement datepicker : dates) {

			if(datepicker.getText().equals(date)) {

				datepicker.click();
				/*
				 * TakesScreenshot ts=(TakesScreenshot) driver;
				 * 
				 * File srcFile=ts.getScreenshotAs(OutputType.FILE);
				 * 
				 * File deFile = new File(
				 * "C:\\eclipse-workspace\\com.Selenium.Training\\Screenshots\\calendar.png");
				 * 
				 * FileUtils.copyFile(srcFile, deFile);
				 */
				
			}

		}
		

		


	}



}
