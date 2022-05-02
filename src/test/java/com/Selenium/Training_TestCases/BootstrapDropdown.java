package com.Selenium.Training_TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BootstrapDropdown {
	
	WebDriver driver=null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {

		//driver.quit();
	}
	
	@Test
	public void Test_DropDown() throws InterruptedException  {
		
		JavascriptExecutor jcs = (JavascriptExecutor) driver;
		
		WebElement go=driver.findElement(By.xpath("//div[normalize-space()='Single button dropdowns']"));
		

		jcs.executeScript("arguments[0].scrollIntoView()",go);
		
	//	Thread.sleep(2000);
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		
		List<WebElement> drp=driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
		
		System.out.println(drp.size());
		
		for (WebElement drplist : drp) {
			
			if(drplist.getText().equals("Something else here")) {
				
				drplist.click();
				break;
			}
			System.out.println(drplist.getText());
			
			
		}
		
		
	}

}
