package com.example.spring.selenium;


import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.spring.selenium.pages.CartPage;


public class HomePageTest extends SpringBaseTestNGTest{
	
	private static final Logger logger = LoggerFactory.getLogger(HomePageTest.class);
	
	@Lazy
	@Autowired
	private CartPage cartpage;
	
	@Value("${items}")
	private List<String> items;
	
	@Test(priority = 1)
	public void addItems() {
		logger.info("adding items cart as part of HomePage Test ");
		try {
			homepage.addItemsToCart(items);
			logger.info(" items added cart as part of HomePage Test ");
		} catch (InterruptedException e) {

			e.printStackTrace();
			logger.error(e.getMessage());
		}
		homepage.proceedToCart();
		try {
			logger.info("taking ScreenShot of cart as part of HomePage Test ");
			screenshotutils.takeScreenShot("Shiva.png");
		} catch (IOException e) {
			logger.error(e.getMessage());
			
		}
	}
	
	@Test(priority = 2,dependsOnMethods = {"addItems"})
	public void checkoutCart() {
		cartpage.isAt();
		logger.info("landedon  cart page as part of HomePage Test ");
		String message = cartpage.verifyCupon("Hanuman");
		logger.info("cupoon is applied on cart page as part of HomePage Test ");
		Assert.assertEquals(message, "Invalid code ..!");
		cartpage.placeOrder();
		logger.info("Order palced Successfully part of HomePage Test ");
	}
}
