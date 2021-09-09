package com.qa.opencart.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtil;

public class ProductSearch {
	
	private WebDriver driver;
	private ElementUtil ele;
	private By resultcnt=By.cssSelector("div.caption h4 a");

	ProductSearch(WebDriver driver)
	{
		this.driver=driver;
		ele=new ElementUtil(driver);
	}
	
	//verify search results is returned
		public Boolean SearchResultStatus()
		{
			List<WebElement>li=ele.getElements(resultcnt);
			if(li.size()>0)
			return true;
			else 
		    return false;
		}
	//get total count of search results
	public List<String> SearchResultsList()
	{
		List<WebElement>li=ele.getElements(resultcnt);
		List<String>ar=new ArrayList<String>();
		System.out.println("total search count is "+li.size());
		for(WebElement e: li)
		{
			System.out.println(e.getText());
			ar.add(e.getText());
		}
		
		return ar;
	}
	//click searched text
		public ProductPage clickProduct(String str)
		{
			List<WebElement>li=ele.getElements(resultcnt);
			for(WebElement e: li)
			{
				System.out.print(e.getText());
				if(e.getText().equalsIgnoreCase(str));
				{
					e.click();
					break;
				}
			}
			return new ProductPage(driver);
		}
		
	

}
