package com.juaracoding.ujiancucumberselenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujiancucumberselenium.drivers.DriverSingleton;

public class RegisterPage {
	
	private WebDriver driver;
	
	public RegisterPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(2) > a")
	WebElement btnMyAccount;
	
	@FindBy(id = "reg_username")
	WebElement inputUsernameReg;
	
	@FindBy(id = "reg_password")
	WebElement inputPasswordReg;
	
	@FindBy(id = "reg_email")
	WebElement inputEmailReg;
	
	@FindBy(css = "##customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")
	WebElement btnRegister;
	
	public void submitRegister(String usernameReg, String passwordReg, String email) {
		btnMyAccount.click();
		tunggu();
		scroll();
		inputUsernameReg.sendKeys(usernameReg);
		inputEmailReg.sendKeys(email);
		inputPasswordReg.sendKeys(passwordReg);
		btnRegister.click();
	}
	
	public String getTxtTitleLoginPage() {
		return driver.getTitle();
	}
	
	public void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scroll() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}

}
