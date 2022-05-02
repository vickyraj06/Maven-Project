package com.Selenium.Training_TestCases;



import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_011_Windows {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_Windows() throws InterruptedException {


		WebElement button1=driver.findElement(By.xpath("//button[@id='home']"));
		
		String oldwindow=driver.getWindowHandle();
		
		System.out.println(oldwindow);

		button1.click();
		
		Thread.sleep(2000);
		
		
		Set<String> browsers=driver.getWindowHandles();
		
		
		
		for (String newwindow : browsers) {
			
			driver.switchTo().window(newwindow);
			
		}
		
		WebElement edit=driver.findElement(By.xpath("//a[@href='pages/Edit.html']"));
		
		Thread.sleep(2000);
		
		edit.click();
		
		Thread.sleep(2000);
		
		driver.close();
		
		
		
		
		driver.switchTo().window(oldwindow);
		
		WebElement button2 = driver.findElement(By.xpath("//button[normalize-space()='Open Multiple Windows']"));
		
		Thread.sleep(2000);
		
		button2.click();
		
		Set<String> latestbrowsers=driver.getWindowHandles();
		
		System.out.println("NUMBER OF WINDOWS :"+ latestbrowsers.size());


		for (String latestwindow : latestbrowsers) {
			
			driver.switchTo().window(latestwindow);
			
			
			if (!latestwindow.equals(oldwindow)) {
				
				Thread.sleep(2000);
				
				driver.close();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}







































