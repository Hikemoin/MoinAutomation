package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage {

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(xpath = "//input[@value=\"Continue\"]")
	private WebElement button;

	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement warningText;

	public void alreadyRegisterEmail(String rEmail) {
		email.sendKeys(rEmail);
	}

	public void submitButton() {
		button.click();
	}

	public String InvaldEmailWarningText() {
		String actualText = warningText.getText();
		return actualText;
	}

}
