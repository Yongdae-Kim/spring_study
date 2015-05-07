package com.jejunu.softlab;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldServlet extends GenericServlet {
	private final static Logger logger = LoggerFactory
			.getLogger(HelloWorldServlet.class);

	@Override
	public void init() throws ServletException {
		logger.info("**************  init **************");
		super.init();
	}

	@Override
	public void destroy() {
		logger.info("**************  destroy **************");
		super.destroy();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		logger.info("**************  service **************");

		/*
		 * AnnotationConfigApplicationContext applicationContext = new
		 * AnnotationConfigApplicationContext( "com.jejunu.softlab"); Hello
		 * hello = applicationContext.getBean(Hello.class);
		 * res.getWriter().println(hello.sayHello());
		 */

		res.getWriter().println("<Html><h2>Hello World</h2></Html>");
	}

}
