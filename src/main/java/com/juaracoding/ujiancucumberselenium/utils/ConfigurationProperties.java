package com.juaracoding.ujiancucumberselenium.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${username}")
	private String userName;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
		
	@Value("${txtTitleLoginPage}")
	private String txtTitleLoginPage;

	@Value("${txtMyAccount}")
	private String txtMyAccount;
	
	@Value("${inputProduct}")
	private String inputProduct;
	
	@Value("${warna}")
	private String warna;
	
	@Value("${ukuran}")
	private String ukuran;
	
	@Value("${firstName}")
	private String firstName;
	
	@Value("${lastName}")
	private String lastName;
	
	@Value("${company}")
	private String company;
	
	@Value("${country}")
	private String country;
	
	@Value("${address}")
	private String address;
	
	@Value("${detailAddress}")
	private String detailAddress;
	
	@Value("${city}")
	private String city;
	
	@Value("${province}")
	private String province;
	
	@Value("${postcode}")
	private String postcode;
	
	@Value("${phone}")
	private String phone;
	
	@Value("${getTxtOrder}")
	private String getTxtOrder;
	
	@Value("${pilih}")
	private String pilih;

	public String getBrowser() {
		return browser;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getTxtTitleLoginPage() {
		return txtTitleLoginPage;
	}
	
	public String getTxtMyAccount() {
		return txtMyAccount;
	}
	
	public String getInputProduct() {
		return inputProduct;
	}
	
	public String getWarna() {
		return warna;
	}
	
	public String getUkuran() {
		return ukuran;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getDetailAddress() {
		return detailAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getGetTxtOrder() {
		return getTxtOrder;
	}
	
	public String getPilih() {
		return pilih;
	}
	
//setter

	public void setTxtTitleLoginPage(String txtTitleLoginPage) {
		this.txtTitleLoginPage = txtTitleLoginPage;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setTxtMyAccount(String txtMyAccount) {
		this.txtMyAccount = txtMyAccount;
	}
	
	public void setInputProduct(String inputProduct) {
		this.inputProduct = inputProduct;
	}

	public void setWarna(String warna) {
		this.warna = warna;
	}
	
	public void setUkuran(String ukuran) {
		this.ukuran = ukuran;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setGetTxtOrder(String getTxtOrder) {
		this.getTxtOrder = getTxtOrder;
	}


	public void setPilih(String pilih) {
		this.pilih = pilih;
	}
	
	
}
