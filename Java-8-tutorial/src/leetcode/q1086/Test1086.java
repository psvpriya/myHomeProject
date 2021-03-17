package leetcode.q1086;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

class Test1086 {
	
	ClassB1086 obj = new ClassB1086();

	@Test
	void test() {
		
		int[][] a = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int[][] b = {{1,84},{1,72},{1,47},{1,43},{1,78},{2,79},{2,4},{2,23},{2,88},{2,79},{3,75},{3,80},{3,38},{3,73},{3,4}};

		int[][] output = obj.highFive(a);
		
		PriorityQueue<Integer> testObj = new PriorityQueue<Integer>();
		testObj.add(91);
		testObj.add(92);
		testObj.add(60);
		testObj.add(65);
		testObj.add(87);
		testObj.add(100);
		
		System.out.println(testObj.toString());
		
		fail("Not yet implemented");
	}

}
