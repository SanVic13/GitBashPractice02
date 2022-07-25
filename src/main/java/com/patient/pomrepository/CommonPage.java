package com.patient.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.genericUtility.WebDriverUtility;


public class CommonPage {

	
	@FindBy(xpath="//span[@class='username']/i")
	private WebElement dropDown;
	
	@FindBy(xpath="//span[.=' Dashboard ']")
	private WebElement dashboard;

	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logoutBtn;
	
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void dashboard() {
		dashboard.click();
	}
	
	public void setLogout() {
		dropDown.click();
		logoutBtn.click();
	}
	
}
