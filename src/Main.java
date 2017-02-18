package ThreadPool.trunk.src;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Runnable task1 =new Runnable() {
			
			@Override
			public void run() {
				System.out.println("task1 started by"+Thread.currentThread().getName());
				try {
					
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task1 completed");
			
			}
		};
		
		Runnable task2 =new Runnable() {
			
			@Override
			public void run() {
				System.out.println("task2 started by "+Thread.currentThread().getName());
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task2 completed");
			
			}
		};
		
Runnable task3 =new Runnable() {
			
			@Override
			public void run() {
				System.out.println("task3 started by "+Thread.currentThread().getName());
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task3 completed");
			
			}
		};
		ThreadPool pool =new ThreadPool(3);
		List<Runnable> tasks= new ArrayList<Runnable>();
		tasks.add(task1);
		tasks.add(task2);
		//Thread.sleep(1000);
		pool.addTasks(tasks);
		Thread.sleep(2000);
		pool.addTask(task3);
		
	}

}
