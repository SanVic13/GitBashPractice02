package com.patient.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModuleCommonClickPage {

	
	@FindBy(xpath="//h3[.='Patients']/following-sibling::div[@class='button']/span/a")
	private WebElement patientModuleButton;
	
	@FindBy(xpath="//h3[.='Doctors Login']/following-sibling::div[@class='button']/span/a")
	private WebElement doctorModuleButton;
	
	@FindBy(xpath="//h3[.='Admin Login']/following-sibling::div[@class='button']/span/a")
	private WebElement adminModulebutton;
	
	public ModuleCommonClickPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void patientModule() {
		patientModuleButton.click();
	}
	
	public void doctorModule() {
		doctorModuleButton.click();
	}
	
	public void adminModule() {
		adminModulebutton.click();
	}
}