package com.Selenium.Training_TestCases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_TicketBooking {

	WebDriver driver;

	@BeforeClass
	public void Setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver.get("http://www.kamalacinemas.com/");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);

	}

	@AfterClass
	public void Teardown() {

		driver.close();
	}

	@Test
	public void TicketBook() throws InterruptedException, IOException {

		WebElement emailTxt = driver.findElement(By.xpath("//input[@name='q']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='5px solid yellow'", emailTxt);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("smartwatch", Keys.ENTER);

		/*
		 * driver.findElement(By.xpath("//img[@id='pg-popupclose']")).click();
		 * 
		 * WebElement beast =
		 * driver.findElement(By.xpath("//div[@id='nowshowing']/div/div/div[3]"));
		 * 
		 * Actions ac = new Actions(driver);
		 * 
		 * ac.moveToElement(beast).build().perform();
		 * 
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"nowshowing\"]/div/div/div[3]/div/div[1]/div[1]/a/i")).click();
		 * 
		 * String ExpectedTitle =
		 * "Kamala Cinemas Chennai Cinema ticket online booking & show timings.";
		 * 
		 * String ActualTitle = driver.getTitle();
		 * 
		 * if (ActualTitle.equals(ExpectedTitle)) {
		 * 
		 * Assert.assertTrue(true);
		 * 
		 * }
		 * 
		 * else {
		 * 
		 * Assert.assertTrue(false); }
		 * 
		 * WebElement date =
		 * driver.findElement(By.xpath("//ul[@id='ulShowDate']/li[2]"));
		 * 
		 * System.out.println(date.getText());
		 * 
		 * date.click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * String MovieTime = "4:00 AM";
		 * 
		 * List<WebElement> Times =
		 * driver.findElements(By.xpath("//div[@class='tn-timing-details']/ul/li"));
		 * 
		 * for (WebElement Time : Times) {
		 * 
		 * String Mrngshow = Time.getText(); System.out.println(Mrngshow);
		 * 
		 * if (Mrngshow.equals(MovieTime)) { Time.click();
		 * 
		 * }
		 * 
		 * else { System.out.println("PREFERRED TIME NOT FOUND"); }
		 * 
		 * }
		 * 
		 * TakesScreenshot ts = (TakesScreenshot) driver; File SrcFile =
		 * ts.getScreenshotAs(OutputType.FILE);
		 * 
		 * File DestFile = new File(
		 * "C:\\eclipse-workspace\\com.Selenium.Training\\Screenshots\\TicketBooking.png"
		 * );
		 * 
		 * FileUtils.copyFile(SrcFile, DestFile); Thread.sleep(2000);
		 * 
		 * }
		 */
	}
}
