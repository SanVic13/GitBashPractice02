package org.project.doctor;

import org.openqa.selenium.WebDriver;

import com.doctors.pomrepository.AddPatientPage;
import com.doctors.pomrepository.DoctorAppointmentHistoryPage;
import com.doctors.pomrepository.DoctorCommonPage;
import com.doctors.pomrepository.DoctorDashboardPage;
import com.doctors.pomrepository.DoctorLoginPage;
import com.doctors.pomrepository.ModuleCommonClickPage;
import com.patient.pomrepository.BookAppointmentPage;
import com.patient.pomrepository.CommonPage;
import com.patient.pomrepository.PatientDashBoard;
import com.patient.pomrepository.PatientLoginPage;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class CancelAppointmentTest {
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
			
			String loginSheet="loginData";
			String patientSheet="patient";
			String username = excelUtility.getExcelData(loginSheet, 2, 1);
			String password = excelUtility.getExcelData(loginSheet, 2, 2);
			String docSpecialization = excelUtility.getExcelData(patientSheet, 1, 1);
			String DocName = excelUtility.getExcelData(patientSheet, 2, 1);
			String date = excelUtility.getExcelData(patientSheet, 3, 1);
			String hours = excelUtility.getExcelData(patientSheet, 4, 1);
			String min = excelUtility.getExcelData(patientSheet, 5, 1);
			String maridian = excelUtility.getExcelData(patientSheet, 6, 1);

			int intHours = javaUtility.stringToInt(hours);
			int intMin = javaUtility.stringToInt(hours);


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
			
			 	
			moduleCommonPage.doctorModule();
		
		String sheetName ="loginData";
		excelUtility.loadExcelData(IConstant.PROJECTEXCELFILEPATH);
		String docUsername=excelUtility.getExcelData(sheetName, 3, 1);
		String docPassword=excelUtility.getExcelData(sheetName, 3, 2);
		
		DoctorLoginPage doctorLoginPage= new DoctorLoginPage(driver);
		doctorLoginPage.setLogin(docUsername, docPassword);
		
		DoctorDashboardPage dashboardPage = new DoctorDashboardPage(driver);
		dashboardPage.clickOnMyAppointment();
		
		DoctorAppointmentHistoryPage appointmentHistoryPage= new DoctorAppointmentHistoryPage(driver);
		appointmentHistoryPage.cancelAppointment(driverUtility, longTimeouts);
		
		String status=appointmentHistoryPage.verifyCancelledAppointment();
		
		if(status.equals("Cancel by you"))
			System.out.println("TC pass");
		else
			System.out.println("TC fail");
		
		DoctorCommonPage commonPage= new DoctorCommonPage(driver);
	
		commonPage.clickOnLogout(driverUtility);
		}
		finally {
			driverUtility.closeBrowser();
		}
}
}