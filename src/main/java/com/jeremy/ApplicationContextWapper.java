package com.jeremy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class ApplicationContextWapper implements ApplicationContextAware {

	ApplicationContext app;
	
	

	public ApplicationContextWapper() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("init ApplicationContextWapper constructor ...");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("set application context by ApplicationContextWapper ...");
		app = applicationContext;
	}
	
	public <T> T getBean(String name, Class<T> clazz){
		return app.getBean(name, clazz);
	}
	
	public Object getBean(String name){
		return app.getBean(name);
	}
	
}
