package com.example.spring.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.example.spring.selenium.annotations.LazyComponent;

@LazyComponent
public class OrderPage extends Base{
	
	@FindBy(xpath = "//*[.='Choose Country']")
	private WebElement chooseCountry;
	
	@FindBy(tagName = "select")
	private WebElement chooseCountryDropDown;
	
	@FindBy(css = "input.chkAgree")
	private WebElement agrementTermsCheckBox;
	
	@FindBy(css = "span.errorAlert")
	private WebElement errorAlert;
	
	@FindBy(xpath = "//*[.='Proceed']")
	private WebElement proceedBtn;
	
	

	@Override
	public boolean isAt() {
		return wait.until((d) -> chooseCountry.isDisplayed());
	}
	
	public void checkAggrement() {
		this.clicWithWait(agrementTermsCheckBox);
	}
	
	public void selectCountry(String countryName) {
		Select sel = new Select(chooseCountryDropDown);
		sel.selectByValue(countryName);
	}
	
	public void placeOrder() {
		this.clicWithWait(proceedBtn);
	}

}
