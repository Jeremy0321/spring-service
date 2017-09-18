/**
 * 
 */
package com.jeremy.concurrent.pool;

/**
 * @author jeremy
 *
 */
public class ThreadDeadLock extends Thread{
	
	Object obj1;
	Object obj2;
	
	public ThreadDeadLock(Object obj1, Object obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	
	@Override
	public void run() {
		String name = Thread.currentThread().getId()+" === "+Thread.currentThread().getName();
		synchronized (obj1) {
			System.out.println(name+" acquire lock on "+obj1);
			synchronized (obj2) {
				System.out.println(name+" acquire lock on "+obj2);
				System.out.println(name + " is running");
			}
		}
	}


	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		ThreadDeadLock t1 = new ThreadDeadLock(obj1, obj2);
		ThreadDeadLock t2 = new ThreadDeadLock(obj2, obj1);
		t1.start();
		t2.start();
	}
}
