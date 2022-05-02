package com.Selenium.Training_TestCases;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_001_TextBox {
	
	
	WebDriver driver=null;
	
	@BeforeClass
	public void setup() {
		
	
		driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Edit.html");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}

	
	@Test(groups = {"smoky"})
	public  void Test_Textbox() {
		
		
		WebElement textbox1 = driver.findElement(By.xpath("//input[@value='Append ']"));
		
		WebElement texbox2 = driver.findElement(By.xpath("//input[@id='email']"));

		
		Actions ac =new Actions(driver);
		
		ac.keyDown(textbox1, Keys.CONTROL).sendKeys("a").sendKeys("c").perform();
		
		
		ac.keyDown(texbox2,Keys.CONTROL).sendKeys("a").sendKeys("v").perform();
		
		
		WebElement textvalue=driver.findElement(By.xpath("//input[@value='TestLeaf']"));
		
		System.out.println(textvalue.getAttribute("value"));
		
		WebElement textclear=driver.findElement(By.xpath("//input[@value='Clear me!!']"));
		
		textclear.clear();
		
		
		WebElement textbox3=driver.findElement(By.xpath("//input[@disabled='true']"));
		
		boolean textboxenabled=textbox3.isEnabled();
		
		
		boolean textboxenabled2=textvalue.isEnabled();
		
		System.out.println(textboxenabled);
		
		System.out.println(textboxenabled2);
		
		
		
	}

}
