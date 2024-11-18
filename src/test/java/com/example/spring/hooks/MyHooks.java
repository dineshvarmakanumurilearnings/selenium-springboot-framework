package com.example.spring.hooks;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


import com.aventstack.extentreports.ExtentTest;
import com.example.spring.selenium.pages.HomePage;
import com.example.spring.selenium.utils.ExtentReportComponent;
import com.example.spring.selenium.utils.ScreenShotUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class MyHooks {
	
	@Lazy
	@Autowired
	private HomePage homePage;
	
	@Lazy
	@Autowired
	private ScreenShotUtils screenshotutils;
	
    @Autowired
    private  ExtentReportComponent extentReportComponent;
    
    @Autowired
    private ExtentTest extentTest;
	
	
	@Before
	public void beforeScenario(Scenario scenario) {
		extentTest.getModel().setName(scenario.getName());
		homePage.launchApplication();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenShptPath = screenshotutils.takeScreenShot(scenario.getName()+".png");
			extentTest.addScreenCaptureFromPath(screenShptPath+"/"+scenario.getName()+".png");
		}
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		extentReportComponent.flush();
		homePage.close();
	}
	

}
