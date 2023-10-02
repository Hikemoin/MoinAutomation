package com.qa.Ecommerce.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.Ecommerce.Commons.Commons;
import com.qa.Ecommerce.baseclass.BaseClass;
import com.qa.Ecommerce.constant.Constants;
import com.qa.Ecommerce.pages.AccountSuccessPage;
import com.qa.Ecommerce.pages.LoginPage;
import com.qa.Ecommerce.pages.RegisterPage;
import com.qa.Ecommerce.utilities.PropertiesReading;

public class RegisterTest extends BaseClass {

	@Test(priority = 1)

	public void registrationWithMandatoryFields() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		RegisterPage registerPage = PageFactory.initElements(Constants.driver, RegisterPage.class);
		AccountSuccessPage successPage = PageFactory.initElements(Constants.driver, AccountSuccessPage.class);
		loginPage.goToRegister();
		registerPage.regFirstName(PropertiesReading.setDataProperty("FirstName"));
		registerPage.regLastName(PropertiesReading.setDataProperty("LastName"));
		registerPage.regemail(Commons.timestamp());
		registerPage.regTelephone(PropertiesReading.setDataProperty("Telephone"));
		Commons.scrollUpDown(200);
		registerPage.regPassword("sele@123");
		registerPage.regConfirmPassword("sele@123");
		registerPage.regCheckBox();
		registerPage.enterSubmitButton();

		String actual = successPage.successfullRegText();
		String extpected = PropertiesReading.setDataProperty("Registration_Expected");
		assertEquals(actual, extpected);

	}

	@Test(priority = 2)
	public void registerWithAllField() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		RegisterPage registerPage = PageFactory.initElements(Constants.driver, RegisterPage.class);
		AccountSuccessPage successPage = PageFactory.initElements(Constants.driver, AccountSuccessPage.class);
		loginPage.goToRegister();
		registerPage.regFirstName(PropertiesReading.setDataProperty("FirstName"));
		registerPage.regLastName(PropertiesReading.setDataProperty("LastName"));
		registerPage.regemail(Commons.timestamp());
		registerPage.regTelephone(PropertiesReading.setDataProperty("Telephone"));
		Commons.scrollUpDown(200);
		registerPage.regNewsCheckBox();
		registerPage.regPassword("sele@123");
		registerPage.regConfirmPassword("sele@123");
		registerPage.regCheckBox();
		registerPage.enterSubmitButton();

		String actual = successPage.successfullRegText();
		String extpected = PropertiesReading.setDataProperty("Registration_Expected");
		assertEquals(actual, extpected);

	}

	@Test(priority = 3)
	public void registerWithoutEnterAnyField() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		RegisterPage registerPage = PageFactory.initElements(Constants.driver, RegisterPage.class);

		loginPage.goToRegister();
		registerPage.enterSubmitButton();

		String actual = registerPage.declineRegText();
		String expected = PropertiesReading.setDataProperty("PrivacyPolicyWarning");
		assertEquals(actual, expected);

		String nameActual = registerPage.regFnameText();
		String nameExpected = PropertiesReading.setDataProperty("FirstNameWarning");
		assertEquals(nameActual, nameExpected);

		String lastNameActual = registerPage.regLnameText();
		String lastNameExpected = PropertiesReading.setDataProperty("LastNameWarning");
		assertEquals(lastNameActual, lastNameExpected);

		String emailActual = registerPage.regEmailText();
		String emailExpected = PropertiesReading.setDataProperty("EmailWarning");
		assertEquals(emailActual, emailExpected);

		String telephonActual = registerPage.regTelePhoneText();
		String telephonExpected = PropertiesReading.setDataProperty("TelephoneWarning");
		assertEquals(telephonActual, telephonExpected);

		String passActual = registerPage.regPassText();
		String passExpected = PropertiesReading.setDataProperty("PasswordWaring");
		assertEquals(passActual, passExpected);
	}

}
