package com.patient.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashBoard {

	@FindBy(xpath="//span[@class='fa-stack fa-2x']/following-sibling::p/a[@href='edit-profile.php']")
	private WebElement patientUpdateProfile;
	
	@FindBy(xpath="//span[@class='fa-stack fa-2x']/following-sibling::p/a[@href='book-appointment.php']")
	private WebElement patientBookMyAppointment;
	
	@FindBy(xpath="//span[@class='fa-stack fa-2x']/following-sibling::p/a[contains(text(),'View Appointment History')]")
	private WebElement patientMyAppointments;
	
	public PatientDashBoard(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void updateProfile() {
		patientUpdateProfile.click();	
	}
	
	public void bookMyAppointment() {
		patientBookMyAppointment.click();	
	}
	
	public void myAppointments() {
		patientMyAppointments.click();	
	}
}
