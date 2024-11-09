package com.example.spring.selenium;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.spring.selenium.pages.CartPage;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

public class HomePageTest extends SpringBaseTestNGTest{
	
	@Lazy
	@Autowired
	private CartPage cartpage;
	
	@Value("${items}")
	private List<String> items;
	
	@Test(priority = 1)
	public void addItems() {
		try {
			homepage.addItemsToCart(items);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		homepage.proceedToCart();
		try {
			screenshotutils.takeScreenShot("Shiva.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void checkoutCart() {
		cartpage.isAt();
		String message = cartpage.verifyCupon("Hanuman");
		Assert.assertEquals(message, "Invalid code ..!");
		cartpage.placeOrder();
	}
}
