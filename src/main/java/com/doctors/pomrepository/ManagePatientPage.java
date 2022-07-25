package com.doctors.pomrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class ManagePatientPage {
	WebDriver driver;
	public ManagePatientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	String nameXpath="//td[@class='center' and .='%s.']/following-sibling::td[@class='hidden-xs']";

	String eyeLookUpBtn="//td[@class='center' and .='%s.']/following-sibling::td[6]/a/i[@class='fa fa-eye']";

	String editBtn="//td[@class='center' and .='%s.']/following-sibling::td[6]/a/i[@class='fa fa-edit']";

	//String xpath="//td[@class='hidden-xs' and .='MansiR']/following-sibling::td[%s]";

	@FindBy(xpath="//td[@class='center']")
	private List<WebElement> tablecount;

	@FindBy(xpath="//table[@id='datatable']/tbody/tr/td[1]")
	private List<WebElement> medicalhistorytable;
	
	@FindBy(xpath="//button[@class='btn btn-primary waves-effect waves-light w-lg']")
	private WebElement addmedicalhistory;

	@FindBy(xpath="//h5[@id='exampleModalLabel']")
	private WebElement waitingCondition;

	@FindBy(xpath="//input[@name='bp']")
	private WebElement bloodpressure;

	@FindBy(xpath="//input[@name='bs']")
	private WebElement bloodsugar;

	@FindBy(xpath="//input[@name='weight']")
	private WebElement weight;

	@FindBy(xpath="//input[@name='temp']")
	private WebElement temprature;

	@FindBy(xpath="//textarea[@name='pres']")
	private WebElement Prescription;

	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;

	private WebElement stringToXpath(String element,String replace) {
		return driver.findElement(By.xpath(String.format(element, replace)));
	}

	public int medicalHistroryLastIndex() {
		return medicalhistorytable.size();
	}
	
	public void clickOnEyeLookUpBtn() {
		stringToXpath(eyeLookUpBtn, String.valueOf(getTableCount())).click();
	}

	public void addMedicalHistory(String bloodPressure,String bloodSugar,String bodyWeight,String bloodTemprature,String prescription) {
		addmedicalhistory.click();
		bloodpressure.sendKeys(bloodPressure);
		bloodsugar.sendKeys(bloodSugar);
		weight.sendKeys(bodyWeight);
		temprature.sendKeys(bloodTemprature);
		Prescription.sendKeys(prescription);
		submitBtn.click();
		driver.switchTo().alert().accept();

	}

	public void clickOnAddMedicalHistory(WebDriverUtility driverUtility,long timeouts) {
		addmedicalhistory.click();
		driverUtility.visibilityOfExplicitWait(driver, waitingCondition, timeouts);
	}

	public int getTableCount() {
		return tablecount.size();
	}

		public String verifyPatientName() {
			return stringToXpath(nameXpath, String.valueOf(getTableCount())).getText();
		}
	//	
	//	public void clickPatientUpdateButton(int index) {
	//		// stringToXpath(String.valueOf(index)).click();
	//	}
	//	
	//	public void clickPatientEditButton(int index) {
	//		// stringToXpath(String.valueOf(index)).click();
	//	}

}
