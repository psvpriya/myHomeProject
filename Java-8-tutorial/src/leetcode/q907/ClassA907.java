package leetcode.q907;

import java.util.Arrays;

public class ClassA907 {

	
	public int sumSubarrayMins(int[] arr) {
		
		int M = 1000000007;
		
		int sum = 0;
		for(int len =1; len<=arr.length; len++) {
			for(int i=0; i+len<=arr.length; i++) {
				int[] subArray = Arrays.copyOfRange(arr, i, i+len);
				sum = sum%M + getMinValueOfArray(subArray)%M;
			}
		}
		return sum%M;   
	}

	public int getMinValueOfArray(int[] arr) {
		int min = Integer.MAX_VALUE;
		if(arr.length == 0) {
			return 0;
		}
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	
}
