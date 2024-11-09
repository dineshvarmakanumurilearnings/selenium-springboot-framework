package com.example.spring.selenium;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.spring.selenium.pages.TopDealsPage;


public class TopDealsTest extends SpringBaseTestNGTest{
	
	@Autowired
	private TopDealsPage topdealsPage;
	
	@Test
	public void verifyPriceandDiscountedPrice() {
		
		homepage.proceedToDeals();
		
		int price = topdealsPage.getItemPrice("Pineapple");
		int discountedPrice = topdealsPage.getItemDiscountedPrice("Pineapple");
		
		Assert.assertTrue(discountedPrice<price);
	}
		

}
