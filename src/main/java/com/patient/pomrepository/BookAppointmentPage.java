package com.patient.pomrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class BookAppointmentPage {
	WebDriverUtility driverUtility = new WebDriverUtility();

	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement doctorSpecialization;
	
	@FindBy(xpath="//select[@id='doctor']")
	private WebElement doctor;
	
	@FindBy(xpath="//select[@id='fees']")
	private WebElement consultancyFees;
	
	@FindBy(xpath="//input[@name='appdate']")
	private WebElement date;
	
	@FindBy(xpath="//input[@id='timepicker1']")
	private WebElement time;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitButton;
	
	public BookAppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * @param doctorSpecializationValue
	 * @param selectDoctorValue
	 * @param dateStrategy_yyyyMMdd
	 * @param hours
	 * @param min
	 * @param meridian
	 */
	public void bookAppointment(String doctorSpecializationValue,String selectDoctorValue,String dateStrategy_yyyyMMdd,int hours,int min,String meridian ) {
					
		driverUtility.selectByValue(doctorSpecialization, doctorSpecializationValue);
		driverUtility.selectByVisibleText(doctor, selectDoctorValue);
		date.sendKeys(dateStrategy_yyyyMMdd+Keys.ENTER);
		time.sendKeys(hours+min+meridian.toUpperCase()+Keys.TAB);;
		submitButton.click();
	}
	
}
