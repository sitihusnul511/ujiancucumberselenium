package com.juaracoding.ujiancucumberselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujiancucumberselenium.drivers.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_login")
	WebElement inputUsername;
	
	@FindBy(id = "user_pass")
	WebElement inputPassword;
	
	@FindBy(id = "wp-submit")
	WebElement btnLogin;
	
	
	
	public void submitLogin(String username, String password) {
		tunggu();
		inputUsername.sendKeys(username);
		tunggu();
		inputPassword.sendKeys(password);
		tunggu();
		btnLogin.click();
	}
	
	public String getTxtMyAccount() {
		return driver.getTitle();
	}
	
	public void tunggu() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
