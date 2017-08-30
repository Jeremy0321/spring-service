/**
 * 
 */
package com.jeremy.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jeremy
 *
 */
public class VolatileTest2 {
	
	final Lock lock = new ReentrantLock();
	int i;
	
	public int getI(boolean flag){
		lock.lock(); 
		try{
			if(flag){
				Thread.sleep(10000);
			}
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return i;
		}finally{
			lock.unlock();
		}
	}
	
	public  void setI(int i){
		this.i = i;
	}
	
	public static void main(String[] args) throws Exception{
		final VolatileTest2 v = new VolatileTest2();
		v.setI(2000);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				long id = Thread.currentThread().getId();
					int i = v.getI(true);
					System.out.println("t1 ==== current thread id is: "+ id+" is enter");
					System.out.println("t1 ==== current thread is : "+id+" v.getI() = "+i);
				
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				long id = Thread.currentThread().getId();
				System.out.println("t2 ==== current thread is : "+id+" v.getI() = "+v.getI(false));
			}
		});
		t2.start();
	}
}
