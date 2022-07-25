package com.patient.pomrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientAppointmentHistoryPage {
	WebDriver driver;
	
	@FindBy(xpath="//table/tbody/tr/td[@class='hidden-xs']")
	private List<WebElement> listOfDoctorName;
	
	String verificationElement="//table/tbody/tr/td[@class='center' and contains(.,'%s')]/following-sibling::td[%s]";
	
	
	public PatientAppointmentHistoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	private WebElement replaceStringInXpath(String xpath,String replaceContains,String columnNumber) {
		String elementXpath = String.format(xpath,replaceContains,columnNumber);
		return driver.findElement(By.xpath(elementXpath));
	}
	
	public void clickOnCancel() {
		int size=listOfDoctorName.size();
		driver.findElement(By.xpath("//table/tbody/tr/td[@class='center' and contains(.,'"+size+"')]/following-sibling::td[7]/div/a")).click();
	}
	
//	public void cancelAppointment(String doctorNAme) {
//		
//		driver.findElement(By.xpath("//table/tbody/tr/td[.='"+doctorNAme+"']/following-sibling::td/div[@class='visible-md visible-lg hidden-sm hidden-xs']/a")).click();
//	}
	
	public String verificationDetails(String columnNumber) {
		 String size = String.valueOf(listOfDoctorName.size());
		WebElement element = replaceStringInXpath(verificationElement,size,columnNumber);
		return element.getText();
	}
	
//	public boolean verifyDoctorName(String doctorName) {
//		boolean flag=false;
//		;
//		//table/tbody/tr/td[@class='center' and contains(.,'size')]
//		for (int i=0;i<listOfDoctorName.size();i++) {
//			String docName = listOfDoctorName.get(i).getText();
//			if(docName.equals(doctorName))
//				flag=true;
//		}
//				return flag;
//		}
	
}
	
	

