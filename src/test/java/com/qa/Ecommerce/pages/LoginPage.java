package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//Objects
	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@value=\"Login\"]")
	private WebElement loginButtonField;

	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement lnvalidCredentialText;

	@FindBy(xpath = "//a[contains(text(),\"Continue\")]")
	private WebElement register;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgetPass;
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	private WebElement forgetPassSuccessText;

	@FindBy(xpath = "(//a[contains(text(),\"Forgotten Password\")])[2]")
	private WebElement forgetPassColButton;

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@class=\"btn btn-default btn-lg\"]")
	private WebElement SearchButtopn;
	@FindBy(xpath = "//div[@id=\"search\"]")
	private WebElement SearchBox;

	// method of the Objects
	public void setEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void setPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void pressLoginButton() {
		loginButtonField.click();
	}

	public String InvalidLoginText() {
		String warningText = lnvalidCredentialText.getText();
		return warningText;
	}

	public void goToRegister() {
		register.click();
	}

	public void forgetPasswordClick() {
		forgetPass.click();
	}

	public String sentForgetPassEmailText() {
		String forgetPasstext = forgetPassSuccessText.getText();
		return forgetPasstext;
	}

	public void forgetPassFromColButton() {
		forgetPassColButton.click();
	}

	public void searchTextBox(String text) {
		searchBox.sendKeys(text);
	}

	public void searchButton() {
		SearchButtopn.click();
	}

	public boolean searchBox() {
		return SearchBox.isDisplayed();

	}
}
