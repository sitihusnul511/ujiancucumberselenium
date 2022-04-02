package com.juaracoding.ujiancucumberselenium.utils;

public enum TestCases {

	T1("Testing Register Customer"),
	T2("Testing Login Customer"),
	T3("Testing Search Order"),
	T4("Testing Compare Order");
	
	private String testName;
	
	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
