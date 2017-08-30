/**
 * 
 */
package com.jeremy.concurrent.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jeremy
 *
 */
public class ConditionTest {

	static class Producer implements Runnable{

		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		
		@Override
		public void run() {
			lock.lock();
			condition.signalAll();
			
		}
		
	}
	
	static class Consumer implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
