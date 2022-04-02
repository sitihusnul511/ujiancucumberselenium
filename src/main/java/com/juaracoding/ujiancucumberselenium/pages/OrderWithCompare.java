package com.juaracoding.ujiancucumberselenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujiancucumberselenium.drivers.DriverSingleton;


public class OrderWithCompare {

	
private WebDriver driver;
	
	public OrderWithCompare() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "#noo-site > header > div.navbar-wrapper > div > div > div > div > a > img")
	WebElement btnHome;
	
	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/a")
	WebElement hoverProduct1;
	
	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[1]/a")
	WebElement btnCompare1;
	
	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/a")
	WebElement hoverProduct2;
	
	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[1]/a")
	WebElement btnCompare2;
	
	@FindBy(xpath = "//iframe[@name='1648907187293']")
	WebElement iframe;
	
	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td/a")
	WebElement btnSelect1;
	
	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td[2]/a")
	WebElement btnSelect2;
	
	@FindBy(id = "pa_color")
	WebElement dropdown_color;
	
	@FindBy(id = "pa_size")
	WebElement dropdown_size;
	
	@FindBy(xpath = "//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button")
	WebElement btnCart1;
	
	@FindBy(xpath = "//*[@id=\"product-1491\"]/div[1]/div[2]/form/div/div[2]/button")
	WebElement btnCart2;
	
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(3) > a")
	WebElement checkout;
	
	@FindBy(id = "billing_first_name")
	WebElement firstName;
	
	@FindBy(id = "billing_last_name")
	WebElement lastName;
	
	@FindBy(id = "billing_company")
	WebElement company;
	
	@FindBy(id = "select2-billing_country-container")
	WebElement dropdown_country;
	
	@FindBy(id = "billing_address_1")
	WebElement address;
	
	@FindBy(id = "billing_address_2")
	WebElement detailAddress;
	
	@FindBy(id = "billing_city")
	WebElement city;
	
	@FindBy(id = "select2-billing_state-container")
	WebElement dropdown_province;
	
	@FindBy(id = "billing_postcode")
	WebElement postcode;
	
	@FindBy(id = "billing_phone")
	WebElement phone;
	
	@FindBy(id = "terms")
	WebElement checkbox_terms;
	
	@FindBy(id = "place_order")
	WebElement btnPlaceOrder;
	
	@FindBy(css = "#post-7 > div > div > div > p.woocommerce-thankyou-order-received")
	WebElement txtOrder;
	
	
	public void backToHomePage() {
		btnHome.click();
	}
	
	public void pilihProduct1(String colors, String sizes) {
		
		scroll();
		scroll();
		tunggu();
		btnCompare1.click();
		tunggu();
		tunggu();
		
		int size = driver.findElements(By.tagName("1648907187293")).size();
	    for(int j=0; j<=size; j++){
		driver.switchTo().frame(j);
		int total=driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td/a")).size();
		System.out.println(total);
	    }
		btnSelect1.click();
		tunggu();
		
		tunggu();
		scroll();
		tunggu();

		dropdown_color.click();
		dropdown_color.sendKeys(colors);
		dropdown_color.sendKeys(Keys.ENTER);
		dropdown_size.click();
		dropdown_size.sendKeys(sizes);
		dropdown_size.sendKeys(Keys.ENTER);
		
		btnCart1.click();
		
	}
	
	public void pilihProduct2(String colors2, String sizes2) {
		
		btnHome.click();
		scroll();
		scroll();
		tunggu();
		btnCompare2.click();
		tunggu();
		tunggu();
		
		int size = driver.findElements(By.tagName("1648907187293")).size();
	    for(int j=0; j<=size; j++){
		driver.switchTo().frame(j);
		int total=driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td[2]/a")).size();
		System.out.println(total);
	    }
		btnSelect2.click();
		tunggu();
		
		tunggu();
		scroll();
		tunggu();

		dropdown_color.click();
		dropdown_color.sendKeys(colors2);
		dropdown_color.sendKeys(Keys.ENTER);
		dropdown_size.click();
		dropdown_size.sendKeys(sizes2);
		dropdown_size.sendKeys(Keys.ENTER);
		tunggu();
		btnCart2.click();
		
	}
	
	public void checkout() {
		checkout.click();
		tunggu();
		scroll();
		scroll();
		checkbox_terms.click();
		btnPlaceOrder.click();
		
	}
	
	public String getTxtOrder() {
		return txtOrder.getText();
		
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
