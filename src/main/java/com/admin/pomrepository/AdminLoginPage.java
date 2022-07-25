package com.admin.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameTextField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement loginButton;
	
	public void setLogin(String username,String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	
}
