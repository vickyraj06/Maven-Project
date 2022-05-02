package com.Selenium.Training_TestCases;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc_023_Amazon {

	WebDriver driver ;

	@BeforeClass
	public void setup() {


		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}


	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_amazon() throws AWTException, IOException {

		WebElement text=driver.findElement(By.xpath("//a[contains(text(),'Electronics')]"));
		text.click();

		Robot rb = new Robot();
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec = new Rectangle(dim);
		BufferedImage src=rb.createScreenCapture(rec);
		File des= new File("/com.Selenium.Training/Screenshots");
		ImageIO.write(src, "png", des);

		WebElement move=driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[5]/ul[1]/li[1]/span[1]/a[1]/span[1]"));

		JavascriptExecutor jcs = (JavascriptExecutor) driver;

		jcs.executeScript("arguments[0].scrollIntoView()", move);

		driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[5]/ul[1]/li[1]/span[1]/a[1]/span[1]")).click();



	}

}
