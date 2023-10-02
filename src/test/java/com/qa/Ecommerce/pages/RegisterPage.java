package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(name = "email")
	private WebElement registrationEmail;

	@FindBy(name = "telephone")
	private WebElement telePhone;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "confirm")
	private WebElement confirmPassword;

	@FindBy(name = "agree")
	private WebElement checkBox;

	@FindBy(xpath = "//input[@value=\"Continue\"]")
	private WebElement registerDone;

	@FindBy(xpath = "//h1[text()=\"Your Account Has Been Created!\"]")
	private WebElement successText;

	@FindBy(xpath = "(//input[@name=\"newsletter\"])[1]")
	private WebElement newsCheckBox;

	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement warningText;

	@FindBy(xpath = "(//div[@class=\"text-danger\"])[1]")
	private WebElement warningTextName;

	@FindBy(xpath = "(//div[@class=\"text-danger\"])[2]")
	private WebElement warningTextLastName;

	@FindBy(xpath = "(//div[@class=\"text-danger\"])[3]")
	private WebElement warningTextEmail;

	@FindBy(xpath = "(//div[@class=\"text-danger\"])[4]")
	private WebElement warningTextTelephone;

	@FindBy(xpath = "(//div[@class=\"text-danger\"])[5]")
	private WebElement warningTextPassword;

	public void regFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	public void regLastName(String lName) {
		lastName.sendKeys(lName);
	}

	public void regemail(String email) {
		registrationEmail.sendKeys(email);
	}

	public void regTelephone(String tphone) {
		telePhone.sendKeys(tphone);
	}

	public void regPassword(String pass) {
		password.sendKeys(pass);
	}

	public void regConfirmPassword(String cPass) {
		confirmPassword.sendKeys(cPass);
	}

	public void regCheckBox() {
		checkBox.click();
	}

	public void enterSubmitButton() {
		registerDone.click();
	}

	public void regNewsCheckBox() {
		newsCheckBox.click();
	}

	public String declineRegText() {
		String text = warningText.getText();
		return text;
	}

	public String regFnameText() {
		String ftext = warningTextName.getText();
		return ftext;
	}

	public String regLnameText() {
		String ltext = warningTextLastName.getText();
		return ltext;
	}

	public String regEmailText() {
		String etext = warningTextEmail.getText();
		return etext;
	}

	public String regTelePhoneText() {
		String ltext = warningTextTelephone.getText();
		return ltext;
	}

	public String regPassText() {
		String ptext = warningTextPassword.getText();
		return ptext;
	}

}
