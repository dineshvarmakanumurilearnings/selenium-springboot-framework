package com.example.spring.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.spring.selenium.annotations.LazyComponent;


@LazyComponent
public class CartPage extends Base{
	
	@FindBy(id="productCartTables")
	private WebElement productCartTable;
	
	@FindBy(css ="input.promoCode")
	private WebElement promoCodeBox;
	
	@FindBy(css ="button.promoBtn")
	private WebElement promoCodeBtn;
	
	@FindBy(xpath = "//button[.='Place Order']")
	private WebElement placeOrderBtn;
	
	@FindBy(css = "span.promoInfo")
	private WebElement promoInfo;
	
	@Override
	public boolean isAt() {
		return wait.until((d) -> productCartTable.isDisplayed());
	}
	
	public String verifyCupon(final String cuponCode) {
		this.inputText(this.promoCodeBox, cuponCode);
		this.clicWithWait(this.promoCodeBtn);
		return this.getTextFromElement(promoInfo);
	}
	
	public void placeOrder() {
		this.clicWithWait(this.placeOrderBtn);
	}

}
