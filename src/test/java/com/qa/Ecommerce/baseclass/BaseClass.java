package com.qa.Ecommerce.baseclass;

import com.qa.Ecommerce.Commons.Commons;
import com.qa.Ecommerce.constant.Constants;
import com.qa.Ecommerce.pages.HomePage;
import com.qa.Ecommerce.utilities.PropertiesReading;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends HomePage {

	@BeforeMethod
	public static void setUp() {
		Commons.openBrowser(PropertiesReading.setProperty("Browser"));
		Commons.maximizeBrowser();
		Commons.implicitWait(Commons.IMPLICIT_WAIT_TIME);
		Commons.launhUrl(PropertiesReading.setProperty("Url"));
		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		homePage.myAccountDropdown();
		homePage.loginButton();
		
	}

	@AfterMethod
	public void tearDown() {
		Commons.closerBrowser();
	}

}
