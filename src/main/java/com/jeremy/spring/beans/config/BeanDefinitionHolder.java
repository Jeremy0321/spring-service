package com.jeremy.spring.beans.config;

public class BeanDefinitionHolder {

	public final BeanDefinition beanDefinition;
	
	public final String beanName;

	public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName) {
		super();
		this.beanDefinition = beanDefinition;
		this.beanName = beanName;
	}
	
	
}
