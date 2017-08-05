package com.jeremy.spring.beans.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.jeremy.spring.beans.BeanFactory;
import com.jeremy.spring.beans.config.BeanDefinition;
import com.jeremy.spring.beans.config.BeanDefinitionRegistry;

public class DefaultListableBeanFactory implements BeanFactory, BeanDefinitionRegistry{
	
	
	Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	List<String> beanDefinitionNames = new ArrayList<String>();

	public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		// TODO Auto-generated method stub
		beanDefinitionMap.put(beanName, beanDefinition);
		beanDefinitionNames.add(beanName);
	}

	public <T> T getBean(String name, Class<T> clazz) {
		return  (T) getBean(name);
	}

	public Object getBean(String name) {
		BeanDefinition bd = beanDefinitionMap.get(name);
		String beanClassName = bd.getBeanClassName();
		try {
			
			Object o = Class.forName(beanClassName).newInstance();
			return  o;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Class<?> getType(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean containsBean(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
