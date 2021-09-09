package com.qa.opencart.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.opencart.factory.DriverFactory;

public class ElementUtil {
	WebDriver driver;
	JavaScriptUtil js;
	//WebDriverWait w=new WebDriverWait(driver,10);
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
		js=new JavaScriptUtil(driver);
	}
	//return web element
	public WebElement getElement(By ele)
	{		
		WebElement element= driver.findElement(ele);
		if(Boolean.parseBoolean(DriverFactory.highlight.trim()))
			js.flash(element);
		return element;
		
	}
	
	//return list of elements
	public List<WebElement> getElements(By ele)
	{
		return driver.findElements(ele);
	}
	//clicks any element
	public void doClick(By ele)
	{		
		getElement(ele).click();
	}
	//used to enter text value for web element 
	public void doSendKeys(By ele, String str)
	{
		WebElement e=getElement(ele);
		e.clear();
		e.sendKeys(str);
	}
	//checks if the element is displayed 
	public Boolean isElementFound(By ele)
	{
		return getElement(ele).isDisplayed();
	}
	//returns title of web page
	public String getPageTitle()
	{		    
		return driver.getTitle();
	}
	//returns current url of web page
	public String getURLString()
	{
		return driver.getCurrentUrl();
	}
	//returns text value
	public String doGetText(By ele)
	{
		return getElement(ele).getText();
	}
		
}
