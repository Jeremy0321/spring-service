package com.jeremy;

import java.util.HashMap;
import java.util.ServiceLoader;

import com.jeremy.dubbo.intf.DemoService;

public class AppTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		for(int i=0;i<20;i++){
			map.put(i+""+System.currentTimeMillis(), ""+i);
		}
		System.out.println(map);
	}
	
	public static void serviceLoader(){
		ServiceLoader<DemoService> loaders = ServiceLoader.load(DemoService.class);
		for(DemoService d:loaders){
			System.out.println(d.sayHello("jeremy"));
		}
	}
}
