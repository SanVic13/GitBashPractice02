package com.admin.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class AddDoctorPage {
	WebDriver driver;
	public AddDoctorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement docSpecialization;
	
	@FindBy(xpath="//input[@name='docname']")
	private WebElement doctorname;
	
	@FindBy(xpath="//textarea[@name='clinicaddress']")
	private WebElement doctorclinicaddress;
	
	@FindBy(xpath="//input[@name='docfees']")
	private WebElement doctorFee;
	
	@FindBy(xpath="//input[@name='doccontact']")
	private WebElement doctorcontactnm;
	
	@FindBy(xpath="//input[@name='docemail']")
	private WebElement doctoremail;
	
	@FindBy(xpath="//input[@name='npass']")
	private WebElement doctorpassword;
	
	@FindBy(xpath="//input[@name='cfpass']")
	private WebElement doctorconfirmpassword;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	
	public void addDoctor(WebDriverUtility driverUtility,String specialization,String doctorName,String clinicAddress,int Fee,long contactNm,String email,String password) {
		driverUtility.selectByValue(docSpecialization, specialization);
		doctorname.sendKeys(doctorName);
		doctorclinicaddress.sendKeys(clinicAddress);
		doctorFee.sendKeys(String.valueOf(Fee));
		doctorcontactnm.sendKeys(String.valueOf(contactNm));
		doctoremail.sendKeys(email);
		doctorpassword.sendKeys(password);
		doctorconfirmpassword.sendKeys(password);
		submitBtn.click();
		driverUtility.handligAlertPopUp();
	}
	
	
}
