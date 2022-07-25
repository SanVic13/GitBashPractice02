package com.project.genericUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass extends InstanceClass {

	@BeforeSuite
	public void beforeSuiteMethod() {
		excelFileUtility= new ExcelFileUtility();
		fileUtilitiy= new PropertyFileUtilitiy();
		excelFileUtility.loadExcelData(IConstant.PROJECTEXCELFILEPATH);
		fileUtilitiy.loadPropertyFile(IConstant.PROJECTPROPERTYFILEPATH);
		browser=fileUtilitiy.getData("browser");
		timeouts=javaUtility.convertToLong(fileUtilitiy.getData("timeouts"));
		url=fileUtilitiy.getData("url");
	}
	
	@AfterSuite
	public void afterSuiteMethod() {
		excelFileUtility.closeWorkbook();
	}
	
	@BeforeTest
	public void beforeTestMethod() {
		driverUtility = new WebDriverUtility();
		driver=driverUtility.openBrowser(browser);
		SingletonDriverClass.getInstance().setDriver(driver);
		driverUtility.maximizeWindow();
		driverUtility.implicitWait(timeouts);
		driverUtility.enterUrl(url);
	}
	
	@AfterTest
	public void afterTestMethod() {
		driverUtility.closeBrowser();
	}
	
	@AfterMethod
	public void beforeMethod() {
		commonPage.clickOnLogout(driverUtility);
	}
}
