package com.Selenium.Training_TestCases;



import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_015_Mousehover {

	WebDriver driver = null;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/mouseOver.html#");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	@Test
	public void Test_MouseHover()  {


		WebElement mousehover1=driver.findElement(By.xpath("//a[normalize-space()='TestLeaf Courses']"));


		Actions actions = new Actions(driver);


		actions.moveToElement(mousehover1).perform();


		List<WebElement> mousehover2=driver.findElements(By.xpath("//div[@class='container in']//ul//ul/li"));

		
		for (WebElement webElement : mousehover2) {

			System.out.println(webElement.getText());

			if(webElement.getText().equals("WebServices")) {

				webElement.click();
				break;
			}

		}

		driver.switchTo().alert().accept();



	}

}
