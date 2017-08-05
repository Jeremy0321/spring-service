package com.jeremy.spring.beans.config;

public interface BeanDefinition extends AttributeAccessor{
	
	String getBeanClassName();
	
	void setBeanClassName(String beanClassName);
}
