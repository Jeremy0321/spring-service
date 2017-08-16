package com.jeremy;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jeremy.dms.bean.DmsDocument;
import com.jeremy.dms.dao.DmsDocumentDao;

public class Bootstrap {

	public static void main(String[] args) {
		testAopBySpringContext();
	}
	
	
	public static void testAopBySpringContext(){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
		DmsDocumentDao dmsDocumentDao = (DmsDocumentDao)app.getBean("dmsDocumentDao");
		
		DmsDocument dmsDocument = new DmsDocument();
		dmsDocument.setDocumentName("评估报告单");
		dmsDocument.setReferenceNo("XX002");
		dmsDocumentDao.insert(dmsDocument);
		app.close();
	}
	
	public static void initBeanFactoryBySpringContext(){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
		DmsDocument dmsDocument = app.getBean("dmsDocument", DmsDocument.class);
		System.out.println(dmsDocument);
		app.close();
	}
	
	public static void initBeanFactoryBySpringBean(){
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		beanDefinitionReader.loadBeanDefinitions("classpath:config/applicationContext.xml");
		DmsDocument dmsDocument = beanFactory.getBean("dmsDocument", DmsDocument.class);
		System.out.println(dmsDocument);
	}
}
