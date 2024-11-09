package com.example.spring.selenium.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.spring.selenium.annotations.LazyComponent;


@LazyComponent
public class HomePage extends Base{

////div[@class='product']/h4[contains(text(),'Brocolli')]/following-sibling::div[@class='product-action']
	
	@FindBy(css = "input.search-keyword")
	private WebElement searchBox;
	
	@FindBy(css = "button.search-button")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='product-action']")
	private WebElement addToCart;
	
	@FindBy(css = "a.cart-icon")
	private WebElement cartIcon;
	
	@FindBy(xpath = "//button[.='PROCEED TO CHECKOUT']")
	private WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath = "//a[.='Top Deals']")
	private WebElement topDeals;
	
	@Override
	public boolean isAt() {
		return wait.until((e) -> this.searchBox.isDisplayed());
	}
	
	public void searchItem(String item) {
		this.inputText(this.searchBox, item);
		this.clicWithWait(this.searchBtn);
	}
	
	public void addItemToCart() {
		this.clicWithWait(this.addToCart);
	}
	
	public void addItemsToCart(List<String> items) throws InterruptedException {
		for(String item : items) {
			this.searchItem(item);
			Thread.sleep(1000);
			this.clicWithWait(this.addToCart);
		}
	}
	
	public void proceedToCart() {
		this.clicWithWait(this.cartIcon);
		this.clicWithWait(this.proceedToCheckoutBtn);
	}
	
	public void proceedToDeals() {
		this.clicWithWait(this.topDeals);
	}


}
