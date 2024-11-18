package com.example.spring.runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.spring.retry.RetryAnalyzer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;


@CucumberOptions(
		features="classpath:Features",
		glue={"classpath:com/example/spring/steps","classpath:com/example/spring/runners","classpath:com/example/spring/hooks"},
		plugin = {"pretty", "json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class MyRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel = true)
    public Object[][] scenarios() {
       return super.scenarios();
    }
	
	 @Test(groups = "cucumber", 
			 description = "Runs Cucumber Scenarios",
			 dataProvider = "scenarios",
			 retryAnalyzer = RetryAnalyzer.class)
	 public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
	        super.runScenario(pickleWrapper, featureWrapper);
	  }

}
