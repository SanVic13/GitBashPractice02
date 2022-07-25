package com.admin.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditDoctorsDetailsPage {
	
	WebDriver driver;
	
	public EditDoctorsDetailsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	

	
}