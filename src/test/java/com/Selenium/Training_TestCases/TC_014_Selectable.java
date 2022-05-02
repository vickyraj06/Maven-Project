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

public class TC_014_Selectable {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/selectable.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_Selectable()   {


		WebElement drag=driver.findElement(By.xpath("//li[normalize-space()='Item 1']"));


		WebElement drop=driver.findElement(By.xpath("//li[normalize-space()='Item 7']"));


		Actions actions = new Actions(driver);

		actions.clickAndHold(drag);

		actions.release(drop).perform();




		/*  SORTABLE */

		driver.navigate().to("http://www.leafground.com/pages/sortable.html");


		WebElement drag1=driver.findElement(By.xpath("//li[normalize-space()='Item 1']"));


		WebElement drop1=driver.findElement(By.xpath("//li[normalize-space()='Item 7']"));



		actions.clickAndHold(drop1);

		actions.moveToElement(drag1).perform();





	}

}
