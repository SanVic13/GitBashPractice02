package com.project.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class contains all the WebDriver generic methods
 * @author sandeep
 *
 */
public final class WebDriverUtility {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	/**
	 * this method is used to open the browser
	 * @param browser
	 * @return
	 */
	public WebDriver openBrowser(String browser) {

		switch (browser) {
		case "chrome":WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;

		case "firefox": WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		case "ie": WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		break;

		default: System.out.println("Enter valid browser name"); 
		break;
		}

		return driver;
	}

	/**
	 * this method is used to maximize the window
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * this method is used to enter the url and maximize the window
	 * @param url
	 */
	public void enterUrl(String url) {
		driver.get(url);

	}
	
	/**
	 * this method is used for implicitly wait condition
	 * @param timeouts
	 */
	public void implicitWait(long timeouts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
	}

	/**
	 * waiting condition for visibility of element
	 * @param driver2
	 */
	public void visibilityOfExplicitWait(WebDriver driver,WebElement element,long timeouts) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * waiting condition for invisibility of element
	 * @param element
	 */
	public void invisibilityOfExplicitWait(WebDriver driver,WebElement element,long timeouts) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to mouse hover
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * this method is used to close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * this method contains close method
	 */
	public void closeTabs() {
		driver.close();
	}
	/**
	 * this method is used to switch frame by int index
	 * @param index
	 */
	public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to switch frame by String nameOrId
	 * @param nameOrId
	 */
	public void switchFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * this method is used to switch frame by WebElement
	 * @param element
	 */
	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to switch to default content
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to take screenshot
	 * @param fileDestination
	 */

	public void takeScreenshot(String fileDestination) {
		TakesScreenshot tss= (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dest = new File(fileDestination);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * this method is used to select the listbox by value
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element,String value) {
		new Select(element).selectByValue(value);
	}

	/**
	 * this method is used to select the listbox by visible text
	 * @param element
	 * @param visibleText
	 */
	public void selectByVisibleText(WebElement element,String visibleText) {
		new Select(element).selectByVisibleText(visibleText);
	}

	/**
	 * this method is used to select the listbox by index
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element,int index) {
		new Select(element).selectByIndex(index);
	}
	
	/**
	 * this method is used to handle the alert pop up
	 */
	public void handligAlertPopUp() {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is used for custom wait 
	 * @param element
	 * @param pollingTime
	 * @param timeDuration
	 */
	public void customWaitToClick(WebElement element,int pollingTime,long timeDuration) {
		int time=0;
		while(time<=timeDuration) {
			try {
				element.click();
				break;
			}
			catch(Exception e){
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				time++;
			}
		}
	}

}