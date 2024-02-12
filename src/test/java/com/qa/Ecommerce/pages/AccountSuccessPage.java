package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage {

	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[1]/div/ng-include/div/div[1]/h3/span")
	private WebElement successRegText;

	public String successfullRegText() {
		String text = successRegText.getText();
		return text;
	}
}
