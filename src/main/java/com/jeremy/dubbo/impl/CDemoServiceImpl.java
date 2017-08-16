package com.jeremy.dubbo.impl;

import com.jeremy.dubbo.intf.DemoService;

public class CDemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		return "你好" + name;
	}

}
