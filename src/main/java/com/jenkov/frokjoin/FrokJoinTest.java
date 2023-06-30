package com.jenkov.frokjoin;

import java.util.concurrent.ForkJoinPool;

public class FrokJoinTest {

	public static void main(String[] args) {
		
		//create a ForkJoinPool using its constructor. As a parameter to the ForkJoinPool 
		//constructor you pass the indicated level of parallelism you desire. 
		//The parallelism level indicates how many threads or CPUs you want
		//to work concurrently on on tasks passed to the ForkJoinPool
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		
		//
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(50);

		forkJoinPool.invoke(myRecursiveAction);
		
	}

}
