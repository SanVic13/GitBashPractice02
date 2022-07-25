package org.project.patients;

import org.openqa.selenium.WebDriver;

import com.doctors.pomrepository.ModuleCommonClickPage;
import com.patient.pomrepository.CommonPage;
import com.patient.pomrepository.PatientLoginPage;
import com.patient.pomrepository.UserRegistrationPage;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class CreateNewPatientTest {
	static WebDriverUtility driverUtility;
	static ExcelFileUtility excelUtility;
	static WebDriver driver;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			excelUtility= new ExcelFileUtility();
			PropertyFileUtilitiy properties= new PropertyFileUtilitiy();
			driverUtility= new WebDriverUtility();
			JavaUtility javaUtility = new JavaUtility();
			
			properties.loadPropertyFile(IConstant.PROJECTPROPERTYFILEPATH);
			excelUtility.loadExcelData(IConstant.PROJECTEXCELFILEPATH);
			
			String url = properties.getData("url");
			String timeouts = properties.getData("timeouts");
			String browser = properties.getData("browser");
			long longTimeouts = javaUtility.convertToLong(timeouts);
			
			driver=driverUtility.openBrowser(browser);
			driverUtility.enterUrl(url);
			driverUtility.maximizeWindow();
			driverUtility.implicitWait(longTimeouts);
			
			String sheetName="patientDetails";
			String patName = excelUtility.getExcelData(sheetName, 1, 1);
			String patAddress = excelUtility.getExcelData(sheetName, 5, 1);
			String patCity = excelUtility.getExcelData(sheetName, 8, 1);
			String patGender = excelUtility.getExcelData(sheetName, 4, 1);
			String patEmail = excelUtility.getExcelData(sheetName, 3, 1);
			String patPassword = excelUtility.getExcelData(sheetName, 9, 1);
			
			ModuleCommonClickPage commonClickPage= new ModuleCommonClickPage(driver);
			commonClickPage.patientModule();
			
			PatientLoginPage loginPage=new  PatientLoginPage(driver);
			loginPage.createAnAccount();
			
			UserRegistrationPage userRegistrationPage= new  UserRegistrationPage(driver);
			userRegistrationPage.setPresonalDetails(driverUtility, patName, patAddress, patCity, patGender, patEmail, patPassword);
		
		}
		finally {
			driverUtility.closeBrowser();
			excelUtility.closeWorkbook();
		}
	}
}
