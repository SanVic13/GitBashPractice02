package com.admin.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardPage {

	public AdminDashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[.=' Users ']")
	private WebElement users;
	
	@FindBy(xpath="//span[.=' Dashboard ']")
	private WebElement dashboard;
	
	@FindBy(xpath="//span[.=' Doctors ']")
	private WebElement doctors;
	
	@FindBy(xpath="//span[.=' Doctor Specialization ']")
	private WebElement doctorSpecialization;
	
	@FindBy(xpath="//span[.=' Manage Doctors ']")
	private WebElement manageDoctors;
	
	public void clickOnDashboard() {
		dashboard.click();
	}
	
	public void clickOnDoctors() {
		doctors.click();
	}
	
	public void clickOnDoctorSpecialization() {
		doctorSpecialization.click();
	}
	
	public void clickOnManageDoctor() {
		manageDoctors.click();
	}
	
	public void clickOnUsers() {
		users.click();
	}
	
}
