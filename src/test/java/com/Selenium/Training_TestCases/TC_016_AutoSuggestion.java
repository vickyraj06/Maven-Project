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

public class TC_016_AutoSuggestion {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}


	@Test
	public void Test_AutoSuggestion()  {


		WebElement textbox=driver.findElement(By.xpath("//input[@title='Search']"));

		textbox.sendKeys("selenium");


		List<WebElement> autosuggest=driver.findElements(By.xpath("//ul[@role='listbox']/li"));


		System.out.println("NUMBER OF AUTO SUGGESTIONS :"+autosuggest.size());


		for (WebElement autosuggestlist : autosuggest) {

			System.out.println(autosuggestlist.getText());

			if(autosuggestlist.getText().trim().equals("selenium download")) {

				autosuggestlist.click();

				break;
			}

		}
		

	}

}
