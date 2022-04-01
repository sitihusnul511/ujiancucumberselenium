package com.juaracoding.ujiancucumberselenium.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@Value("${user}")
	private String userName;
	
	@Value("${txtWelcome}")
	private String txtWelcome;
	
	@Value("${txtTitleLoginPage}")
	private String txtTitleLoginPage;

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

	public String getTxtWelcome() {
		return txtWelcome;
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

	public void setTxtWelcome(String txtWelcome) {
		this.txtWelcome = txtWelcome;
	}
	

	
}
