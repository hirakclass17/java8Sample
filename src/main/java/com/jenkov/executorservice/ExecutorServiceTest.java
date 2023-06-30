package com.jenkov.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
	
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main thread::"+Thread.currentThread());
		executeRunnable();
		executeCallable();

	}
	
	private static void  executeRunnable() {
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		executorService.execute(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Asyncronous task::"+Thread.currentThread());
			}
		});		
		//executorService.shutdown();		
	}
	
	private static void executeCallable() throws InterruptedException, ExecutionException {
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<String> future = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("Async task from callable::"+Thread.currentThread());
				return "Return from Callable";
			}
		});
		
		System.out.println("What the return of future::"+future.get());
	}
}
