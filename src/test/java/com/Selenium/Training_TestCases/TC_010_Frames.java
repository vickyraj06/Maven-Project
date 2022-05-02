package com.Selenium.Training_TestCases;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_010_Frames {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/frame.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_Frames() {


		driver.switchTo().frame(0); 

		WebElement button1=driver.findElement(By.xpath("//button[@id='Click']"));

		button1.click();




		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);

		WebElement NestedFrame = driver.findElement(By.id("frame2"));

		driver.switchTo().frame(NestedFrame);

		WebElement button2=driver.findElement(By.xpath("//button[@id='Click1']"));

		button2.click();

		driver.switchTo().defaultContent();
		
		
	



		List<WebElement> framessize =driver.findElements(By.tagName("iframe"));

		System.out.println(framessize.size());







	}

}
