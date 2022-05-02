package com.Selenium.Training_TestCases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon_Dropdown {

	WebDriver driver;

	@BeforeClass
	public void Setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.HOURS);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void Teardown() {

		driver.quit();
	}

	@Test
	public void user_is_on_homepage() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 13");

		Thread.sleep(2000);
		List<WebElement> itemlist = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div"));

		System.out.println(itemlist.size());
		for (WebElement itl : itemlist) {

			if (itl.getText().equals("iphone 13")) {
				itl.click();
				break;
			} else {
				Assert.assertTrue(false);
			}

		}

		List<WebElement> phonelist = driver
				.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/div/h2/a/span"));

		for (WebElement phonename : phonelist) {

			System.out.println(phonename.getText());

			if (phonename.getText().equals("Apple iPhone 13 (128GB) - Midnight")) {

				phonename.click();
				break;
			} else {

				TakesScreenshot ts = (TakesScreenshot) driver;
				File SrcFile = ts.getScreenshotAs(OutputType.FILE);

				File DestFile = new File("C:\\eclipse-workspace\\com.TCS.BFSC\\Screenshots\\ITEM_NOT_AVAILABLE.png");

				FileHandler.copy(SrcFile, DestFile);
				Assert.assertTrue(false);

			}

		}
	}
}
