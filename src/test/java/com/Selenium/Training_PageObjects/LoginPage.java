package com.Selenium.Training_PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;


	@FindBy(xpath = "//input[@id='password1']")
	WebElement password;


	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement login;


	@FindBy(xpath = "//button[normalize-space()='Log Out']")
	WebElement logout;



	public void setusername(String user) {

		username.sendKeys(user);

	}

	public void setpassword(String pass) {

		password.sendKeys(pass);

	}

	public void clicklogin() {

		login.click();

	}
	
	

	public void clicklogout() {

		logout.click();

	}

}
