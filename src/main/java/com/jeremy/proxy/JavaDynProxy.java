package com.jeremy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.jeremy.dms.dao.DmsDocumentDao;
import com.jeremy.dms.dao.IDmsDocumentDao;

public class JavaDynProxy implements InvocationHandler{
	
	private Object target;
	
	public Object getProxyInstance(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(target, args);
		return result;
	}

	
	public static void main(String[] args) {
		JavaDynProxy proxy = new JavaDynProxy();
		IDmsDocumentDao dao = (IDmsDocumentDao) proxy.getProxyInstance(new DmsDocumentDao());
		dao.insert(null);
	}
}
