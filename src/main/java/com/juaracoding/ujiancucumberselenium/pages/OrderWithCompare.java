package com.juaracoding.ujiancucumberselenium.pages;

import java.util.ArrayList;
import java.util.List;

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
	
	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td/a")
	WebElement btnSelect1;
	
	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td[2]/a")
	WebElement btnSelect2;
	
	@FindBy(id = "pa_color")
	WebElement dropdown_color;
	
	@FindBy(id = "pa_size")
	WebElement dropdown_size;
	
	@FindBy(xpath = "//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button")
	WebElement btnCart;
	
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
	
	Actions action = new Actions(driver);
	
	public void backToHomePage() {
		btnHome.click();
	}
	
	public void pilihProduct1(int pilih) {
		
		scroll();
		scroll();
		action.moveToElement(hoverProduct1).perform();
		action.moveToElement(btnCompare1).click().perform();
		btnSelect1.click();
		tunggu();
		scroll();
		scroll();

		dropdown_color.click();
		List<Keys> dropdown_color = new ArrayList<Keys>();
		for(int i=0; i<pilih; i++) {
			dropdown_color.add(Keys.DOWN);
		}
		dropdown_color.add(Keys.ENTER);
		CharSequence[] cs = dropdown_color.toArray(new CharSequence[dropdown_color.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
		
		
		dropdown_size.click();
		List<Keys> dropdown_size = new ArrayList<Keys>();
		for(int i=0; i<1; i++) {
			dropdown_size.add(Keys.DOWN);
		}
		dropdown_size.add(Keys.ENTER);
		CharSequence[] cs1 = dropdown_size.toArray(new CharSequence[dropdown_size.size()]);
		Actions keyDown1 = new Actions(driver); keyDown1.sendKeys(Keys.chord(cs1)).perform();
		
		btnCart.click();
		
	}
	
	public void pilihProduct2(int pilih) {
		
		btnHome.click();
		scroll();
		scroll();
		action.moveToElement(hoverProduct2).perform();
		action.moveToElement(btnCompare2).click().perform();
		btnSelect2.click();
		tunggu();
		scroll();
		scroll();


		dropdown_color.click();
		List<Keys> dropdown_color = new ArrayList<Keys>();
		for(int i=0; i<pilih; i++) {
			dropdown_color.add(Keys.DOWN);
		}
		dropdown_color.add(Keys.ENTER);
		CharSequence[] cs = dropdown_color.toArray(new CharSequence[dropdown_color.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
		
		
		dropdown_size.click();
		List<Keys> dropdown_size = new ArrayList<Keys>();
		for(int i=0; i<1; i++) {
			dropdown_size.add(Keys.DOWN);
		}
		dropdown_size.add(Keys.ENTER);
		CharSequence[] cs1 = dropdown_size.toArray(new CharSequence[dropdown_size.size()]);
		Actions keyDown1 = new Actions(driver); keyDown1.sendKeys(Keys.chord(cs1)).perform();
		
		btnCart.click();
		
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
