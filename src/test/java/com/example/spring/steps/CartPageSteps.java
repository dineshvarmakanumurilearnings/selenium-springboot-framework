package com.example.spring.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.spring.selenium.pages.CartPage;
import com.example.spring.selenium.utils.ExtentReportComponent;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageSteps{
	
	@Autowired
    private ExtentReportComponent extentReportComponent;
    
    @Autowired
    private ExtentTest extentTest;
    
	@Lazy
	@Autowired
	private CartPage cartPage;
	
	@When("User is on Cart page")
	public void user_is_on_cart_page() {
		cartPage.isAt();
	}

	@Then("Apply cupon code")
	public void apply_cupon_code() {
		try {
			String message = cartPage.verifyCupon("Hanuman");
			Assert.assertEquals(message, "Invalid code ..!");
		}
		catch (Exception e) {
			extentTest.log(Status.FAIL, e.getMessage());
			throw e;

		}
		
	}

	@Then("Click on place order")
	public void click_on_place_order() {
		try {
			cartPage.placeOrder();
		}
		catch (Exception e) {
			extentTest.log(Status.FAIL, e.getMessage());
			throw e;
		}
		
	}

}
