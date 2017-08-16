package com.jeremy;

import java.util.ServiceLoader;

import com.jeremy.dubbo.intf.DemoService;

public class AppTest {

	public static void main(String[] args) {
		serviceLoader();
	}
	
	public static void serviceLoader(){
		ServiceLoader<DemoService> loaders = ServiceLoader.load(DemoService.class);
		for(DemoService d:loaders){
			System.out.println(d.sayHello("jeremy"));
		}
	}
}
