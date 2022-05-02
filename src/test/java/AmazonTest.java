import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AmazonTest {
	
	
	@Test
	public void TestAmazon() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.amazon.in/");
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Electronics')]")).click();
		
		driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='boAt']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/div/div/div/div[1]/span/a/div/img")).click();
	}

}
//img[@class='s-image'][@alt='boAt Bassheads 100 in Ear Wired Earphones with Mic(Black)']