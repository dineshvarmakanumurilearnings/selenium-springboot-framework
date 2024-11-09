package com.example.spring.selenium.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.example.spring.selenium.annotations.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

	@Bean
	@Scope("browserscope")
	@ConditionalOnProperty(name="browser",havingValue="firefox")
	public WebDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	@Bean
	@Scope(value = "threadScope")
	@ConditionalOnMissingBean
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	

}
