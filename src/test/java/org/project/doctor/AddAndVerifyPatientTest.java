package org.project.doctor;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.doctors.pomrepository.AddPatientPage;
import com.doctors.pomrepository.DoctorCommonPage;
import com.doctors.pomrepository.DoctorDashboardPage;
import com.doctors.pomrepository.DoctorLoginPage;
import com.doctors.pomrepository.ManagePatientPage;
import com.doctors.pomrepository.ModuleCommonClickPage;
import com.project.genericUtility.BaseClass;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class AddAndVerifyPatientTest extends BaseClass {
//	static WebDriver driver;
//	static WebDriverUtility driverUtility;
//	
//	public static void main(String[] args) {
//		try 
	@Test
	public void addAndVerifyPatientTest()
	{
//		ExcelFileUtility excelUtility = new ExcelFileUtility();
//		PropertyFileUtilitiy propertiFileUtilitiy= new PropertyFileUtilitiy();
//		driverUtility= new WebDriverUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		
//		propertiFileUtilitiy.loadPropertyFile(IConstant.PROJECTPROPERTYFILEPATH);
//		String url=propertiFileUtilitiy.getData("url");
//		String browser=propertiFileUtilitiy.getData("browser");
//		String timeouts=propertiFileUtilitiy.getData("timeouts");
//		
//		long longTimeouts = javaUtility.convertToLong(timeouts);
//		
//		driver=driverUtility.openBrowser(browser);
//		driverUtility.maximizeWindow();
//		driverUtility.enterUrl(url);
//		driverUtility.implicitWait(longTimeouts);
//		
		ModuleCommonClickPage moduleCommonClickPage= new ModuleCommonClickPage(driver);
		moduleCommonClickPage.doctorModule();
		
		String sheetName ="loginData";
//		excelUtility.loadExcelData(IConstant.PROJECTEXCELFILEPATH);
		String username=excelFileUtility.getExcelData(sheetName, 3, 1);
		String password=excelFileUtility.getExcelData(sheetName, 3, 2);
		
		DoctorLoginPage doctorLoginPage= new DoctorLoginPage(driver);
		doctorLoginPage.setLogin(username, password);
		
		DoctorDashboardPage dashboardPage = new DoctorDashboardPage(driver);
		dashboardPage.clickOnPatient(driverUtility);
		dashboardPage.clickOnAddPatient();

		String sheetName1 = "patientDetails";
		String patName = excelFileUtility.getExcelData(sheetName1, 1, 1);
		long patContactNm = javaUtility.convertToLong(excelFileUtility.getExcelData(sheetName1, 2, 1));
		String patEmail = excelFileUtility.getExcelData(sheetName1, 3, 1)+javaUtility.randomNumber(30);
		String patGender = excelFileUtility.getExcelData(sheetName1, 4, 1);
		String patAddress = excelFileUtility.getExcelData(sheetName1, 5, 1);
		int patAge =Integer.parseInt(excelFileUtility.getExcelData(sheetName1, 6, 1));
		String patHistory = excelFileUtility.getExcelData(sheetName1, 7, 1);
		AddPatientPage addPatientPage= new  AddPatientPage(driver);
		
		addPatientPage.enterPatientDetails(patName, patContactNm, patEmail, patGender, patAddress, patAge, patHistory);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardPage.clickOnPatient(driverUtility);
		dashboardPage.clickOnManagePatient(driverUtility);
		
		ManagePatientPage managePatientPage = new ManagePatientPage(driver);
		String actualPatientName = managePatientPage.verifyPatientName();
		
		Assert.assertTrue(actualPatientName.equals(patName));
//		if(actualPatientName.equals(patName))
//			System.out.println("Test case pass");
//		else
//			System.out.println("Test case fail");
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		DoctorCommonPage commonPage= new  DoctorCommonPage(driver);
//		commonPage.clickOnLogout(driverUtility);
		}		
//		finally{
//		driverUtility.closeBrowser();	
//		}
}
