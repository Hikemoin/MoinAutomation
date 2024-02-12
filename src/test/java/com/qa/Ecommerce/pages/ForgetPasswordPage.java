package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage {

	@FindBy(name = "tenancyName")
	private WebElement storeURL;

	@FindBy(name = "EmailAddress")
	private WebElement email;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/div/form/div[4]/button")
	private WebElement button;

	@FindBy(xpath = "/html/body/div[6]/div/div[2]")
	private WebElement warningText;

	public void existingStore(String storeName) {
		storeURL.sendKeys(storeName);
	}

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
