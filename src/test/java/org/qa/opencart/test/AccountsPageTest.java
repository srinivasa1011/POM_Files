package org.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utilities.Constant;
import com.qa.opencart.utilities.ExcelUtil;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void setu()
	{
		ap=lp.signup(prop.getProperty("username"),prop.getProperty("password"));	
	}
	@Test
	public void verifyTitle()
	{
		String title=ap.getTitle();
		System.out.println("TITLE IS ..."+title);
		Assert.assertEquals(title, Constant.ACCOUNTS_TITLE);
	}
	@Test
	public void VerifyUrl()
	{
		String url=ap.getUrl();
		System.out.println("URL IS ..."+url);
		Assert.assertEquals(url, Constant.ACCOUNTS_URL);
	}
	@Test
	public void VerifyTotalSectionCount()
	{
		int sc=ap.SectionCount();
		System.out.println("Total section count is ..."+sc);
		Assert.assertEquals(sc,Constant.SECTIONCOUNT);
	}
	/*@DataProvider
	public Object[][] searchTexts()
	{
		return new Object[][] {
			{"mac"},
			{"macbook"},
			{"apple"}
		};
	}*/
	@DataProvider
	public Object[][] searchTexts()
	{
	   return ExcelUtil.getDatafromExcel("Product_List");
	}
	@Test(priority=4, dataProvider="searchTexts")
	public void doSearch(String searchval)
	{
		ps=ap.searchText(searchval);
		Assert.assertTrue(ps.SearchResultStatus());
	}	
	@Test(priority=5)
	public void SearchResult()
	{
		ps=ap.searchText("mac");
		Assert.assertEquals(ps.SearchResultsList(),Constant.PRODUCT_LIST);
	}
	@Test(priority=5)
	public void clickProduct()
	{
		ps=ap.searchText("MacBook Air");
		prodpage=ps.clickProduct("MacBook Air");
	}
}
