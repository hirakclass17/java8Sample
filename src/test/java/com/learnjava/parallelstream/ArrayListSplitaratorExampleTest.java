package com.learnjava.parallelstream;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.learnjava.util.DataSet;

class ArrayListSplitaratorExampleTest {

	private ArrayListSpliteratorExample ArrayListSpliteratorExample = new ArrayListSpliteratorExample();
	
	@RepeatedTest(5)
	void testMultiplyEachValue() {
		//gievn
		List<Integer> intArrayList = DataSet.generateIntegerList(1000000);
		//when
		ArrayListSpliteratorExample.multiplyEachValue(intArrayList, 2, true);
		//then
		
	}

}
