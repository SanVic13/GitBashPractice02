package com.project.genericUtility;

import org.openqa.selenium.WebDriver;

import com.doctors.pomrepository.DoctorCommonPage;

public class InstanceClass {

	protected ExcelFileUtility excelFileUtility;
	protected JavaUtility  javaUtility = new JavaUtility();
	protected PropertyFileUtilitiy fileUtilitiy ;
	protected WebDriverUtility driverUtility;
	
	protected String browser;
	protected WebDriver driver;
	protected long timeouts;
	protected String url;
	
	protected DoctorCommonPage commonPage= new DoctorCommonPage(driver);
	
}
