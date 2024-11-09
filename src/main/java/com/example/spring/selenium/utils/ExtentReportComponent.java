package com.example.spring.selenium.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


@Configuration
public class ExtentReportComponent {
	
	private ExtentReports extentReports;

	public  ExtentReportComponent() {
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-reports/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("SpringBoot Automation Report");
        sparkReporter.config().setReportName("Smoke Test Results");
        extentReports.attachReporter(sparkReporter);
    }
	

	@Bean
	@Scope("threadScope") // Each thread will have its own ExtentTest instance
    public ExtentTest extentTest() {
        return extentReports.createTest("Default Test");
    }

    public void flush() {
        extentReports.flush();
    }

}
