package com.jeremy;

import com.jeremy.dms.bean.DmsDocument;
import com.jeremy.spring.beans.config.BeanDefinition;
import com.jeremy.spring.beans.support.BeanDefintionImpl;
import com.jeremy.spring.beans.support.DefaultListableBeanFactory;

public class AppTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition bd = new BeanDefintionImpl();
//		bd.setAttribute(name, value)
		bd.setBeanClassName("com.jeremy.dms.bean.DmsDocument");
		beanFactory.registryBeanDefinition("dmsDocument", bd);
		DmsDocument dmsDocument = (DmsDocument) beanFactory.getBean("dmsDocument");
		System.out.println(dmsDocument);
	}
}
