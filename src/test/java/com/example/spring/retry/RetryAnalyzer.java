package com.example.spring.retry;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int retrycount =0;
	private final int maxCount =1;
	
	@Override
	public boolean retry(ITestResult result) {
			if (retrycount < maxCount) {
				retrycount++;
				return true;
			}
			return false;
	}

}
