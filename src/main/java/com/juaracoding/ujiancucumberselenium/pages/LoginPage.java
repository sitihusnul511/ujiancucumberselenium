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
	
	@FindBy(id = "username")
	WebElement inputUsername;
	
	@FindBy(id = "password")
	WebElement inputPassword;
	
	@FindBy(css = "#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button")
	WebElement btnLogin;
	
	
	
	public void submitLogin(String username, String password) {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getPageTitleLogin() {
		return driver.getTitle();
	}

}
