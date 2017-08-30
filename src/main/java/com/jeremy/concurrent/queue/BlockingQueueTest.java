/**
 * 
 */
package com.jeremy.concurrent.queue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jeremy
 *
 */
public class BlockingQueueTest {

	static class Producer implements Runnable{

		final ArrayBlockingQueue<Integer> blockingQueue;
		
		private volatile boolean flag;
		
		private Random random;
		
		public Producer(ArrayBlockingQueue<Integer> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
			flag = false;
			random = new Random();
		}

		@Override
		public void run() {
			while(!flag){
				int info = random.nextInt(100);
				try {
					blockingQueue.put(info);
					System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+" producer "+info);
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void shutdown(){
			flag = true;
		}
	}
	
	static class Consumer implements Runnable{

		ArrayBlockingQueue<Integer> blockingQueue;
		private volatile boolean flag;
		
		
		
		public Consumer(ArrayBlockingQueue<Integer> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
			this.flag = false;
		}

		@Override
		public void run() {
			while(!flag){
				int info;
				try {
					info = blockingQueue.take();
					System.out.println(Thread.currentThread().getId()+" "+ Thread.currentThread().getName()+" consumer "+info);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void shutdown(){
			flag = true;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		for(int i=0;i<10;i++){
			String uuid = UUID.randomUUID().toString();
			queue.offer(uuid);
			System.out.println("offer queue, queue.size is : "+queue.size()+", uuid is : " + uuid);
		}
		while(true){
			String uuid = queue.take();
			System.out.println("take queue, queue.size is : "+queue.size()+", uuid is : " + uuid);
			if(uuid == null){
				Thread.sleep(100000);
			}
		}
	}
}
