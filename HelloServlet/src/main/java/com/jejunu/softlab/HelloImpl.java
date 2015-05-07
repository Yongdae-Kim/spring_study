package com.jejunu.softlab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello {

	@Value(value = "hello")
	public String hello;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	@Override
	public String sayHello() {
		return this.hello;
	}
}
