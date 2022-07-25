package com.project.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * this class contains generic methods of javascript executor 
 * @author sandeep
 *
 */
public final class JavaScriptExecutorUtility {

	private JavascriptExecutor jsExecutor;
	
	/**
	 * this method is used to initialize javascript executor
	 * @param driver
	 */
	public void initializeJavascriptExecutor(WebDriver driver) {
		jsExecutor=(JavascriptExecutor) driver;
	}
	
	/**
	 * this method is used to enter the url
	 * @param element
	 * @param url
	 */
	public void enterUrl(String url) {
		jsExecutor.executeScript("window.location=argument[0]",url);
	}
	
	/**
	 * this method is used to enter the data into the element
	 * @param element
	 * @param data
	 */
	public void enterDataIntoElement(WebElement element,String data) {
		jsExecutor.executeScript("argument[0].value=argument[1]",element,data);
	}
	
	/**
	 * this method is used to scroll to top or bottom of the page
	 * give strategy as top or bottom
	 * @param strategy
	 * @param yaxis
	 */
	public void scrollToTopOrBotton(String strategy,int yaxis) {
		String sign = strategy.equalsIgnoreCase("top") ? "-" : "+";
		jsExecutor.executeScript("window.scrollBy(0,"+ sign +"argument[0])",yaxis);
	}
	
	/**
	 * this method is used to sroll to particular element
	 * @param element
	 */
	public void scrollToParticularElement(WebElement element) {
		jsExecutor.executeScript("argument[0].scrollIntoView()",element);
	}
	
	/**
	 * this method is used to highlight the element
	 * @param element
	 */
	public void highlightElement(WebElement element) {
		jsExecutor.executeScript("argument[0].setAttribute('Style','border:5px solid black;')",element);
	}
}
