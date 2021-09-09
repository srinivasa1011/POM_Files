package com.qa.opencart.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.opencart.utilities.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil ele;
	Actions act;
	private By fname = By.xpath("//input[@name='firstname']");
	private By lname = By.xpath("//input[@name='lastname']");
	private By email = By.xpath("//input[@name='email']");
	private By telephone = By.xpath("//input[@name='telephone']");
	private By password = By.xpath("//input[@name='password']");
	private By cfmpassword = By.xpath("//input[@name='confirm']");
	private By agree = By.xpath("//input[@type='checkbox']");
	private By submit = By.xpath("//*[@type='submit']");
	private By verifyText = By.xpath("//div[@id='content']//h1");
	private By register=By.linkText("Register");
	RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		ele=new ElementUtil(driver);
		act=new Actions(driver);
	}
	public Boolean formEntry(String fn, String ln, String eml,String phn, String passwrd)  {
	{
		Random r=new Random();
		System.out.println("entering data...");
		act.sendKeys(driver.findElement(fname), fn).perform();
		act.sendKeys(driver.findElement(lname), ln).perform();
		act.sendKeys(driver.findElement(email), ""+ r.nextInt()+eml).perform();
		act.sendKeys(driver.findElement(telephone), phn).perform();
		act.sendKeys(driver.findElement(password), passwrd).perform();
		act.sendKeys(driver.findElement(cfmpassword),passwrd).perform();
		driver.findElement(agree).click();
		driver.findElement(submit).click();
		if (driver.findElement(verifyText).getText().contains("Created"))
		{
			System.out.println("account created");
			WebElement w=driver.findElement(By.linkText("My Account"));
			act.moveToElement(w).click().perform();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement w2=driver.findElement(By.linkText("Logout"));
			act.moveToElement(w2).click().perform();	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ele.doClick(register);
		    return true;
		}
		else
		{
			return false;
		}
	    
	}

	}

}
