package org.project.patients;

import org.openqa.selenium.WebDriver;

import com.patient.pomrepository.CommonPage;
import com.patient.pomrepository.EditProfilePage;
import com.patient.pomrepository.ModuleCommonClickPage;
import com.patient.pomrepository.PatientDashBoard;
import com.patient.pomrepository.PatientLoginPage;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class EditPatientProfileTest {
	static WebDriverUtility driverUtility;
	static WebDriver driver;
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
	
	String sheet="loginData";
	String username = excelUtility.getExcelData(sheet, 2, 1);
	String password = excelUtility.getExcelData(sheet, 2, 2);
	
	String sheet1="patientDetails";
	String patientName=excelUtility.getExcelData(sheet1, 1, 1);
	String address=excelUtility.getExcelData(sheet1, 5, 1);
	String city=excelUtility.getExcelData(sheet1, 8, 1);
	String gender=excelUtility.getExcelData(sheet1, 4, 1);
	excelUtility.closeWorkbook();
	
	driver=driverUtility.openBrowser(browser);
	driverUtility.maximizeWindow();
	driverUtility.enterUrl(url);
	driverUtility.implicitWait(longTimeouts);
	
	ModuleCommonClickPage moduleCommonPage= new ModuleCommonClickPage(driver);
	moduleCommonPage.patientModule();
	
	PatientLoginPage patientLoginPage=new PatientLoginPage(driver);
	patientLoginPage.setLogin(username, password);
	
	PatientDashBoard dashboard=new PatientDashBoard(driver);
	dashboard.updateProfile();
	
	EditProfilePage editProfile = new EditProfilePage(driver);
	editProfile.editProfile(driverUtility,patientName, address, city, gender);
	
	editProfile.waitingCondition(driverUtility, longTimeouts);
	String verifyUserName = editProfile.getProfileName();
	
	if(verifyUserName.contains(patientName))
		System.out.println("profile updated with valid data");
	else
		System.out.println("profile updation with proper data is failed");
	
	CommonPage common = new CommonPage(driver);
	common.setLogout();
	}
	finally {
		driverUtility.closeBrowser();
	}
}
}