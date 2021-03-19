package leetcode.q593;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClassAq593 {

	
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		Set<Integer> sideSquare = new HashSet<Integer>();
		sideSquare.add(sideSquare(p1, p2));
		sideSquare.add(sideSquare(p1, p3));
		sideSquare.add(sideSquare(p1, p4));
		sideSquare.add(sideSquare(p2, p3));
		sideSquare.add(sideSquare(p2, p4));
		sideSquare.add(sideSquare(p3, p4));

		if(sideSquare.size() > 2) {
			return false;
		}
		Iterator<Integer> itr = sideSquare.iterator();
		Integer side1 = itr.next();
		Integer side2 = itr.next();
		Integer side3 = 0;
		if(itr.hasNext()) {
			side3 = itr.next();
		}
		else {
			side3 = side1>side2?side2:side1;
		}

		if(side1+side2 == side3
				|| side1+side3 == side2
				|| side3+side2 == side1) {

			return true;
		} else {
			return false;
		}

	}


	private int sideSquare(int[] p1, int[] p2) {
		int dx = Math.abs(p1[0]-p2[0]);
		int dy = Math.abs(p1[1]-p2[1]);
		return dx*dx+dy*dy;
	}
	
}
