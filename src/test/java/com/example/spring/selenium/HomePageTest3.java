package com.example.spring.selenium;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.spring.selenium.pages.CartPage;
import com.example.spring.selenium.pages.OrderPage;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

public class HomePageTest3 extends SpringBaseTestNGTest{
	
	private static final Logger logger = LoggerFactory.getLogger(HomePageTest3.class);
	
	@Lazy
	@Autowired
	private CartPage cartpage;
	
	@Lazy
	@Autowired
	private OrderPage orderpage;
	
	@Value("${items}")
	private List<String> items;
	
	@Test(priority = 1)
	public void addItems() {
		logger.info("adding items cart as part of HomePage Test3 ");
		try {
			homepage.addItemsToCart(items);
			logger.info(" items added cart as part of HomePage Test3 ");
		} catch (InterruptedException e) {

			e.printStackTrace();
			logger.error(e.getMessage());
		}
		homepage.proceedToCart();
		try {
			logger.info("taking ScreenShot of cart as part of HomePage Test3 ");
			screenshotutils.takeScreenShot("Shiva.png");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	@Test(priority = 2,dependsOnMethods = {"addItems"})
	public void checkoutCart() {
		cartpage.isAt();
		logger.info("landedon  cart page as part of HomePage Test3 ");
		String message = cartpage.verifyCupon("Hanuman");
		logger.info("cupoon is applied on cart page as part of HomePage Test3 ");
		Assert.assertEquals(message, "Invalid code ..!");
		cartpage.placeOrder();
		logger.info("Navigating to Order Page as part of HomePage Test3 ");
	}
	
	@Test(priority = 3)
	public void completeOrder() {
		orderpage.isAt();
		logger.info("landedon  Order page as part of HomePage Test3 ");
		orderpage.selectCountry("India");
		orderpage.checkAggrement();
		orderpage.placeOrder();
		logger.info("Order palced Successfully part of HomePage Test3 ");
	}
}
