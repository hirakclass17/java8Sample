package com.learnjava.parallelstream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.learnjava.util.DataSet;

class ParallelStreamPerformanceTest {

	 ParallelStreamPerformance intStreamExample = new ParallelStreamPerformance();

	  //  @Test
	    void sum_using_intstream() {
	        //given

	        //when
	        int sum = intStreamExample.sumUsingIntStream(1000000, false);
	        System.out.println("sum in sequential int stream: "+ sum);

	        //then
	        assertEquals(1784293664, sum);
	    }

	   @Test
	    void sum_using_intstream_parallel() {
	        //given

	        //when
	        int sum = intStreamExample.sumUsingIntStream(1000000, true);
	        System.out.println("sum in parallel int stream: "+ sum);

	        //then
	        assertEquals(1784293664, sum);
	    }

	  //  @Test
	    void sum_using_iterate() {
	        //given

	        //when
	        int sum = intStreamExample.sumUsingIterator(1000000, false);
	        System.out.println("sum sequential iterator: "+ sum);

	        //then
	        assertEquals(1784293664, sum);
	    }

	   // @Test
	    void sum_using_iterate_parallel() {
	        //given

	        //when
	        int sum = intStreamExample.sumUsingIterator(1000000, true);
	        System.out.println("sum_using_iterate_parallel: "+ sum);

	        //then
	        assertEquals(1784293664, sum);
	    }

	  //  @Test
	    void sum_using_list() {
	        //given
	        int size = 1000000;
	        ArrayList<Integer> inputList = DataSet.generateArrayList(size);
	        //when
	        int sum = intStreamExample.sumUsingList(inputList, false);
	        System.out.println("sum : "+ sum);

	        //then
	        assertEquals(1784293664, sum);
	    }

	 //   @Test
	    void sum_using_list_parallel() {
	        //given
	        int size = 1000000;
	        ArrayList<Integer> inputList = DataSet.generateArrayList(size);
	        //when
	        int sum = intStreamExample.sumUsingList(inputList, true);
	        System.out.println("sum : "+ sum);

	        //then
	        assertEquals(1784293664, sum);
	    }

	}