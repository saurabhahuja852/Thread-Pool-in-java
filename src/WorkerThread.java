package ThreadPool.trunk.src;

import java.util.Queue;

public class WorkerThread extends Thread {

	private Queue<Runnable> taskQueue =null;
	
	public WorkerThread(Queue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	@Override
	public void run() {
		while(true) {
			Runnable task =null;
			synchronized (taskQueue) {
				
				if(taskQueue.isEmpty()){
					try {
						//System.out.println("After synchrozined");
						System.out.println(Thread.currentThread().getName()+" going for waiting");
						taskQueue.wait();
					 } catch (InterruptedException e) {
						 
					}
					System.out.println("After waing");
					if(!taskQueue.isEmpty()){
						task =taskQueue.poll();
					}
				}else{
					task =taskQueue.poll();
				}
				
			}
		// When runnning a task ,we don't require  lock on task queue  so we write below code after syncronozed block
			if(task!=null){
				task.run();
			}
			
			
		}
		
		
	}
	
	
	

}
