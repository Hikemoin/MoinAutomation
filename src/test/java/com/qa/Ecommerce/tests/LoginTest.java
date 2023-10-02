package com.qa.Ecommerce.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Ecommerce.Commons.Commons;
import com.qa.Ecommerce.baseclass.BaseClass;
import com.qa.Ecommerce.constant.Constants;
import com.qa.Ecommerce.pages.AccountPage;
import com.qa.Ecommerce.pages.LoginPage;
import com.qa.Ecommerce.utilities.ExcelReading;
import com.qa.Ecommerce.utilities.PropertiesReading;

public class LoginTest extends BaseClass {

	@Test(priority = 1, dataProvider = "DataSupplier")
	public void loginwithValidCredential(String email, String password) {

		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		AccountPage accountPage = PageFactory.initElements(Constants.driver, AccountPage.class);
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		loginPage.pressLoginButton();
		String expected = PropertiesReading.setDataProperty("MyAccountExpected");
		String actual = accountPage.validLoginText();
		Assert.assertEquals(actual, expected);

	}

	@DataProvider(name = "DataSupplier")
	public Object[][] getData() {
		Object[][] data = ExcelReading.getTestDataFromExcel("login");
		return data;
	}

	@Test(priority = 2, enabled = true)
	public void loginWithInvalidCredential() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.setEmail(Commons.timestamp());
		loginPage.setPassword(PropertiesReading.setDataProperty("InvalidPassword"));
		loginPage.pressLoginButton();

		String expected = PropertiesReading.setDataProperty("Expected");
		String actual = loginPage.InvalidLoginText();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 3, enabled = true)
	public void LoginInvalidEmailWithValidPassword() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.setEmail(Commons.timestamp());
		loginPage.setPassword(PropertiesReading.setProperty("ValidPassword"));
		loginPage.pressLoginButton();
		String expected = PropertiesReading.setDataProperty("Expected");
		String actual = loginPage.InvalidLoginText();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 4, enabled = true)
	public void loginValidEmailWithInvalidPassword() {

		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.setEmail(PropertiesReading.setProperty("ValidEmail"));
		loginPage.setPassword(PropertiesReading.setDataProperty("InvalidPassword"));
		loginPage.pressLoginButton();

		String expected = PropertiesReading.setDataProperty("Expected");
		String actual = loginPage.InvalidLoginText();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 5, enabled = true)
	public void loginWithoutCredential() {

		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.pressLoginButton();

		String expected = PropertiesReading.setDataProperty("Expected");
		String actual = loginPage.InvalidLoginText();
		Assert.assertEquals(actual, expected);

	}

}
