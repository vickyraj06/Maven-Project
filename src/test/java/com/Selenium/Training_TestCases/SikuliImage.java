package com.Selenium.Training_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SikuliImage {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		
		driver= new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=ng2uQzYZ55Q");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {

//		driver.quit();
		
	}

	@Test
	public void AutoFlashobject() throws FindFailed{
		
		Screen sc = new Screen();
		
		Pattern pt = new Pattern("/com.Selenium.Training/pause.png");
		
		sc.wait(pt, 1000);
		
		sc.click();
		
		sc.click();
		
		
		
		
		
	}


}
