package leetcode.q1;

import java.util.HashMap;

public class ClassB1 {

	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> numberIndexMap = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			numberIndexMap.put(nums[i], i);
		}
		
		for(int index=0; index<nums.length; index++) {
			int complementValue = target-nums[index];
			if(numberIndexMap.containsKey(complementValue) && index!=numberIndexMap.get(complementValue).intValue()) {
				int[] a = {index, numberIndexMap.get(complementValue)};
				return a;
			}
		}
		throw new IllegalArgumentException();
	}

}
