package org.project.doctor;

import org.openqa.selenium.WebDriver;

import com.doctors.pomrepository.DoctorDashboardPage;
import com.doctors.pomrepository.DoctorLoginPage;
import com.doctors.pomrepository.EditDoctorDetailsPage;
import com.doctors.pomrepository.ModuleCommonClickPage;
import com.project.genericUtility.ExcelFileUtility;
import com.project.genericUtility.IConstant;
import com.project.genericUtility.JavaUtility;
import com.project.genericUtility.PropertyFileUtilitiy;
import com.project.genericUtility.WebDriverUtility;

public class EditDoctorsDetailsTest {
	static WebDriver driver;
	static WebDriverUtility driverUtility;
	
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
		
		String sheetName2 ="doctors";
		String docSpecialization = excelUtility.getExcelData(sheetName2, 1, 1);
		String docName = excelUtility.getExcelData(sheetName2, 2, 1);
		String docAddress = excelUtility.getExcelData(sheetName2, 3, 1);
		int docFee = Integer.parseInt(excelUtility.getExcelData(sheetName2, 4, 1));
		long docContactNm = javaUtility.convertToLong(excelUtility.getExcelData(sheetName2, 5, 1));
		//int docContactNm = Integer.parseInt(excelUtility.getExcelData(sheetName2, 5, 1));
		
		DoctorLoginPage doctorLoginPage= new DoctorLoginPage(driver);
		doctorLoginPage.setLogin(username, password);
		
		DoctorDashboardPage dashboardPage=new DoctorDashboardPage(driver);
		dashboardPage.clickOnMyProfile();
		
		EditDoctorDetailsPage detailsPage= new EditDoctorDetailsPage(driver);
		detailsPage.editDoctorsDetails(driverUtility, docSpecialization, docName, docAddress, docFee, docContactNm);
		
		String verifyDocName = detailsPage.verifyDoctorName();

		if(verifyDocName.equals(docName))
			System.out.println("pass");
		else
			System.out.println("fail");
		}
		finally {
			driverUtility.closeBrowser();	
		}
		
	}

}
