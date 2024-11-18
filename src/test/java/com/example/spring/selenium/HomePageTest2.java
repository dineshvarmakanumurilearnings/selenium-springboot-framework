package com.example.spring.selenium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;



public class HomePageTest2 extends SpringBaseTestNGTest{
	
	private static final Logger logger = LoggerFactory.getLogger(HomePageTest2.class);
	
	@Test
	public void itemsTest() throws NoSuchMethodException, SecurityException {
		logger.info("adding items cart as part of HomePage Test2 ");
		try {
			homepage.addItemsToCart(List.of("Cauliflower","Tomato","Raspberry"));
			logger.info(" items added cart as part of HomePage Test2 ");
		} catch (InterruptedException e) {

			e.printStackTrace();
			logger.error(e.getMessage());
		}
		homepage.proceedToCart();
		try {
			logger.info("taking ScreenShot of cart as part of HomePage Test2 ");
			screenshotutils.takeScreenShot("Keshav.png");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}
	
	


}
