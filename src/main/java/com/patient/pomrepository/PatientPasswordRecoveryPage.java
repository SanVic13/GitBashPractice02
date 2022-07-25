package com.patient.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPasswordRecoveryPage {

	@FindBy(xpath="//input[@name='fullname']")
	private WebElement registeredFullName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement registeredEmail;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement resetButton;
	
	@FindBy(xpath="//a[contains(text(),'Log-in')]")
	private WebElement loginBtn;
	
	public PatientPasswordRecoveryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void setPasswordRecover(String fullName,String email) {
		registeredFullName.sendKeys(fullName);
		registeredEmail.sendKeys(email);
		resetButton.click();
	}
	
	public void loginPage() {
		loginBtn.click();
	}
}
