package leetcode.q1228;

public class ClassA1228 {
	
	public int missingNumber(int[] arr) {

		int len = arr.length;
		int diff = (arr[len-1]-arr[0])/(len);

		for(int index = 1; index<len; index++) {
			int expected = arr[0]+index*diff;
			if(arr[index] != expected) {
				return expected;
			}
		}
		

		return arr[0];
	}

}
