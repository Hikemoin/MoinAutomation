package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//a[@title=\"My Account\"]")
	private WebElement myAccount;

	@FindBy(xpath = "//a[text()=\"Login\"]")
	private WebElement loginButton;

	public void myAccountDropdown() {
		myAccount.click();
	}

	public void loginButton() {
		loginButton.click();
	}
}
