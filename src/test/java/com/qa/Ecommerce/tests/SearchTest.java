package com.qa.Ecommerce.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Ecommerce.Commons.Commons;
import com.qa.Ecommerce.baseclass.BaseClass;
import com.qa.Ecommerce.constant.Constants;
import com.qa.Ecommerce.pages.AccountPage;
import com.qa.Ecommerce.pages.LoginPage;
import com.qa.Ecommerce.pages.SearchPage;
import com.qa.Ecommerce.utilities.PropertiesReading;

public class SearchTest extends BaseClass {

	@Test(priority = 1)
	public void searchWithExistingProduct() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		SearchPage searchPage = PageFactory.initElements(Constants.driver, SearchPage.class);
		loginPage.searchTextBox(PropertiesReading.setDataProperty("ValidProduct"));

		loginPage.searchButton();
		Commons.scrollUpDown(100);
		String expected = PropertiesReading.setDataProperty("ValidProduct");
		String actual = searchPage.SearchReasultText();
		assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void searchWithNonExistingProduct() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		SearchPage searchPage = PageFactory.initElements(Constants.driver, SearchPage.class);
		loginPage.searchTextBox(PropertiesReading.setDataProperty("InvalidProduct"));

		loginPage.searchButton();
		String expected = PropertiesReading.setDataProperty("SearchExpected");
		String actual = searchPage.invalidTextEnterResult();
		assertEquals(actual, expected);

	}

	@Test(priority = 3)
	public void searchProductAfterLogin() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		SearchPage searchPage = PageFactory.initElements(Constants.driver, SearchPage.class);
		AccountPage accountPage = PageFactory.initElements(Constants.driver, AccountPage.class);
		loginPage.setEmail(PropertiesReading.setProperty("ValidEmail"));
		loginPage.setPassword(PropertiesReading.setProperty("ValidPassword"));
		loginPage.pressLoginButton();
		String expected = PropertiesReading.setDataProperty("MyAccountExpected");
		String actual = accountPage.validLoginText();
		Assert.assertEquals(actual, expected);

		loginPage.searchTextBox(PropertiesReading.setDataProperty("InvalidProduct"));

		loginPage.searchButton();
		String expectedText = PropertiesReading.setDataProperty("SearchExpected");
		String actualText = searchPage.invalidTextEnterResult();
		assertEquals(actualText, expectedText);

	}

	@Test(priority = 4)
	public void searchProductWithoutProductName() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		SearchPage searchPage = PageFactory.initElements(Constants.driver, SearchPage.class);
		loginPage.searchButton();
		String expectedText = PropertiesReading.setDataProperty("SearchExpected");
		String actualText = searchPage.invalidTextEnterResult();
		assertEquals(actualText, expectedText);

	}

	@Test(priority = 5)
	public void searchBoxWithButtonAvailableonAllPage() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		SearchPage searchPage = PageFactory.initElements(Constants.driver, SearchPage.class);
		loginPage.searchTextBox(PropertiesReading.setDataProperty("InvalidProduct"));

		loginPage.searchButton();

		boolean expected = searchPage.searchBox();

		loginPage.searchTextBox(PropertiesReading.setDataProperty("InvalidProduct"));

		Constants.driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();

		boolean actual = loginPage.searchBox();
		assertEquals(actual, expected);
	}
}
