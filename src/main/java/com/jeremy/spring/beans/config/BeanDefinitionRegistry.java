package com.jeremy.spring.beans.config;

public interface BeanDefinitionRegistry {
	
	void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
