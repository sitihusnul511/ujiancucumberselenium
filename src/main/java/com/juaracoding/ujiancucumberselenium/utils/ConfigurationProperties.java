package com.juaracoding.ujiancucumberselenium.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${user}")
	private String userName;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
		
	@Value("${txtTitleLoginPage}")
	private String txtTitleLoginPage;

	@Value("${txtMyAccount}")
	private String txtMyAccount;

	public String getBrowser() {
		return browser;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getTxtMyAccount() {
		return txtMyAccount;
	}

	public String getTxtTitleLoginPage() {
		return txtTitleLoginPage;
	}

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

	
}
