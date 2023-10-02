package com.qa.Ecommerce.utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Ecommerce.constant.Constants;

public class WaitUtility {

	public static void customExplicitwait(WebElement element, int time) {
		WebDriverWait customWait = new WebDriverWait(Constants.driver, Duration.ofSeconds(time));
		customWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
}
