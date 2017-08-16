package com.jeremy.proxy;

import java.lang.reflect.Method;

import com.jeremy.dms.dao.DmsDocumentDao;
import com.jeremy.dms.dao.IDmsDocumentDao;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	private Object target ;
	
	public Object getProxyInstance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	

	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		return proxy.invokeSuper(target, args);
	}

	
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		IDmsDocumentDao dao = (DmsDocumentDao) proxy.getProxyInstance(new DmsDocumentDao());
		dao.insert(null);
	}
}
