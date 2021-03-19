package leetcode.q593;

import java.util.HashMap;
import java.util.Map.Entry;

public class ClassBq593 {

	
	
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		HashMap<Integer, Integer> sideMap = new HashMap<Integer, Integer>();
		
		sideSquare(p1, p2, sideMap);
		sideSquare(p1, p3, sideMap);
		sideSquare(p1, p4, sideMap);
		sideSquare(p2, p3, sideMap);
		sideSquare(p2, p4, sideMap);
		sideSquare(p3, p4, sideMap);
		

		for(Entry<Integer, Integer> entry : sideMap.entrySet()) {
			if(entry.getValue()%2 !=0) {
				//unequal side found
				return false;
			}
		}
		
		return true;
	}


	private void sideSquare(int[] p1, int[] p2, HashMap<Integer, Integer> sideMap) {
		int dx = Math.abs(p1[0]-p2[0]);
		int dy = Math.abs(p1[1]-p2[1]);
		int sum = dx*dx+dy*dy;
		Integer value = null;
		if(sideMap.containsKey(sum)) {
			value = sideMap.get(sum)+1;
		} else {
			value = new Integer(1);
		}
		sideMap.put(sum, value);
	}
}
