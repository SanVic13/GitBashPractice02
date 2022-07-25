package com.doctors.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {

	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameTextField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement loginBtn;
	
	public DoctorLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void setLogin(String username,String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginBtn.click();
}

}
