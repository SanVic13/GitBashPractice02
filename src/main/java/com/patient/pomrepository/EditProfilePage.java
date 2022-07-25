package com.patient.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.JavaScriptExecutorUtility;
import com.project.genericUtility.WebDriverUtility;

public class EditProfilePage {
	WebDriver driver;
	JavaScriptExecutorUtility jsExecutor= new JavaScriptExecutorUtility();
	
	@FindBy(xpath="//input[@name='fname']")
	private WebElement userName;
	
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath="//select[@name='gender']")
	private WebElement gender;
	
	@FindBy(xpath="//input[@name='uemail']")
	private WebElement userEmail;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement update;
	
	@FindBy(xpath="//div[@class='panel-body']/h4")
	private WebElement profileName;
	
	@FindBy(xpath="//h5[contains(.,'Your Profile updated Successfully')]")
	private WebElement waitingCndn;
	
	public EditProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void waitingCondition(WebDriverUtility driverUtility,long timeouts) {
		driverUtility.visibilityOfExplicitWait(driver, waitingCndn, timeouts);
	}
	
	
	public void editProfile(WebDriverUtility driverUtility,String name,String userAddress,String userCity,String userGender) {
		userName.clear();
		userName.sendKeys(name);
		address.clear();
		address.sendKeys(userAddress);
		city.clear();
		city.sendKeys(userCity);
		driverUtility.selectByValue(gender, userGender);
		update.click();
	}
	
	public String getProfileName() {
		return profileName.getText().split(" ")[0];
	}
	
}
