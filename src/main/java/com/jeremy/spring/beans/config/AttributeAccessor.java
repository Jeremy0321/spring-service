package com.jeremy.spring.beans.config;

public interface AttributeAccessor {

	Object getAttribute(String name);
	
	String setAttribute(String name, Object value);
}
