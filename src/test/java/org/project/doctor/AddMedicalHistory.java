package org.project.doctor;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.doctors.pomrepository.AddPatientPage;
import com.doctors.pomrepository.DoctorCommonPage;
import com.doctors.pomrepository.DoctorDashboardPage;
import com.doctors.pomrepository.DoctorLoginPage;
import com.doctors.pomrepository.ManagePatientPage;
import com.doctors.pomrepository.ModuleCommonClickPage;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class AddMedicalHistory {
static WebDriverUtility driverUtility;
static WebDriver driver;

	public static void main(String[] args) {
		try 
		{
			
			ExcelFileUtility excelUtility = new ExcelFileUtility();
			PropertyFileUtilitiy propertiFileUtilitiy= new PropertyFileUtilitiy();
			driverUtility= new WebDriverUtility();
			JavaUtility javaUtility = new JavaUtility();

			propertiFileUtilitiy.loadPropertyFile(IConstant.PROJECTPROPERTYFILEPATH);
			String url=propertiFileUtilitiy.getData("url");
			String browser=propertiFileUtilitiy.getData("browser");
			String timeouts=propertiFileUtilitiy.getData("timeouts");

			long longTimeouts = javaUtility.convertToLong(timeouts);

			driver=driverUtility.openBrowser(browser);
			driverUtility.maximizeWindow();
			driverUtility.enterUrl(url);
			driverUtility.implicitWait(longTimeouts);

			ModuleCommonClickPage moduleCommonClickPage= new ModuleCommonClickPage(driver);
			moduleCommonClickPage.doctorModule();

			String sheetName ="loginData";
			excelUtility.loadExcelData(IConstant.PROJECTEXCELFILEPATH);
			String username=excelUtility.getExcelData(sheetName, 3, 1);
			String password=excelUtility.getExcelData(sheetName, 3, 2);
			
			DoctorLoginPage doctorLoginPage= new DoctorLoginPage(driver);
			doctorLoginPage.setLogin(username, password);
			
			DoctorDashboardPage dashboardPage = new DoctorDashboardPage(driver);
			dashboardPage.clickOnPatient(driverUtility);
			dashboardPage.clickOnAddPatient();

			String sheetName1 = "patientDetails";
			String patName = excelUtility.getExcelData(sheetName1, 1, 1);
			long patContactNm = javaUtility.convertToLong(excelUtility.getExcelData(sheetName1, 2, 1));
			String patEmail = excelUtility.getExcelData(sheetName1, 3, 1)+javaUtility.randomNumber(100);
			String patGender = excelUtility.getExcelData(sheetName1, 4, 1);
			String patAddress = excelUtility.getExcelData(sheetName1, 5, 1);
			int patAge =Integer.parseInt(excelUtility.getExcelData(sheetName1, 6, 1));
			String patHistory = excelUtility.getExcelData(sheetName1, 7, 1);
			AddPatientPage addPatientPage= new  AddPatientPage(driver);
			
			addPatientPage.enterPatientDetails(patName, patContactNm, patEmail, patGender, patAddress, patAge, patHistory);
			
			dashboardPage.clickOnPatient(driverUtility);
			dashboardPage.clickOnManagePatient(driverUtility);
			
			ManagePatientPage managePatientPage= new ManagePatientPage(driver);
			managePatientPage.clickOnEyeLookUpBtn();
			
			int lastIndex = managePatientPage.medicalHistroryLastIndex();
			
			if(Objects.isNull(lastIndex))
				lastIndex=0;
			
			String sheetMedical="medicalHistory";
			String bloodPressure = excelUtility.getExcelData(sheetMedical, 1, 1);
			String bloodSugar = excelUtility.getExcelData(sheetMedical, 2, 1);
			String bodyWeight = excelUtility.getExcelData(sheetMedical, 3, 1);
			String bodyTemp = excelUtility.getExcelData(sheetMedical, 4, 1);
			String prescription = excelUtility.getExcelData(sheetMedical, 5, 1);
			
			managePatientPage.addMedicalHistory(bloodPressure, bloodSugar, bodyWeight, bodyTemp, prescription);
			
			managePatientPage.clickOnEyeLookUpBtn();
			int verifyLastIndex = managePatientPage.medicalHistroryLastIndex();
			
			if(verifyLastIndex>lastIndex)
				System.out.println("TC pass");
			else
				System.out.println("TC fail");
			
			DoctorCommonPage commonPage= new DoctorCommonPage(driver);
			commonPage.clickOnLogout(driverUtility);
		}
		finally{
			driverUtility.closeBrowser();
		}
	}
}
