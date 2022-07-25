package com.doctors.pomrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class DoctorAppointmentHistoryPage {
	WebDriver driver;
	
	public DoctorAppointmentHistoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//table/tbody/tr")
	private List<WebElement> tableRow;
	
	@FindBy(xpath="//p[contains(.,'Appointment canceled')]")
	private WebElement waitingCondition;
	
	String cancelXpath= "//table/tbody/tr[%s]/td[8]";

	private String verify="//table/tbody/tr[%s]/td[2]";
	private String verifyCancel="//table/tbody/tr[%s]/td[contains(.,'Cancel by you')]";
	
	private WebElement StringToXpath(String element,String rowNum) {
		return driver.findElement(By.xpath(String.format(element, rowNum)));
	}
	
	public int getTableRowCount() {
		return tableRow.size();
	}
	
//	private WebElement StringToXpath(String rowNum) {
//		return driver.findElement(By.xpath(String.format(verify, rowNum)));
//	}
	
	public String verifyAppointmentHistory() {
		return StringToXpath(verify,String.valueOf(tableRow.size())).getText();
	}
	
	public void cancelAppointment(WebDriverUtility driverUtility,long timeouts) {
		StringToXpath(cancelXpath,String.valueOf(tableRow.size())).click();
		driverUtility.handligAlertPopUp();
		driverUtility.visibilityOfExplicitWait(driver, waitingCondition,timeouts );
	}
	
	public String verifyCancelledAppointment() {
		return StringToXpath(verifyCancel,String.valueOf(tableRow.size())).getText().trim();
	}
}
