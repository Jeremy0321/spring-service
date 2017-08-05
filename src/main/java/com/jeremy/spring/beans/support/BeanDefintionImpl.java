package com.jeremy.spring.beans.support;

import com.jeremy.spring.beans.MutablePropertyValues;
import com.jeremy.spring.beans.config.BeanDefinition;
import com.jeremy.spring.beans.config.ConstructorArgVaules;

public class BeanDefintionImpl implements BeanDefinition {
	

	String id;
	String beanClassName;
	String initMethodName;
	String destroyMethodName;
	ConstructorArgVaules constructorArgVaules;
	MutablePropertyValues propertyValues;
	
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public String setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBeanClassName() {
		// TODO Auto-generated method stub
		return this.beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		// TODO Auto-generated method stub
		this.beanClassName = beanClassName;
	}
	
	
}
