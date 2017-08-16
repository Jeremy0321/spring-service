package com.jeremy.dubbo.impl;

import com.jeremy.dubbo.intf.DemoService;

public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		return "Hello " + name;
	}

	public DemoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("init constructor DemoServiceImpl");
	}

	
}
