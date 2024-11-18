package com.example.spring.steps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.spring.selenium.SeleniumApplication;
import com.example.spring.selenium.pages.HomePage;
import com.example.spring.selenium.utils.ExtentReportComponent;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;


@CucumberContextConfiguration
@SpringBootTest(classes = SeleniumApplication.class)
public class HomePageSteps{
	
	@Autowired
    private ExtentReportComponent extentReportComponent;
    
    @Autowired
    private ExtentTest extentTest;
    
	@Lazy
	@Autowired
	private HomePage homePage;
	
	
	@Given("User is on Home page")
	public void user_is_on_home_page() {
		try {
			Assert.assertTrue(homePage.isAt());
		}
		catch (Exception e) {
			extentTest.log(Status.FAIL, e.getMessage());
			throw e;
		}
        
	}

	@Then("Added below items to cart")
	public void added_below_items_to_cart(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<String> items = dataTable.asList(String.class);
		try {
			homePage.addItemsToCart(items);
		}
		catch (Exception e) {
			extentTest.log(Status.FAIL, e.getMessage());
			throw e;
		}
		
	}

	@Then("Proceed to cart page")
	public void proceed_to_cart_page() {
		try {
			homePage.proceedToCart();
		}
		catch (Exception e) {
			extentTest.log(Status.FAIL, e.getMessage());
			throw e;
		}
		
	}

}
