package com.admin.pomrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;

public class ManageDoctorsPage {
	
	WebDriver driver;
	public ManageDoctorsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//td[@class='center']")
	private List<WebElement> tablerow;
	
	String xpath="//td[@class='center' and .='%s.']/following-sibling::td[.='%s']";
	
	String deleteXpath="//td[.='%s.']/following-sibling::td/div/a/i[@class='fa fa-times fa fa-white']";
	
	private WebElement stringToXpath(int row,String replace) {
		return driver.findElement(By.xpath(String.format(deleteXpath, String.valueOf(row),replace)));
	}
	
	private WebElement stringToXpath(int row) {
		return driver.findElement(By.xpath(String.format(xpath, String.valueOf(row))));
	}

	public String verifyDoctor(String docName) {
		return stringToXpath(tablerow.size(), docName).getText();
	}

	public void deleteDoctor(WebDriverUtility driverUtility,int row) {
		 stringToXpath(tablerow.size()).click();
		 driverUtility.handligAlertPopUp();
	}


}
