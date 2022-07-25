package com.doctors.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class DoctorDashboardPage {

	public DoctorDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//p[@class='cl-effect-1']/a")
	private WebElement myAppointment;

	@FindBy(xpath="//p[@class='links cl-effect-1']/a")
	private WebElement myProfile;

	@FindBy(xpath="//span[.=' Manage Patient ']")
	private WebElement managePatients;

	@FindBy(xpath="//span[.=' Add Patient']")
	private WebElement addPatient;

	@FindBy(xpath="//span[.=' Patients ']")
	private WebElement patients;

	public void clickOnMyAppointment() {
		myAppointment.click();
	}

	public void clickOnMyProfile() {
		myProfile.click();
	}

	public void clickOnPatient(WebDriverUtility driverUtility) {
		driverUtility.customWaitToClick(patients, 500, 10);
	}
	public void clickOnAddPatient() {
		addPatient.click();
	}
	public void clickOnManagePatient(WebDriverUtility driverUtility) {
		driverUtility.customWaitToClick(managePatients, 500, 10);
	}

}
