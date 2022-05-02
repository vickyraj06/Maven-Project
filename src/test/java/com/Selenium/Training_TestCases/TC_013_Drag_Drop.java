package com.Selenium.Training_TestCases;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_013_Drag_Drop {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/drop.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_DRAGandDROP()  {


		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));

		
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));

		
		Actions actions = new Actions(driver);
	
		
		actions.dragAndDrop(drag, drop).perform();
		
	




	}

}
