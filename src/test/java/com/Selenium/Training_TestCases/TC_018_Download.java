package com.Selenium.Training_TestCases;




import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_018_Download {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {



		String path="C:\\eclipse-workspace\\com.Selenium.Training\\Downloads";

		HashMap<String, Object> preference=new HashMap<String, Object>();

		preference.put("download.default_directory", path );

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs",preference);

		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/download.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();



	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}


	@Test
	public void Test_Download() throws InterruptedException   {


		WebElement downloadlink=driver.findElement(By.xpath("//a[normalize-space()='Download Excel']"));

		downloadlink.click();

		Thread.sleep(2000);




	}

}
