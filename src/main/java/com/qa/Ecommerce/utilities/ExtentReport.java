package com.qa.Ecommerce.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports generateExtenReport() {
		String projectPath = System.getProperty("user.dir");
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(projectPath + "\\Extent Report\\MyReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Ecommerce Project");
		spark.config().setDocumentTitle("E-Com");
		extentReport.attachReporter(spark);

		extentReport.setSystemInfo("Application Url", PropertiesReading.setProperty("Url"));
		extentReport.setSystemInfo("BroserName", PropertiesReading.setProperty("Browser"));
		extentReport.setSystemInfo("Java Version", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		return extentReport;
	}

}
