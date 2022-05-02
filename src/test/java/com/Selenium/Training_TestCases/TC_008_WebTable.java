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

public class TC_008_WebTable {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		System.setProperty("webdriver.chrome.driver","C:\\eclipse-workspace\\com.Selenium.Training\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		

		

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_WebTable() {

		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"table_id\"]/tbody/tr"));

		List<WebElement> column=driver.findElements(By.xpath("//*[@id=\"table_id\"]/tbody/tr[1]/th"));


		int rowsize=row.size();

		int colsize=column.size();
		
		System.out.println(rowsize);
		
		System.out.println(colsize);
		
		
		for(int i=2;i<=rowsize;i++) {
			for(int j=1;j<=colsize;j++) {
				
				WebElement table=driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr["+ i +"]/td["+ j +"]"));
				
				String tablevalue=table.getText();
				
				System.out.print(tablevalue+"    ");
			}
			System.out.println();
		}
		
		
		
	}

}
