package com.Selenium.Training_TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class DateTime {

	WebDriver driver = null;

	@Test
	public void Date() throws IOException, InterruptedException {

		LocalDate dt = LocalDate.now();
		System.out.println("DATE IS :  " + dt);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("DATE TIME IS : " + ldt);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		String Dateformat = dtf.format(ldt);
		System.out.println("TODAT DATE & TIME IS :" + Dateformat);

		LocalDateTime myDateObj = LocalDateTime.now();
		System.out.println("Before formatting: " + myDateObj);

		// DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy
		// HH:mm:ss");

		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);
		
		
		
		
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\eclipse-workspace\\com.Selenium.Training\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Sudalai_Madan");

		JavascriptExecutor jvs = (JavascriptExecutor) driver;
		WebElement sudalaimadanimage = driver.findElement(By.xpath("//table[@class='infobox']//tr[3]/td"));
		jvs.executeScript("arguments[0].style.border='3px solid red'", sudalaimadanimage);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		
		Date currentdate = new Date();
		System.out.println(currentdate);
		String scrfdatefile = currentdate.toString().replace(" ", "-").replace(":", "-");
		
		
		File des = new File(
				"C:\\eclipse-workspace\\com.Selenium.Training\\Screenshots\\" + scrfdatefile+ ".png");
		FileHandler.copy(src, des);

		Thread.sleep(2000);
		driver.close();

	}

}
