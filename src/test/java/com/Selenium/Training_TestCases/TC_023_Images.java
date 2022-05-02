package com.Selenium.Training_TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TC_023_Images extends BaseClass {


	/*
	 * WebDriver driver=null;
	 * 
	 * @BeforeClass public void setup() {
	 * 
	 * driver = new ChromeDriver();
	 * 
	 * driver.get("http://www.leafground.com/pages/Image.html");
	 * 
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 * 
	 * }
	 * 
	 * @AfterClass public void teardown() {
	 * 
	 * driver.quit(); }
	 */


	@Test
	public void Test_Images() throws IOException {
		
		
		
		List<WebElement> imagetag=driver.findElements(By.tagName("img"));
		
		
		for (WebElement image : imagetag) {
			
			String imagesrc =image.getAttribute("src");
			
			URL url = new URL(imagesrc);
			
			HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
			
			httpURLConnection.connect();
			
			
			if(httpURLConnection.getResponseCode()==200) {
				
				System.out.println(httpURLConnection.getResponseCode()+ " "+ url +" "+ "VALID image");
				
			
			}
			else {
				
				System.out.println(httpURLConnection.getResponseCode()+ " "+ url +" "+ "Broken img");
			}
		
			
		}
		
/*
		List<WebElement> image =driver.findElements(By.tagName("img"));

		int imgsize=image.size();
		
		System.out.println(imgsize);
		
		int brokenimage=0;
		
		for (WebElement imglink : image) {
			
			String img=imglink.getAttribute("src");
			
			URL url =new URL(img);
			
			HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
			
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode()==200) {
				
				System.out.println(httpURLConnection.getResponseCode()+img+"is :" + "VALID IMAGE");
			}else {
				
				System.out.println(httpURLConnection.getResponseCode()+img+ "is :"+ "BROKEN IMAGE");
				
				brokenimage++;
			}
		}

		System.out.println("BROKEN IMAGES :"+brokenimage);

		*/


	}

}
