package org.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utilities.Constant;
import com.qa.opencart.utilities.Errors;

public class LoginTest extends BaseTest{

	@Test
	public void verifyURL()
	{
		String url=lp.getUrl();
		System.out.println("URL is ..."+url);
		Assert.assertEquals(url, Constant.LOGINPAGE_URL);
	}
	
	@Test
	public void verifyTitle()
	{
		String title=lp.getTilte();
		System.out.println("TITLE is ..."+title);
		Assert.assertEquals(title, Constant.LOGINPAGE_TITLE,Errors.TITLE_ERROR_MSG);
	}
	
	@Test
	public void verifyImageText()
	{
		Assert.assertTrue(lp.getImageText());
	}
	
	@Test
	public void verifyLinksCount()
	{
		int linksct=lp.getLinksCount();
		System.out.println("Total links found is...."+linksct);
		Assert.assertEquals(linksct, Constant.LINKS_COUNT);		
	}
	
	@Test
	public void verifyCreateAccountLink()
	{
		Assert.assertTrue(lp.getPasswordLink());
	}
	@Test
	public void verifyHelpLink()
	{
		Assert.assertTrue(lp.componentlink());
	}
	@Test(priority=2)
	public void EnterCredential()
	{
		ap=lp.signup(prop.getProperty("username"),prop.getProperty("password"));
		
	}
}
