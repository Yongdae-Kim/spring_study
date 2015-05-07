package com.jejunu.softlab;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicatonContextTest {

	@Test
	public void applicationContextUsingDI() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.jejunu.softlab");
		Hello helloPrinter = applicationContext.getBean(Hello.class);
		System.out.println(helloPrinter.sayHello());
	}
}
