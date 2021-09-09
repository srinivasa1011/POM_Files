package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil ele;
	private By section=By.cssSelector("div#content h2");
	private By searchtext=By.name("search");
	private By searchbutton=By.cssSelector("button.btn.btn-default.btn-lg");
	
	AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		ele=new ElementUtil(driver);
	}
	//get url of page
	public String getUrl()
	{
		return ele.getURLString();
	}
	//get title of page
	public String getTitle()
	{
		return ele.getPageTitle();
	}
	//get total count of sections
	public int SectionCount()
	{
		return ele.getElements(section).size();
	}
	//search any text 
	public ProductSearch searchText(String searchval)
	{
		ele.doSendKeys(searchtext, searchval);
		ele.doClick(searchbutton);
		return new ProductSearch(driver);
	}
	

}
