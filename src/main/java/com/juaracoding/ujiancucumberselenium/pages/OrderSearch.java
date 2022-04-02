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

import com.juaracoding.ujiancucumberselenium.drivers.*;

public class OrderSearch {
	
private WebDriver driver;
	
	public OrderSearch() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#post-8 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders > a")
	WebElement menuOrders;
	
	@FindBy(css = "#post-8 > div > div > div > div.woocommerce-message.woocommerce-message--info.woocommerce-Message.woocommerce-Message--info.woocommerce-info > a")
	WebElement btnProduct;
	
	@FindBy(css = "#noo-site > header > div.navbar-wrapper > div > div > div > a")
	WebElement btnSearch;
	
	@FindBy(name = "s")
	WebElement inputProduct;
	
	@FindBy(css = "#noo-site > div.noo-container-shop.noo-shop-wrap > div.noo-row > div > div > div.noo-product-item.one.noo-product-sm-4.not_featured.post-1394.product.type-product.status-publish.has-post-thumbnail.product_cat-jeans.product_tag-jeans.product_tag-women.has-featured.instock.shipping-taxable.purchasable.product-type-variable > div > div.noo-product-thumbnail > div.noo-product-slider.owl-carousel.owl-theme > div.owl-wrapper-outer.autoHeight > div > div.owl-item.active > a > img")
	WebElement btnImgProduct;
	
	@FindBy(id = "pa_color")
	WebElement pilihWarna;
	
	@FindBy(id = "pa_size")
	WebElement pilihUkuran;
	
	@FindBy(xpath = "//*[@id=\"product-1394\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]")
	WebElement btnIncrease;
	
	@FindBy(xpath = "//*[@id=\"product-1394\"]/div[1]/div[2]/form/div/div[2]/div/div/button[1]")
	WebElement btnDecreased;
	
	@FindBy(css = "#product-1394 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	WebElement btnAddToCart;
	
	@FindBy(css = "#noo-site > div.noo-container-shop.noo-shop-wrap.noo-shop-single-fullwidth > div > div > div.woocommerce-notices-wrapper > div > a")
	WebElement btnViewCart;
	
	@FindBy(css = "#post-6 > div > div > div.cart-collaterals > div.cart_totals > div > a")
	WebElement btnProceedToCO;
	
	@FindBy(id = "billing_first_name")
	WebElement firstName;
	
	@FindBy(id = "billing_last_name")
	WebElement lastName;
	
	@FindBy(id = "billing_company")
	WebElement company;
	
	@FindBy(id = "select2-billing_country-container")
	WebElement country;
	
	@FindBy(id = "body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement inputcountry;
	
	
	@FindBy(id = "billing_address_1")
	WebElement address;	
	
	@FindBy(id = "billing_address_2")
	WebElement detailAddress;
	
	@FindBy(id = "billing_city")
	WebElement city;
	
	@FindBy(id = "select2-billing_state-container")
	WebElement province;
	
	@FindBy(id = "body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement inputprovince;
	
	
	@FindBy(id = "billing_postcode")
	WebElement postcode;
	
	@FindBy(id = "billing_phone")
	WebElement phone;
	
	@FindBy(id = "terms")
	WebElement terms;
	
	@FindBy(id = "place_order")
	WebElement btnPlaceOrder;
	
	@FindBy(css = "#post-7 > div > div > div > p.woocommerce-thankyou-order-received")
	WebElement getTxtOrder;
	
	public void goToMenuOrders() {
		tunggu();
		menuOrders.click();
		scroll();
		btnProduct.click();
	}
	
	public void searchProduct(String product, String color, String size) {
		btnSearch.click();
		inputProduct.sendKeys(product);
		inputProduct.sendKeys(Keys.ENTER);
		scroll();
		btnImgProduct.click();
		scroll();
		scroll();
		pilihWarna.click();
		pilihWarna.sendKeys(color);
		pilihWarna.sendKeys(Keys.ENTER);
		pilihUkuran.click();
		pilihUkuran.sendKeys(size);
		pilihUkuran.sendKeys(Keys.ENTER);
		btnIncrease.click();
		btnDecreased.click();
		btnAddToCart.click();
		tunggu();
		btnViewCart.click();
	}
	
	public void checkoutProduct(String fn, String ln, String kantor, String negara, 
			String add, String add2, String kota, String prov, String post, String telp) {
		btnProceedToCO.click();
		scroll();
		tunggu();
		firstName.sendKeys(fn);
		tunggu();
		lastName.sendKeys(ln);
		tunggu();
		company.sendKeys(kantor);
		tunggu();
		
		country.click();
		List<Keys> country = new ArrayList<Keys>();
		for(int i=0; i<2; i++) {
			country.add(Keys.DOWN);
		}
		country.add(Keys.ENTER);
		CharSequence[] cs = country.toArray(new CharSequence[country.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
		
		scroll();
		tunggu();
		address.sendKeys(add);
		tunggu();
		detailAddress.sendKeys(add2);
		tunggu();
		scroll();
		city.sendKeys(kota);
		tunggu();
		
		province.click();
		List<Keys> province = new ArrayList<Keys>();
		for(int i=0; i<2; i++) {
			province.add(Keys.DOWN);
		}
		province.add(Keys.ENTER);
		CharSequence[] cs1 = province.toArray(new CharSequence[province.size()]);
		Actions keyDown1 = new Actions(driver); keyDown1.sendKeys(Keys.chord(cs1)).perform();
		
		tunggu();
		postcode.sendKeys(post);
		tunggu();
		phone.sendKeys(telp);
		tunggu();
		terms.click();
		btnPlaceOrder.click();
	}
	
	public String getPageCheckout() {
		return getTxtOrder.getText();
	}
	
	public void tunggu() {
		try {
			Thread.sleep(3000);
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
