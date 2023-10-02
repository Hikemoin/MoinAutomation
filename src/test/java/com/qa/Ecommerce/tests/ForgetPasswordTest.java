package com.qa.Ecommerce.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Ecommerce.Commons.Commons;
import com.qa.Ecommerce.baseclass.BaseClass;
import com.qa.Ecommerce.constant.Constants;
import com.qa.Ecommerce.pages.ForgetPasswordPage;
import com.qa.Ecommerce.pages.LoginPage;
import com.qa.Ecommerce.utilities.PropertiesReading;

public class ForgetPasswordTest extends BaseClass {

	@Test(priority = 1)
	public void verifyForgetPassWorking() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		ForgetPasswordPage forgetPass = PageFactory.initElements(Constants.driver, ForgetPasswordPage.class);
		loginPage.forgetPasswordClick();
		forgetPass.alreadyRegisterEmail(PropertiesReading.setProperty("ValidEmail"));
		forgetPass.submitButton();

		String expected = PropertiesReading.setDataProperty("ForgetPasswordExpected");
		String actual = loginPage.sentForgetPassEmailText();
		assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void verifyForgetPasswordWithoutExistingAccount() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		ForgetPasswordPage forgetPass = PageFactory.initElements(Constants.driver, ForgetPasswordPage.class);
		loginPage.forgetPasswordClick();
		forgetPass.alreadyRegisterEmail(Commons.timestamp());
		forgetPass.submitButton();
		
		String expected = PropertiesReading.setDataProperty("ForgetPassworExpectedWarning");
		String actual = forgetPass.InvaldEmailWarningText();
		assertEquals(actual, expected);

	}

	@Test(priority = 3)
	public void verifyForgetPasswordFromLoginPageColoum() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		ForgetPasswordPage forgetPass = PageFactory.initElements(Constants.driver, ForgetPasswordPage.class);
		loginPage.forgetPassFromColButton();
		forgetPass.alreadyRegisterEmail(PropertiesReading.setProperty("ValidEmail"));
		forgetPass.submitButton();

		String expected = PropertiesReading.setDataProperty("ForgetPasswordExpected");
		String actual = loginPage.sentForgetPassEmailText();
        assertEquals(actual, expected);

	}

}
