package com.doctors.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class DoctorCommonPage {

	public DoctorCommonPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement more;

	@FindBy(xpath="//span[.=' Appointment History ']")
	private WebElement myappointment;

	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement logout;

	@FindBy(xpath="//span[.=' Dashboard ']")
	private WebElement dashboard;

	public void clickOnDashboard() {
		dashboard.click();
	}

	public void clickOnAppointmentHistory() {
		myappointment.click();
	}
	public void clickOnLogout(WebDriverUtility driverUtility) {
		more.click();
		driverUtility.customWaitToClick(logout, 500, 10);
		//logout.click();
	}

}
