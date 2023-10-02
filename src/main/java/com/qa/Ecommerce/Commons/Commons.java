package com.qa.Ecommerce.Commons;

import com.qa.Ecommerce.constant.*;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commons {
	/**
	 * It will set implicitly wait by using this variable
	 * 
	 */
	public static final int IMPLICIT_WAIT_TIME = 10;

	/**
	 * It will open Web Browser Specified By User of this method.
	 * 
	 * @param browser_Name {@code String}
	 * @return {@code Void}
	 */
	public static void openBrowser(String browser_Name) {
		switch (browser_Name) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "Safari":
			WebDriverManager.safaridriver().setup();
			Constants.driver = new SafariDriver();
			break;
		case "MsEdge":
			WebDriverManager.edgedriver().setup();
			Constants.driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Broswer Name::" + browser_Name);
			break;
		}
	}

	/**
	 * It will maximize opned window
	 */
	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();

	}

	/**
	 * It will provid implicit time
	 * 
	 * @param time {@code int}
	 */
	public static void implicitWait(int time) {
		Constants.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/**
	 * It will launchUrl which is provided by user
	 * 
	 * @param Url {@code String}
	 */
	public static void launhUrl(String Url) {
		Constants.driver.get(Url);
	}

	/**
	 * It will close Current browser opened by webdriver
	 */
	public static void closerBrowser() {
		Constants.driver.close();
	}

	/**
	 * It will close all Currently Broser opened by webdriver
	 */
	public static void quitBrowser() {
		Constants.driver.quit();
	}

	/**
	 * It will Scroll up and Down. Pass Positive Parameter if you wants to Scroll
	 * Down Else Pass Negative Parameter if you want to Scroll Up on WebPage
	 * 
	 * @param pixel{{@code int}
	 */
	public static void scrollUpDown(int pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) Constants.driver;
		jse.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * It will generate randam Emailid by using Date&Time format
	 * 
	 * @return
	 */
	public static String timestamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return timeStamp + "Selenium@gmail.com";
	}

	public static String timeStampPassword() {
		Date date = new Date();
		String timeStampPasword = date.toString().replace(" ", "_").replace(":", "_");
		return "Selenium@" + timeStampPasword;

	}

	public static String timeStampScreenShotName() {
		Date date = new Date();
		String timeStampPasword = date.toString().replace(" ", "").replace(":", "");
		return timeStampPasword;

	}

	/**
	 * It will locate Webelement By using locator Type and locator Value
	 * 
	 * @param locatorType  {@code String}
	 * @param locatorValue {@code String}
	 * @return
	 */
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;

		switch (locatorType) {

		case "id":
			element = Constants.driver.findElement(By.id(locatorValue));
			break;

		case "name":
			element = Constants.driver.findElement(By.name(locatorValue));
			break;

		case "xpath":
			element = Constants.driver.findElement(By.xpath(locatorValue));
			break;

		case "tagName":
			element = Constants.driver.findElement(By.tagName(locatorValue));
			break;

		case "className":
			element = Constants.driver.findElement(By.className(locatorValue));
			break;

		case "linkText":
			element = Constants.driver.findElement(By.linkText(locatorValue));
			break;

		case "partialLinkText":
			element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;

		case "cssSelector":
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;

		default:
			System.out.println("Invalid Locator Type:" + locatorType);
			break;
		}
		return element;

	}

	/**
	 * It will locate multiple Webelements By using locator Type and locator Value
	 * 
	 * @param locatorType  {@code String}
	 * @param locatorValue {@code String}
	 * @return
	 */
	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> elements = null;

		switch (locatorType) {

		case "id":
			elements = Constants.driver.findElements(By.id(locatorValue));
			break;

		case "name":
			elements = Constants.driver.findElements(By.name(locatorValue));
			break;

		case "xpath":
			elements = Constants.driver.findElements(By.xpath(locatorValue));
			break;

		case "tagName":
			elements = Constants.driver.findElements(By.tagName(locatorValue));
			break;

		case "className":
			elements = Constants.driver.findElements(By.className(locatorValue));
			break;

		case "linkText":
			elements = Constants.driver.findElements(By.linkText(locatorValue));
			break;

		case "partialLinkText":
			elements = Constants.driver.findElements(By.partialLinkText(locatorValue));
			break;

		case "cssSelector":
			elements = Constants.driver.findElements(By.cssSelector(locatorValue));
			break;

		default:
			System.out.println("Invalid Locator Type:" + locatorType);
			break;
		}
		return elements;
	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		Commons.getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void clickButton(String locatorValue, String locatorType) {
		Commons.getWebElement(locatorType, locatorValue).click();
	}

	public static void actionClass(String locatorValue, String locatorType) {
		Actions action = new Actions(Constants.driver);
		Commons.getWebElement(locatorType, locatorValue);

	}

	public static void doubleClick(String locatorType, String locatorValue) {
		Actions actions = new Actions(Constants.driver);
		WebElement el = getWebElement(locatorType, locatorValue);
		actions.doubleClick(el).build().perform();
	}

	public static void dragAndDrop(String locatorType1, String locatorValue1, String locatorType2,
			String locatorValue2) {
		Actions actions = new Actions(Constants.driver);
		WebElement from = getWebElement(locatorType1, locatorValue1);
		WebElement to = getWebElement(locatorType2, locatorValue2);
		actions.dragAndDrop(from, to).build().perform();

	}

	public static void dropDownSelection(String locatorType, String locatorValue, String textToEnter) {
		Select select = new Select(getWebElement(locatorType, locatorValue));
		select.selectByVisibleText(textToEnter);
	}

	public static void switchToFrame(String locatorType, String locatorValue) {
		Constants.driver.switchTo().frame(getWebElement(locatorType, locatorValue));
	}

	public static boolean isPresent(String locatorType, String locatorValue) {
		if (getWebElements(locatorType, locatorValue).size() > 0) {

			return true;
		} else {
			return false;
		}
	}
}
