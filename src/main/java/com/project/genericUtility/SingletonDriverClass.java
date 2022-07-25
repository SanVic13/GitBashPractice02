package com.project.genericUtility;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class SingletonDriverClass {
	
	private static SingletonDriverClass singletonDriverClass;
	
	private SingletonDriverClass() {}

	public static SingletonDriverClass getInstance() {
		if(Objects.isNull(null))
			singletonDriverClass= new SingletonDriverClass();
		return singletonDriverClass;
	}
	
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	

}
