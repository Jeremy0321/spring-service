package com.jeremy;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jeremy.dms.bean.DmsDocument;
import com.jeremy.dms.dao.DmsDocumentDao;
import com.jeremy.touna.bean.ApplyInfo;
import com.jeremy.touna.bean.Customer;

public class Bootstrap {

	public static void main(String[] args) {
//		initBeanFactoryBySpringContext();
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
		ApplyInfo appinfo = app.getBean(ApplyInfo.class);
		System.out.println(appinfo);
		Customer c  = app.getBean(Customer.class);
		System.out.println(c);
		app.close();
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
		DmsDocumentDao dmsDocumentDao = app.getBean("dmsDocumentDao", DmsDocumentDao.class);
		System.out.println(dmsDocumentDao);
		app.close();
	}
	
	public static void initBeanFactoryBySpringBean(){
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		beanDefinitionReader.loadBeanDefinitions("classpath:config/applicationContext.xml");
		DmsDocumentDao dmsDocumentDao = beanFactory.getBean("dmsDocumentDao", DmsDocumentDao.class);
		System.out.println(dmsDocumentDao);
	}
}
