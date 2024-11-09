package com.example.spring.selenium.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.example.spring.selenium.annotations.LazyConfiguration;


@LazyConfiguration
public class WebDriverWaitConfig {
	
	@Value("${timeout}")
	private int timeout;
	
	@Bean
	@Scope("prototype")
	public WebDriverWait wait(WebDriver driver) {
		return new WebDriverWait(driver,Duration.ofSeconds(timeout));
	}

}
