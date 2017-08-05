package com.jeremy.dms;

import org.aspectj.lang.ProceedingJoinPoint;

public class DmsAspect {

	public void before(){
		System.out.println("DmsAspect before ... 前置通知");
	}
	
	public void afterReturn(Object returnVal){
		System.out.println("DmsAspect after retrun ... 后置通知 ->返回值: "+returnVal);
	}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("DmsAspect around ... 环绕通知 执行前...");
		Object o = joinPoint.proceed();
		System.out.println("DmsAspect around ... 环绕通知 执行后...");
		return o;
	} 
	
	public void afterThrowing(Throwable throwable){
		System.out.println("DmsAspect afterThrowing ... 异常通知 ...");
	}
	
	public void after(){
		System.out.println("DmsAspect after ... 最终通知！");
	}
}
