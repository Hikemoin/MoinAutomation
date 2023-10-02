package com.qa.Ecommerce.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.Ecommerce.Commons.Commons;
import com.qa.Ecommerce.constant.Constants;
import com.qa.Ecommerce.utilities.ExtentReport;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onTestFailure(ITestResult result) {

		TakesScreenshot screenshot = (TakesScreenshot) Constants.driver;
		String projectPath = System.getProperty("user.dir");
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(file, new File(projectPath + "\\Screenshots\\" + result.getName() + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		extentTest
				.addScreenCaptureFromPath(projectPath + "\\Screenshots\\" + Commons.timeStampScreenShotName() + ".png");
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " got failed");

	}

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName() + " got successfully executed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReport.generateExtenReport();

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();

	}

}
