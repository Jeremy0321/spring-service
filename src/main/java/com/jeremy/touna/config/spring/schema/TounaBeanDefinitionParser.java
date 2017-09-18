/**
 * 
 */
package com.jeremy.touna.config.spring.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.jeremy.touna.bean.ApplyInfo;
import com.jeremy.touna.bean.Customer;

/**
 * @author jeremy
 *
 */
public class TounaBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	Class<?> beanClass;
	
	public TounaBeanDefinitionParser(Class<?> beanClass) {
		super();
		this.beanClass = beanClass;
	}

	@Override
	protected Class<?> getBeanClass(Element element) {
		return this.beanClass;
	}
	

	@Override
	protected boolean shouldGenerateId() {
		return true;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		
		if(beanClass.equals(ApplyInfo.class)){
//			String id = element.getAttribute("id");
			String siteCode = element.getAttribute("siteCode");
			String productCode = element.getAttribute("productCode");
			String loanWay = element.getAttribute("loanWay");
			String repayment = element.getAttribute("repayment");
			
//			if(StringUtils.hasText(id)){
//				bean.addPropertyValue("id", (id));
//			}
			if(StringUtils.hasText(siteCode)){
				bean.addPropertyValue("siteCode", (siteCode));
			}
			if(StringUtils.hasText(productCode)){
				bean.addPropertyValue("productCode", (productCode));
			}
			if(StringUtils.hasText(loanWay)){
				bean.addPropertyValue("loanWay", (loanWay));
			}
			if(StringUtils.hasText(repayment)){
				bean.addPropertyValue("repayment", (repayment));
			}
		} else if(beanClass.equals(Customer.class)){
			String id = element.getAttribute("id");
			String name = element.getAttribute("name");
			String idCardNo = element.getAttribute("idCardNo");
			String gender = element.getAttribute("gender");
			String nation = element.getAttribute("nation");
			String address = element.getAttribute("address");
			bean.addPropertyValue("id", id);
			bean.addPropertyValue("name", name);
			bean.addPropertyValue("idCardNo", idCardNo);
			bean.addPropertyValue("gender", gender);
			bean.addPropertyValue("nation", nation);
			bean.addPropertyValue("address", address);
		}
		
		
	}

	
	

}
