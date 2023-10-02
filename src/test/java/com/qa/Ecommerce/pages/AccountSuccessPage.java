package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage {

	@FindBy(xpath = "//h1[text()=\"Your Account Has Been Created!\"]")
	private WebElement successRegText;

	public String successfullRegText() {
		String text = successRegText.getText();
		return text;
	}
}
