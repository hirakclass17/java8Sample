package com.learnjava.parallelstream;

import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;
import static com.learnjava.util.CommonUtil.stopWatchReset;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.learnjava.util.DataSet;

public class ParallelStreamPerformance {
	
	public int sumUsingIntStream(int count, boolean isParallel) {
		//stopWatchReset();
		startTimer();
		
		IntStream intStream = IntStream.rangeClosed(0, count);
		
		if(isParallel) 
			intStream.parallel();
		
		int sum = intStream.sum();
		
		timeTaken();
		
		return sum;
	}
	
	public int sumUsingList(List<Integer>inputList, boolean isParallel) {
		//
		//stopWatchReset();
		startTimer();
		//
		Stream<Integer> inputStream = inputList.stream();
		
		if(isParallel)inputStream.parallel();
		
		int sum = inputStream.mapToInt(Integer::intValue).sum();
		
		timeTaken();
		stopWatchReset();
		
		return sum;
	}
	
	public int sumUsingIterator(int n, boolean isParallel) {
		
		//
		//stopWatchReset();
		startTimer();
		//
		Stream<Integer>intStream =  Stream.iterate(0, i->i++);
		
		if(isParallel)intStream.parallel();
		
		//
		int sum = intStream.limit(n+1).reduce(0, (a,b)->a+b);
		
		timeTaken();
		stopWatchReset();
		return sum;
	}
	
	public static void main(String[] args) {
		List<Integer>intList = DataSet.generateIntegerList(10);
		//
		ParallelStreamPerformance instance = new ParallelStreamPerformance();
		
		instance.sumUsingList(intList, false);
		
	}

}
