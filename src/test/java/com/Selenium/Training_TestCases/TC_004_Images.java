package com.Selenium.Training_TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_004_Images {


	WebDriver driver=null;

	@BeforeClass
	public void setup() {

		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		
		//co.addArguments("headless");
		
		driver = new ChromeDriver(co);

		driver.get("http://www.leafground.com/pages/Image.html");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}


	@Test
	public void Test_Images() throws IOException {


		WebElement img1=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img"));

		img1.click();

		driver.navigate().back();


		List<WebElement>img2=driver.findElements(By.tagName("img"));

		int brokenimage=0;

		for (WebElement img3 : img2) {


			String image=img3.getAttribute("src");


			URL url=new URL(image);

			HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

			httpURLConnection.connect();

			if(httpURLConnection.getResponseCode()==200) {

				System.out.println(httpURLConnection.getResponseCode()+image+" is"+" NOT Broken Image");
			}
			else
			{

				System.out.println(httpURLConnection.getResponseCode()+image+" is"+" Broken Image");

				brokenimage++;
			}


		}
		System.out.println("NUMBER OF BROKEN IMAGES :"+brokenimage);

		Actions actions=new Actions(driver);

		WebElement imagelink=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img"));
		
		actions.moveToElement(imagelink).click().perform();
	}



}
