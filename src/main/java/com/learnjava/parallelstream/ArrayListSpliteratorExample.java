package com.learnjava.parallelstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import  static com.learnjava.util.CommonUtil.*;

import  static com.learnjava.util.LoggerUtil.*;

public class ArrayListSpliteratorExample {
	
	 public List<Integer> multiplyEachValue(List<Integer> inputList, int multiplyValue, boolean isParallel) {
		 stopWatchReset();  
		 startTimer();

	        Stream<Integer> integerStream = inputList.stream();

	        if (isParallel)
	            integerStream.parallel();

	        List<Integer> resultList = integerStream
	                .map((i) ->{
	                    //log("inside map");
	                    return i * multiplyValue;
	                } )
	                .collect(Collectors.toList());
	        timeTaken();
	        //log("Completed!");
	        return resultList;
	    }

	public static void main(String[] args) {
		
		ArrayListSpliteratorExample arrayListSpliteratorExample = new ArrayListSpliteratorExample();
		
		List<Integer>intList = Arrays.asList(1,2,3,4,5,6);
		//
		arrayListSpliteratorExample.multiplyEachValue(intList, 2, true);
	}

}
