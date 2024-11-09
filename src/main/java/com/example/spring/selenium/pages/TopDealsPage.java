package com.example.spring.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.spring.selenium.annotations.Window;

@Window(1)
public class TopDealsPage extends Base{

	@FindBy(xpath = "//*[.='Delivery Date']")
	private WebElement datepickerText;
	
	@FindBy(css = "input#search-field")
	private WebElement searchBox;
	
	@FindBy(css = "tbody>tr>td:nth-child(2)")
	private WebElement price;
	
	@FindBy(css = "tbody>tr>td:nth-child(3)")
	private WebElement discountedPrice;
	
	
	@Override
	public boolean isAt() {
		return wait.until((e) -> this.datepickerText.isDisplayed());
	}
	
	public void searchItemOnDealsPage(String item) {
		this.inputText(searchBox, item);
	}
	
	public int getItemPrice(String item) {
		this.searchItemOnDealsPage(item);
		return Integer.parseInt(this.price.getText());
		
	}
	
	public int getItemDiscountedPrice(String item) {
		this.searchItemOnDealsPage(item);
		return Integer.parseInt(this.discountedPrice.getText());
		
	}

}
