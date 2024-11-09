package com.example.spring.selenium;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.spring.selenium.pages.HomePage;
import com.example.spring.selenium.utils.ExtentReportComponent;
import com.example.spring.selenium.utils.ScreenShotUtils;

@SpringBootTest
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests{

	@Lazy
	@Autowired
	protected ScreenShotUtils screenshotutils;
	
    @Autowired
    private ExtentReportComponent extentReportComponent;
    
    @Autowired
    private ExtentTest extentTest;
 
	@Lazy
	@Autowired
	protected HomePage homepage;
	
	@BeforeClass
	public void setup(ITestContext context) {
		//ExtentTest extentTest = applicationContext.getBean(ExtentTest.class);
		extentTest.getModel().setName(context.getCurrentXmlTest().getName());
        homepage.launchApplication();
        Assert.assertTrue(homepage.isAt());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			String screenshotPath = screenshotutils.takeScreenShot(result.getMethod().getMethodName()+".png");
	        extentTest.log(Status.FAIL, result.getThrowable());
	        extentTest.addScreenCaptureFromPath(screenshotPath);
        }
	}
	
	@AfterTest
	public void tearDown() {
		homepage.close();
	}
	
	@AfterSuite
    public void flushReports() {
        extentReportComponent.flush();
    }
}
