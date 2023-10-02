package com.qa.Ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	@FindBy(xpath = "//a[text()=\"iPhone\"]")
	private WebElement searchResulte;

	@FindBy(xpath = "//p[text()=\"There is no product that matches the search criteria.\"]")
	private WebElement invalidText;

	@FindBy(xpath = "//div[@id=\"search\"]")
	private WebElement searchBox;

	public boolean searchBox() {
		return searchBox.isDisplayed();

	}

	public String SearchReasultText() {
		String actualText = searchResulte.getText();
		return actualText;
	}

	public String invalidTextEnterResult() {
		String actualText = invalidText.getText();
		return actualText;
	}
}
