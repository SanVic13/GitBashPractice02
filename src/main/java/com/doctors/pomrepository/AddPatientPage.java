package com.doctors.pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class AddPatientPage {
	WebDriver driver;
	
	public AddPatientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h1[@class='mainTitle']")
	private WebElement waitingConditionAddPat;
	
	@FindBy(xpath="//input[@name='patname']")
	private WebElement patientname;
	
	@FindBy(xpath="//input[@name='patcontact']")
	private WebElement patientContactNm;
	
	@FindBy(xpath="//input[@name='patemail']")
	private WebElement patientEmail;
	
	String genderBoxXpath="//input[@name='gender' and @value ='%s']/following-sibling::label";
	
	@FindBy(xpath="//textarea[@name='pataddress']")
	private WebElement patientaddress;

	@FindBy(xpath="//input[@name='patage']")
	private WebElement patientage;
	
	@FindBy(xpath="//textarea[@name='medhis']")
	private WebElement patientmedicalhistory;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement addBtn;
	
	private WebElement stringToXpath(String replace) {
		return driver.findElement(By.xpath(String.format(genderBoxXpath, replace)));
	}
	
	public void enterPatientDetails(String patientName,long contactnumber,String patientMailId,String gender,String address,int age,String medicalHistory) {
		patientname.sendKeys(patientName);
		patientContactNm.sendKeys(String.valueOf(contactnumber));
		patientEmail.sendKeys(patientMailId);
		stringToXpath(gender.toLowerCase()).click();
		patientaddress.sendKeys(address);
		patientage.sendKeys(String.valueOf(age));
		patientmedicalhistory.sendKeys(medicalHistory);
		addBtn.click();
		//driverUtility.visibilityOfExplicitWait(driver, waitingConditionAddPat, timeouts);
	}
	public void waitTillPatientAdded(WebDriverUtility driverUtility,int pollingTime,long timeouts) {
		driverUtility.customWaitToClick(waitingConditionAddPat, pollingTime, timeouts);
	}
	
	
	
}
