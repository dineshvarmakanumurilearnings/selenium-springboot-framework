package com.example.spring.selenium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.spring.selenium.pages.TopDealsPage;


public class TopDealsTest extends SpringBaseTestNGTest{
	
	private static final Logger logger = LoggerFactory.getLogger(TopDealsPage.class);
	
	@Autowired
	private TopDealsPage topdealsPage;
	
	@Test
	public void verifyPriceandDiscountedPrice() {
		
		homepage.proceedToDeals();
		logger.info("landedon  TopDeals page as part of TopDeals Test ");
		int price = topdealsPage.getItemPrice("Pineapple");
		int discountedPrice = topdealsPage.getItemDiscountedPrice("Pineapple");
		
		Assert.assertTrue(discountedPrice<price);
		logger.info("Price comparision is done as part of TopDeals Test ");
	}
		

}
