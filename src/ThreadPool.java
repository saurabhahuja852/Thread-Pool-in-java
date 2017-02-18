package ThreadPool.trunk.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThreadPool {
	
	private int numberOfThreads =0;
	
	Queue<Runnable> taskQueue = null;
	List<WorkerThread> workerThreads =null;
	
	public ThreadPool(int numberOfThreads) {
		 this.numberOfThreads = numberOfThreads;
		 taskQueue =new LinkedList<Runnable>();
		 workerThreads =new ArrayList<WorkerThread>();
		 //creating Worker Thread
		 for(int i=0;i<numberOfThreads;i++){
			 WorkerThread workerthread =new WorkerThread(taskQueue);
			 workerThreads.add(workerthread);
			 workerthread.setName("Thread  "+(i+1));
			 workerthread.start();
		 }
	
	}

	public void addTask(Runnable task){
		synchronized (taskQueue) {
			System.out.println("Single task added");
			taskQueue.add(task);
			taskQueue.notify();
		}
	}
	
	public void addTasks(Collection<Runnable> tasks){
		synchronized (taskQueue) {
		 
			for(Runnable task:tasks){
				taskQueue.add(task);
			}
			System.out.println("Multiple task added");
			taskQueue.notifyAll();
		}
	}
	

}
