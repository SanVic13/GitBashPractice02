package org.project.integration;

import org.openqa.selenium.WebDriver;

import com.doctors.pomrepository.DoctorAppointmentHistoryPage;
import com.doctors.pomrepository.DoctorDashboardPage;
import com.doctors.pomrepository.DoctorLoginPage;
import com.patient.pomrepository.BookAppointmentPage;
import com.patient.pomrepository.CommonPage;
import com.patient.pomrepository.ModuleCommonClickPage;
import com.patient.pomrepository.PatientDashBoard;
import com.patient.pomrepository.PatientLoginPage;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class PatientAppointVerificationInDoctorAppointmentHistoryModuleTest {
	static WebDriver driver;
	static WebDriverUtility driverUtility;
	static ExcelFileUtility excelUtility;
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

			String sheetName ="loginData";
			String sheetName2 ="patient";
			
			String username = excelUtility.getExcelData(sheetName, 2, 1);
			String password = excelUtility.getExcelData(sheetName, 2, 2);
			
			String docSpecialization = excelUtility.getExcelData(sheetName2, 1, 1);
			String DocName = excelUtility.getExcelData(sheetName2, 2, 1);
			String date = excelUtility.getExcelData(sheetName2, 3, 1);
			String hours = excelUtility.getExcelData(sheetName2, 4, 1);
			String min = excelUtility.getExcelData(sheetName2, 5, 1);
			String maridian = excelUtility.getExcelData(sheetName2, 6, 1);
			String verifyPatientName = excelUtility.getExcelData("patientDetails", 1, 1);
			int intHours = javaUtility.stringToInt(hours);
			int intMin = javaUtility.stringToInt(min);

			driver=driverUtility.openBrowser(browser);
			driverUtility.maximizeWindow();
			driverUtility.enterUrl(url);
			driverUtility.implicitWait(longTimeouts);

			ModuleCommonClickPage moduleCommonPage= new ModuleCommonClickPage(driver);
			moduleCommonPage.patientModule();

			PatientLoginPage patientLoginPage=new PatientLoginPage(driver);
			patientLoginPage.setLogin(username, password);

			PatientDashBoard dashBoard=new  PatientDashBoard(driver);
			dashBoard.bookMyAppointment();

			BookAppointmentPage bookAppointment = new  BookAppointmentPage(driver);
			bookAppointment.bookAppointment(docSpecialization, DocName, date, intHours, intMin, maridian);

			driverUtility.handligAlertPopUp();
			
			CommonPage logOut=new CommonPage(driver);
			logOut.setLogout();
			
			ModuleCommonClickPage moduleCommonClickPage= new ModuleCommonClickPage(driver);
			moduleCommonClickPage.doctorModule();
			
			
			excelUtility.loadExcelData(IConstant.PROJECTEXCELFILEPATH);
			String docUsername=excelUtility.getExcelData(sheetName, 3, 1);
			String docPassword=excelUtility.getExcelData(sheetName, 3, 2);
			
			DoctorLoginPage doctorLoginPage= new DoctorLoginPage(driver);
			doctorLoginPage.setLogin(docUsername, docPassword);
			
			DoctorDashboardPage docDashboardPage= new DoctorDashboardPage(driver);
			docDashboardPage.clickOnMyAppointment();
			
			DoctorAppointmentHistoryPage appointmentHistoryPage= new DoctorAppointmentHistoryPage(driver);
			String patName = appointmentHistoryPage.verifyAppointmentHistory();
			
			if(patName.equals(verifyPatientName))
				System.out.println("TC pass");
			else
				System.out.println("TC fail");
		}
		finally {
			driverUtility.closeBrowser();
			excelUtility.closeWorkbook();
		}
	}
}
