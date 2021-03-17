package leetcode.q1086;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ClassA1086 implements Operation1086 {

	@Override
	public int[][] highFive(int[][] items) {

		HashMap<Integer, ArrayList<Integer>> studentMarksMap 
		= new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=0; i<items.length; i++) {
			int[] result = items[i];
			ArrayList<Integer> marks = null;
			if(studentMarksMap.containsKey(result[0])) {
				marks = studentMarksMap.get(result[0]);
				marks.add(result[1]);
			} else {
				marks = new ArrayList<Integer>();
				marks.add(result[1]);
			}
			studentMarksMap.put(result[0], marks);
		}
		int[][] output = new int[2][studentMarksMap.keySet().size()];
		int counter = 0;
		for(Entry<Integer, ArrayList<Integer>> entry : studentMarksMap.entrySet()) {
			
			ArrayList<Integer> marks = entry.getValue();
			marks.sort((a,b) -> b.compareTo(a));
			int sum = 0;
			for(int i=0; i<marks.size() && i<5; i++) {
				sum = sum+marks.get(i);
			}
			int[] id = new int[2];
			id[0] = entry.getKey();
			id[1] = sum/5;
			
			output[counter] = id;
			counter ++;
		}
	
		return output;
	}

}
