package com.patient.pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class UserRegistrationPage {

	WebDriver driver;

	@FindBy(xpath="//input[@name='full_name']")
	private WebElement fullName;

	@FindBy(xpath="//input[@name='address']")
	private WebElement address;

	@FindBy(xpath="//input[@name='city']")
	private WebElement city;
	
	String genderXpath="//input[@id='rg-%s']/following-sibling::label[@for='rg-%s']";

	@FindBy(xpath="//input[@id='email']")
	private WebElement emailId;

	@FindBy(xpath="//input[@id='password']")
	private WebElement Password;

	@FindBy(xpath="//input[@id='password_again']")
	private WebElement passwordAgain;

	@FindBy(xpath="//a[contains(text(),'Log-in')]")
	private WebElement loginLink;

	@FindBy(xpath="//button[@id='submit']")
	private WebElement submit;

	public UserRegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	private WebElement stringToXpath(String replace) {
		return driver.findElement(By.xpath(String.format(genderXpath, replace,replace)));
	}
	
	public void setPresonalDetails(WebDriverUtility driverUtility,String name,String userAddress,String Usercity,String gender,String email,String password) {
		fullName.sendKeys(name);
		address.sendKeys(userAddress);
		city.sendKeys(Usercity);
		stringToXpath(gender).click();
		emailId.sendKeys(email);
		Password.sendKeys(password);
		passwordAgain.sendKeys(password);
		submit.click();
		driverUtility.handligAlertPopUp();
		loginLink.click();
	}




}
