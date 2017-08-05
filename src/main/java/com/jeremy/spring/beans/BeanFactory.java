package com.jeremy.spring.beans;

public interface BeanFactory {
	
	<T> T getBean(String name, Class<T> clazz);
	
	Object getBean(String name);
	
	Class<?> getType(String name);
	
	boolean containsBean(String name);
}
