/**
 * 
 */
package com.jeremy.concurrent;

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;

/**
 * @author jeremy
 *
 */
public class VolatileTest {

	public static int race = 0;
	
	static volatile ConcurrentHashSet<Long> set = new ConcurrentHashSet<>();
	
	public static void increase(){
		synchronized (VolatileTest.class) {
			long txId = Thread.currentThread().getId();
			System.out.println("current thread id is:"+txId);
			set.add(txId);
			race++;
		}
		
	}
	
	private final static int THREAD_COUNT = 20;
	
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[THREAD_COUNT];
		for(int i=0;i<THREAD_COUNT;i++){
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<100000;i++){
						increase();
					}
				}
			});
			
			threads[i].start();
		}
		
		System.out.println("current active thread num is :" +Thread.activeCount() );
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		System.out.println(race);
		
		System.out.println(set+" set size is:"+set.size());
		
	}
}
