package com.example.spring.selenium.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface LazyComponent {

}
