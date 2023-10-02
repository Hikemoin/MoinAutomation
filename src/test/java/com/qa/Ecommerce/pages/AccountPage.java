package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

	@FindBy(xpath = "//h2[text()=\"My Account\"]")
	private WebElement sucessText;

	public String validLoginText() {
		String successText = sucessText.getText();
		return successText;
	}

}
