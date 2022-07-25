package com.admin.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class EditDoctorSpecializationPage {
	WebDriver driver;
	
	public EditDoctorSpecializationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='doctorspecilization']")
	private WebElement editDocSpecializationTextField;
	
	@FindBy(xpath="//button[@name='submit']']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//p[contains(.,'Doctor Specialization updated successfully')]")
	private WebElement waitingCndn;
	
	public void editDoctorSpecialization(WebDriverUtility driverUtility,String docSpecialization,long timeouts) {
		editDocSpecializationTextField.sendKeys(docSpecialization);
		submitBtn.click();
		driverUtility.visibilityOfExplicitWait(driver, waitingCndn, timeouts);
	}
}
