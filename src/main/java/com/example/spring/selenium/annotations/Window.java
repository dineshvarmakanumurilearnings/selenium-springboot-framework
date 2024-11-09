package com.example.spring.selenium.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@LazyComponent
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Window {
	int value() default 0;
}
