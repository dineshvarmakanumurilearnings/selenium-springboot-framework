package com.example.spring.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import jakarta.annotation.PostConstruct;

public abstract class Base {

	@Lazy
	@Autowired
	protected WebDriver driver;
	
	@Lazy
	@Autowired
	protected WebDriverWait wait;
	
	@Value("${url}")
	private String url;
	
	public abstract boolean isAt();

	@PostConstruct
	private void init() {
		PageFactory.initElements(this.driver, this);
	}
	
	public void launchApplication() {
		this.driver.navigate().to(url);
		this.driver.manage().window().maximize();
	} 
	
	public void close() {
		driver.quit();
	} 
	
	protected void clicWithWait(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	protected void inputText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	protected String getTextFromElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

}
