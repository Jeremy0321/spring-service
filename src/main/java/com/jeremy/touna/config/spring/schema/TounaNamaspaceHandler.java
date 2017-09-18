/**
 * 
 */
package com.jeremy.touna.config.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.jeremy.touna.bean.ApplyInfo;
import com.jeremy.touna.bean.Customer;

/**
 * @author jeremy
 *
 */
public class TounaNamaspaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("apply", new TounaBeanDefinitionParser(ApplyInfo.class));
		registerBeanDefinitionParser("customer", new TounaBeanDefinitionParser(Customer.class));
		
	}

}
