package leetcode.q252;

import java.util.Arrays;

public class Solution252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution252 obj = new Solution252();
		/*int[][] a = {{0,30},{5,10}, {15,20}};
		System.out.println(obj.canAttendMeetings(a));*/
		
		int[][] b = {{7,10},{2,4}};
		System.out.println(obj.canAttendMeetings(b));

	}


	public boolean canAttendMeetings(int[][] intervals) {

		int numOfIntervals = intervals.length;
		
		Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
		
		for(int i=1; i<intervals.length; i++) {
			int[] prev = intervals[i-1];
			int[] curr = intervals[i];
			if(curr[0] < prev[1]) {
				return false;
			}
		}
		
		return true;
	}

}
