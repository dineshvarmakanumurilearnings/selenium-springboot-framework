package com.example.spring.selenium.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.selenium.annotations.Window;

@Component
@Aspect
public class WindowAspect {
	
	@Autowired
	private WindowSwitchUtility Windowswitchutility;
	
	@Before("@target(window) && within(com.example.spring.selenium..*)")
	public void before(Window window) {
		Windowswitchutility.switchWindowByIndex(window.value());
	}
	
	@After("@target(window) && within(com.example.spring.selenium..*)")
	public void after(Window window) {
		Windowswitchutility.switchWindowByIndex(0);
	}

}
