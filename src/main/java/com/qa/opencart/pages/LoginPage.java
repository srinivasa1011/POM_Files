package com.qa.opencart.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.opencart.utilities.ElementUtil;

public class LoginPage {
	private  By yourstoreimg=By.cssSelector("h1 a");
	private  By email=By.name("email");
	private  By password=By.name("password");
	private By linkscnt=By.tagName("a");
	private By submit=By.xpath("//input[@value='Login']");
	private By forgtpass=By.linkText("Forgotten Password");
	private By comp=By.linkText("Components");
    private WebDriver driver;
    private ElementUtil ele;
    private By register=By.linkText("Register");
    private By login=By.linkText("Login");
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		ele= new ElementUtil(driver);
	}
    //Returns the title of page
	public String getTilte()
	{
		return ele.getPageTitle();
	}
	//returns page URL
	public String getUrl()
	{
		return ele.getURLString();
	}
	//checks for  text image
	public Boolean getImageText()
	{
		return ele.isElementFound(yourstoreimg);
	}
	//login function
	public AccountsPage signup(String name, String pswrd)
	{
		ele.doSendKeys(email, name);
		ele.doSendKeys(password,pswrd);
		ele.doClick(submit);
		return new AccountsPage(driver);
	}
	//get total links count of login screen
	public int getLinksCount()
	{
		return ele.getElements(linkscnt).size();
	}
	//checks if component link  is seen
	public Boolean componentlink()
	{
		return ele.isElementFound(comp);
	}
	//checks if forgot passsword link is seen 
	public Boolean getPasswordLink()
	{
		return ele.isElementFound(forgtpass);
	}	
	public RegistrationPage naviageToRegistrationPage()
	{
	  ele.doClick(register);
	  //ele.doClick(login);
	  return new RegistrationPage(driver);
	}
	
}
