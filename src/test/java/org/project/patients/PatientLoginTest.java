package org.project.patients;

import org.openqa.selenium.WebDriver;

import com.patient.pomrepository.CommonPage;
import com.patient.pomrepository.ModuleCommonClickPage;
import com.patient.pomrepository.PatientLoginPage;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class PatientLoginTest {
	
	static WebDriver driver;
	static WebDriverUtility driverUtility;
	
	public static void main(String[] args) {
		try {
			
		ExcelFileUtility excelUtility= new ExcelFileUtility();
		PropertyFileUtilitiy properties= new PropertyFileUtilitiy();
		driverUtility= new WebDriverUtility();
		JavaUtility javaUtility = new JavaUtility();
		
		properties.loadPropertyFile(IConstant.PROJECTPROPERTYFILEPATH);
		excelUtility.loadExcelData(IConstant.PROJECTEXCELFILEPATH);
		
		String url = properties.getData("url");
		String timeouts = properties.getData("timeouts");
		String browser = properties.getData("browser");
		long longTimeouts = javaUtility.convertToLong(timeouts);
		
		String username = excelUtility.getExcelData("loginData", 2, 1);
		String password = excelUtility.getExcelData("loginData", 2, 2);
		excelUtility.closeWorkbook();
		
		driver=driverUtility.openBrowser(browser);
		driverUtility.maximizeWindow();
		driverUtility.enterUrl(url);
		driverUtility.implicitWait(longTimeouts);
		
		ModuleCommonClickPage moduleCommonPage= new ModuleCommonClickPage(driver);
		moduleCommonPage.patientModule();
		
		PatientLoginPage patientLoginPage=new PatientLoginPage(driver);
		patientLoginPage.setLogin(username, password);
		
		
		
		
		
		CommonPage logOut=new CommonPage(driver);
		logOut.setLogout();
		
		}
		finally {
			driverUtility.closeBrowser();
		}
	}

}
