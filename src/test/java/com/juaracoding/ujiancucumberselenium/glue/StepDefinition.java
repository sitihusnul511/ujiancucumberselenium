package com.juaracoding.ujiancucumberselenium.glue;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.ujiancucumberselenium.config.AutomationFrameworkConfig;
import com.juaracoding.ujiancucumberselenium.drivers.DriverSingleton;
import com.juaracoding.ujiancucumberselenium.pages.LoginPage;
import com.juaracoding.ujiancucumberselenium.pages.OrderSearch;
import com.juaracoding.ujiancucumberselenium.pages.OrderWithCompare;
import com.juaracoding.ujiancucumberselenium.pages.RegisterPage;
import com.juaracoding.ujiancucumberselenium.utils.ConfigurationProperties;
import com.juaracoding.ujiancucumberselenium.utils.Constants;
import com.juaracoding.ujiancucumberselenium.utils.TestCases;
import com.juaracoding.ujiancucumberselenium.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private OrderSearch orderSearch;
	private OrderWithCompare orderWithCompare;
	
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReport.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();

		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResult(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			String screeshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:\n"+
					extentTest.addScreenCapture(screeshotPath));
		}
	}
	
	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void closeBrowser() {
		driver.quit();
	}
	
	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to "+Constants.URL);
	}
	
	@When("Customer melakukan registrasi")
	public void customer_melakukan_registrasi() {
		scroll();
		registerPage.submitRegister(configurationProperties.getUserName() ,configurationProperties.getEmail(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Customer melakukan registrasi");
	}
	
	@Then("Customer berhasil registrasi")
	public void customer_berhasil_registrasi() {
		//refresh
		assertEquals(configurationProperties.getTxtTitleLoginPage(), registerPage.getTxtTitleLoginPage());
		extentTest.log(LogStatus.PASS, "Customer berhasil registrasi");
	}
	
	@When("Customer klik login button")
	public void customer_klik_login_button() {
		loginPage.submitLogin(configurationProperties.getEmail(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Customer klik login button");
	}
	
	@Then("Customer berhasil login")
	public void customer_berhasil_login() {
		assertEquals(configurationProperties.getTxtMyAccount(), loginPage.getTxtMyAccount());
		extentTest.log(LogStatus.PASS, "Customer berhasil login");
	}
	
	@When("Customer masuk halaman product")
	public void customer_masuk_halaman_product() {
		orderSearch.goToMenuOrders();
		extentTest.log(LogStatus.PASS, "Customer masuk halaman product");
	}
	
	@Then("Customer mencari product")
	public void customer_mencari_product() {
		orderSearch.searchProduct(configurationProperties.getInputProduct(), configurationProperties.getWarna(), configurationProperties.getUkuran());
		extentTest.log(LogStatus.PASS, "Customer mencari product");
	}
	
	@Then("Customer melakukan checkout")
	public void customer_melakukan_checkout() {
		orderSearch.checkoutProduct(configurationProperties.getFirstName(), configurationProperties.getLastName(), configurationProperties.getCompany(), configurationProperties.getCountry(), configurationProperties.getAddress(), configurationProperties.getDetailAddress(), configurationProperties.getCity(), configurationProperties.getProvince(), configurationProperties.getPostcode(), configurationProperties.getPhone());
		extentTest.log(LogStatus.PASS, "Customer melakukan checkout");
	}
	
	@Then("Customer berhasil order")
	public void customer_berhasil_order() {
		assertEquals(configurationProperties.getGetTxtOrder(), orderSearch.getPageCheckout());
		extentTest.log(LogStatus.PASS, "Customer berhasil order");
	}
	
	@When("Customer kembali ke halaman utama")
	public void customer_kembali_ke_halaman_utama() {
		orderWithCompare.backToHomePage();
		extentTest.log(LogStatus.PASS, "Customer kembali ke halaman utama");
		
	}
	
	@When("Customer memilih product")
	public void customer_memilih_product() {
		orderWithCompare.pilihProduct1(1);
		extentTest.log(LogStatus.PASS, "Customer memilih product");
	}
	
	@And("Customer memilih product kedua")
	public void customer_memilih_product_kedua() {
		orderWithCompare.pilihProduct2(1);
		extentTest.log(LogStatus.PASS, "Customer memilih product kedua");
	}
	
	@And("Customer checkout product")
	public void customer_checkout_product() {
		orderWithCompare.checkout();
		extentTest.log(LogStatus.PASS, "Customer checkout product");
	}
	
	@Then("Customer berhasil order kedua")
	public void customer_berhasil_order_kedua() {
		assertEquals(configurationProperties.getGetTxtOrder(), orderWithCompare.getTxtOrder());
		extentTest.log(LogStatus.PASS, "Customer berhasil order kedua");
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