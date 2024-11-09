package com.example.spring.selenium.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.example.spring.selenium.annotations.LazyComponent;


@LazyComponent
public class WindowSwitchUtility {
	
	@Autowired
	private ApplicationContext context;
	
	public void switchWindowByIndex(int index) {
		WebDriver driver = context.getBean(WebDriver.class);
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(index));
		
	}
	
	public void switchWindowBTitele(String title) {
		WebDriver driver = context.getBean(WebDriver.class);
		driver.getWindowHandles()
		.stream()
		.map(handle -> driver.switchTo().window(handle).getTitle())
		.filter(t -> t.startsWith(title))
		.findFirst()
		.orElseThrow(() -> new RuntimeException("No such window"));
	}

}
