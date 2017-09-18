/**
 * 
 */
package com.jeremy.concurrent.pool;

/**
 * @author jeremy
 *
 */
public class ExecutorServiceTest {

	private Object left;
	private Object right;
	
	public void m1(){
		synchronized (left) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized(right){
				
				System.out.println("method1 is start ...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("method2 is end ... ");
			}
		}
	}
	
	public void m2(){
		synchronized (right) {
			synchronized (left) {
				System.out.println("method1 is start ...");
				
				System.out.println("method2 is end ... ");
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorServiceTest test = new ExecutorServiceTest();
		test.left = new Object();
		test.right = new Object();
		
		test.m1();
		test.m2();
	}
	
}
