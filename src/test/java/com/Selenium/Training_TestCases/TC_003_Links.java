package com.Selenium.Training_TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_003_Links {

	WebDriver driver=null;

	@BeforeMethod
	public void setup() {
		
		ChromeOptions co = new ChromeOptions();
	//	co.addArguments("headless");

		driver = new ChromeDriver(co);

		driver.get("http://www.leafground.com/pages/Link.html");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

	@Test()
	public void Test_Links() throws IOException {


		WebElement link1=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/a"));

		link1.click();

		driver.navigate().back();



		WebElement link2=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/a"));

		String location=link2.getAttribute("href");

		System.out.println(location);



		List<WebElement> links=driver.findElements(By.tagName("a"));

		int linksize=links.size();

		System.out.println(linksize);

		int brokenlink=0;

		for (WebElement link : links) {

			String url=link.getAttribute("href");


			if ((url==null) || (url.isEmpty())){

				System.out.println("EMPTY LINKS");

				continue;
				
			}
			
			URL url1=new URL(url);

			HttpURLConnection httpURLConnection=(HttpURLConnection) url1.openConnection();

			httpURLConnection.connect();

			if(httpURLConnection.getResponseCode()>=400) {

				System.out.println(httpURLConnection.getResponseCode()+" "+url +"  is :"+ "BROKEN LINK");

				brokenlink++;
			}
			
			else {

				System.out.println(httpURLConnection.getResponseCode()+" "+url +"  is :"+ "VALID LINK");

			}


		}

		System.out.println(brokenlink);


	}


}
