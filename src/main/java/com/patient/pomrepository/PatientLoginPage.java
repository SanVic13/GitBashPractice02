package com.patient.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {

	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameTextField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(.,'Forgot Password')]")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(.,'Create an account')]")
	private WebElement createAnAccountLink;
	
	public PatientLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void setLogin(String username,String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginBtn.click();
}

	public void forgotPassword() {
		forgotPasswordLink.click();
	}
	
	public void createAnAccount() {
		createAnAccountLink.click();
	}
}
