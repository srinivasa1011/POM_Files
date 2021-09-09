package com.qa.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	 WebDriver driver;
	 JavascriptExecutor js;
	 
	public JavaScriptUtil(WebDriver driver)
	{
		this.driver=driver;
	    js=(JavascriptExecutor)driver;
	}
	
	public void scrollDown()
	{
	   js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollUp()
	{
	   js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

    public void scrollHeight(String height)
    {
    	js.executeScript("window.scrollTo(0,'"+height+"')");
    }
    public void scrollToElementLoc(WebElement ele)
    {
    	js.executeScript("arguments[0].scrollInToView(true);",ele);
    }
    public void flash(WebElement ele)
    {
    	String col=ele.getCssValue("backgroundColor");
    	for(int i=0;i<9;i++)
    	{
    		colorChange("rgb(0,255,0",ele);
    		colorChange(col,ele);
    	}
    }
    private void colorChange(String color, WebElement ele)
    {
    	js.executeScript("arguments[0].style.backgroundColor='"+color+"'",ele);
      try {
		Thread.sleep(20);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    public String getTitle()
    {
    	return js.executeScript("return document.title;").toString();
    }
    public String getInnerTextvalue()
    {
    	return js.executeScript("return document.documentElement.innerText").toString();
    }
    public void doClick(WebElement e)
    {
    	js.executeScript("arguments[0].click;",e);
    }
    public void doSendKeys(String id,String val)
    {
        js.executeScript("document.getElementById('"+id+"').value='"+val+"'");
    }
    public void refresh()
    {
        js.executeScript("history.go(0)");
    }
    public void borderElement(WebElement ele)
    {
        js.executeScript("arguments[0].style.border='3pxl solid red'",ele);
    }
    public void generateAlert(String msg)
    {
    	js.executeScript("alert('"+msg+"')");
    }
}
