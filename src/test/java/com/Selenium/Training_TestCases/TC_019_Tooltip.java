package com.Selenium.Training_TestCases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_019_Tooltip {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		ChromeOptions options = new ChromeOptions();
	//	options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		
		driver = new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/tooltip.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}


	@Test
	public void Test_Tooltip() throws IOException   {


		WebElement Textbox=driver.findElement(By.id("age"));

		String tooltip=Textbox.getAttribute("title");
		
		
		System.out.println(tooltip);

		
		TakesScreenshot tcs = (TakesScreenshot) driver;
		
		File src=tcs.getScreenshotAs(OutputType.FILE);
		
		File des = new File("Tooltip.png");
		
		FileUtils.copyFile(src, des);


	}

}
