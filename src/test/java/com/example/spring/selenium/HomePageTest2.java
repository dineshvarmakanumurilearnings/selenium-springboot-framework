package com.example.spring.selenium;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;



public class HomePageTest2 extends SpringBaseTestNGTest{
	
	@Test
	public void itemsTest() throws NoSuchMethodException, SecurityException {
		try {
			homepage.addItemsToCart(List.of("Cauliflower","Tomato","Raspberry"));
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		homepage.proceedToCart();
		try {
			screenshotutils.takeScreenShot("Keshav.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	


}
