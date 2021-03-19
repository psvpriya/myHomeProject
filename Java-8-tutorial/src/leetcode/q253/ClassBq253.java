package leetcode.q253;

import java.util.Arrays;

public class ClassBq253 implements Operationq253{
	
	public int minMeetingRooms(int[][] intervals) {
		
		Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
		int[][] roomsList = new int[2][intervals.length];
		
		 for(int i=0; i<intervals.length; i++) {
			//represent current interval under consideration
	        	int startTime = intervals[i][0];
	        	int endTime = intervals[i][1];
	        	
	        	
		 }
		return 0;
	}

}
