package com.Selenium.Training_TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_005_Dropdown {

	WebDriver driver;

	@BeforeClass
	public void setup() {

		// System.setProperty("webdriver.gecko.driver","geckodriver.exe");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_DropDown() throws InterruptedException {

		int a = 5;

		String name = "raj5555trdgg3344bgbgg";

		System.out.println(name);

		WebElement drp1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));

		WebElement drp2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));

		WebElement drp3 = driver.findElement(By.xpath("//select[@name='dropdown3']"));

		WebElement drp4 = driver.findElement(By.xpath("//select[@class='dropdown']"));

		WebElement drp5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select"));

		Select select1 = new Select(drp1);

		select1.selectByIndex(1);
		Thread.sleep(2000);
		// select1.se

		driver.switchTo().frame(drp3);

		driver.switchTo().defaultContent();

		Select select2 = new Select(drp2);

		select2.getOptions();

		select2.selectByValue("2");
		Thread.sleep(2000);

		Select select3 = new Select(drp3);

		select3.selectByVisibleText("UFT/QTP");
		Thread.sleep(2000);

		Select select4 = new Select(drp4);

		List<WebElement> drplist = select4.getOptions();

		System.out.println(drplist.size());

		for (WebElement webElement : drplist) {

			System.out.println(webElement.getText());

		}

		Select select5 = new Select(drp5);

		select5.selectByIndex(1);

		select5.selectByValue("2");

		select5.selectByVisibleText("UFT/QTP");

		List<WebElement> drpoptions = select5.getAllSelectedOptions();

		System.out.println("NUMBER OF OPTIONS SELECTED :" + drpoptions.size());

		for (WebElement webElement : drpoptions) {

			System.out.println(webElement.getText());

		}

	}

}
