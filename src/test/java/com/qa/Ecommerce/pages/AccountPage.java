package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/h3")
	private WebElement sucessText;

	public String validLoginText() {
		String successText = sucessText.getText();
		return successText;
	}

}
