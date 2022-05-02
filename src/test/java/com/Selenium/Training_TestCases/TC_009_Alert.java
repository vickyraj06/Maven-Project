package com.Selenium.Training_TestCases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_009_Alert {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Alert.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test(enabled = true , invocationCount = 2)
	public void Test_Alert() throws InterruptedException {

		WebElement alert1 = driver.findElement(By.xpath("//button[normalize-space()='Alert Box']"));

		WebElement alert2 = driver.findElement(By.xpath("//button[normalize-space()='Confirm Box']"));

		WebElement alert3 = driver.findElement(By.xpath("//button[normalize-space()='Prompt Box']"));

		WebElement alert4 = driver.findElement(By.xpath("//button[normalize-space()='Line Breaks?']"));





		alert1.click();
		driver.switchTo().alert().accept();



		alert2.click();
		driver.switchTo().alert().dismiss();



		alert3.click();
		driver.switchTo().alert().sendKeys("THALAPATHY");
		driver.switchTo().alert().accept();



		alert4.click();
		String AlertText=driver.switchTo().alert().getText();
		System.out.println(AlertText);
		driver.switchTo().alert().accept();







	}

}
