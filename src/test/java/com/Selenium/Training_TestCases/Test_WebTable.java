package com.Selenium.Training_TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_WebTable {


	WebDriver driver =null;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\eclipse-workspace\\com.Selenium.Training\\Drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		driver = new ChromeDriver(co);
		driver.get("https://www.red-gate.com/simple-talk/databases/sql-server/t-sql-programming-sql-server/table-value-constructors-in-sql-server-2008/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

	
	
	@Test
	public void Test_Table() {

		JavascriptExecutor jcs = (JavascriptExecutor) driver;

		WebElement move=driver.findElement(By.xpath("//*[@id=\"pretty\"]/div[5]/table/tbody"));

		jcs.executeScript("arguments[0].scrollIntoView()", move);

		List<WebElement> row=driver.findElements(By.xpath("//*[@id=\"pretty\"]/div[5]/table/tbody/tr"));

		List<WebElement> col=driver.findElements(By.xpath("//*[@id=\"pretty\"]/div[5]/table/tbody/tr[1]/td"));

		int rowsize = row.size();

		int colsize = col.size();

		System.out.println(rowsize);

		System.out.println(colsize);
		
		Assert.assertEquals(rowsize, 8,"ROW SIZE  NOT MATCHING");

		Assert.assertEquals(colsize, 4,"COLUMN SIZE  NOT MATCHING");
		
		boolean status =false;
		
		for (int i = 2; i<=rowsize; i++) {
			for (int j = 1; j<=colsize; j++) {

				WebElement table=driver.findElement(By.xpath("//*[@id=\"pretty\"]/div[5]/table/tbody/tr["+ i +"]/td["+ j +"]"));
				String tablevalue =table.getText();

				System.out.print(tablevalue+" ");
				
				if(tablevalue.contains("Road-350")) {
					
					status=true;
					break;
				}
				
					
			}
			System.out.println();
			
		}
		Assert.assertTrue(status);

	}
}
