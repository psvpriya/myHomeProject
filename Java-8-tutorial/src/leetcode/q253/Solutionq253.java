package leetcode.q253;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solutionq253 {

	 public int minMeetingRooms(int[][] intervals) {
	     
		 
		 HashMap<Integer, int[]> roomMap = new HashMap<Integer, int[]>();
		 
	        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
	        int roomCounter = 0;
	        for(int i=0; i<intervals.length; i++) {
	        	boolean intervalUpdated = false;
	        	//represent current interval under consideration
	        	int startTime = intervals[i][0];
	        	int endTime = intervals[i][1];
	        	
	        	for(Entry<Integer, int[]> room : roomMap.entrySet()) {
	        		if(startTime>=room.getValue()[1]) {
	        			intervalUpdated = true;
	        			room.getValue()[1] = endTime;
	        			break;
	        		}
	        	}
	        	if(!intervalUpdated) {
	        		int[] a = {startTime, endTime};
	        		roomMap.put(roomCounter++, a);
	        	}
	        	
	        }
	        return roomMap.size();
	    }
	
	
}
