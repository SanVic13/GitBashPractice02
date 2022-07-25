package com.admin.pomrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class AddDoctorSpecializationPage {

	WebDriver driver;
	
	public AddDoctorSpecializationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='doctorspecilization']")
	private WebElement docSpecialization;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//td[@class='center']")
	private List<WebElement> tablerow;
	
	@FindBy(xpath="//p[contains(.,'Doctor Specialization added successfully')]")
	private WebElement waitingCondition;
	
	@FindBy(xpath="//p[contains(.,'data deleted')]")
	private WebElement datadelete;
	
	private String xpath="//td[@class='center' and .='%s.']/following-sibling::td[1]";
	
	private String editXpath="//td[@class='center' and .='%s.']/following-sibling::td[4]//i[@class='fa fa-pencil']";
	
	private String deleteXpath="//td[@class='center' and .='26.']/following-sibling::td/div/a[@class='btn btn-transparent btn-xs tooltips']";
	
	private WebElement stringToXpath(String elementXpath,String replace) {
		return driver.findElement(By.xpath(String.format(elementXpath, replace)));
	}
	
	public void clickOnDeleteButton(WebDriverUtility driverUtility,int index) {
		stringToXpath(xpath, String.valueOf(tablerow.size())).click();
		driverUtility.handligAlertPopUp();
	}
	
	public String verifyDeleteOrganization() {
		return datadelete.getText().trim();
	}
	
	public void clickOnEditButton() {
		stringToXpath(editXpath, String.valueOf(tablerow.size())).click();
	}
	public String verifySpecialization() {
		return stringToXpath(xpath,String.valueOf(tablerow.size())).getText();
	}
	
	public void addDoctorSpecialization(WebDriverUtility driverUtility,String doctorSpecialization,long timeouts) {
		docSpecialization.sendKeys(doctorSpecialization);
		submitButton.click();
		driverUtility.visibilityOfExplicitWait(driver, waitingCondition, timeouts);
	}
	
}
