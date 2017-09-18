/**
 * 
 */
package com.jeremy.concurrent.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jeremy
 *
 */
public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
//		ThreadPoolExecutor exector =  new ThreadPoolExecutor(10, 10,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
		fixedPool();
		
	}
	
	public static void fixedPool(){
		BlockingQueue<Runnable> queue =new ArrayBlockingQueue<Runnable>(10);
		
		ThreadPoolExecutor threadpool = new ThreadPoolExecutor(10, 20,
              1, TimeUnit.SECONDS,
              queue); 
		
		for(int i=0;i<30;i++){
			final int j = 1+i;
			System.out.println("current thread pool size is : "+threadpool.getPoolSize()+", current blocking queue size is : "+queue.size());
			threadpool.execute(new Runnable() {
				@Override
				public void run() {
					long txId = Thread.currentThread().getId();
					String tName = Thread.currentThread().getName();
					
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("current thread id is:"+txId+" "+tName+" finished job !"+j);
				}
			});
		}
	}
	
	
	
}
