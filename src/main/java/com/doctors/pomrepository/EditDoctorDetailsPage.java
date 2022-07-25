package com.doctors.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class EditDoctorDetailsPage {
	WebDriver driver;
	
	public EditDoctorDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//select[@class='form-control']")
	private WebElement doctorSpecialization;
	
	@FindBy(xpath="//input[@name='docname']")
	private WebElement doctorName;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	private WebElement doctorClinicAddress;
	
	@FindBy(xpath="//input[@name='docfees']")
	private WebElement doctorConsultancyfees;
	
	@FindBy(xpath="//input[@name='doccontact']")
	private WebElement doctorContactNo;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement updateBtn;
	
	@FindBy(xpath="//div[@class='panel-body']/h4")
	private WebElement verifydocprofile;
	
	public String verifyDoctorName() {
		return verifydocprofile.getText().split("'")[0];
	}
	
	public void editDoctorsDetails(WebDriverUtility driverUtility,String value,String docName,String address,int fees,long phnNumber) {
		driverUtility.selectByValue(doctorSpecialization, value);
		doctorName.clear();
		doctorName.sendKeys(docName);
		doctorClinicAddress.clear();
		doctorClinicAddress.sendKeys(address);
		doctorConsultancyfees.clear();
		doctorConsultancyfees.sendKeys(String.valueOf(fees));
		doctorContactNo.clear();
		doctorContactNo.sendKeys(String.valueOf(phnNumber));
		updateBtn.click();
		driverUtility.handligAlertPopUp();
	}
	
}
