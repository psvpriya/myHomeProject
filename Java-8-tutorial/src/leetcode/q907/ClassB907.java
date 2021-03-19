package leetcode.q907;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterator;

public class ClassB907 {


	public int sumSubarrayMins(int[] arr) {

		int M = 1000000007;
		int sum = 0;
		Integer level = 0;
		LinkedList<Element> list = new LinkedList<Element>();
		for(int i=0; i<arr.length; i++) {
			list.add(new Element(arr[i], level));
		}

		level++;
		while(!list.isEmpty()) {
			Element a = list.removeFirst();
			sum = sum%M + a.getNumber()%M;
			Element b = list.peekFirst();

			if(b !=null) { //during the last element scenario
				if(a.getLevel() != b.getLevel()) {
					// no new element to be added into list. only level increment
					level++;
				} else {
					list.add(new Element(Math.min(a.getNumber(), b.getNumber()), level));
				}
			}
		}


		return sum%M;   

	}

	public class Element{
		private int number= -1;
		private int level = -1 ;

		public Element(int number, int level) {
			super();
			this.number = number;
			this.level = level;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		@Override
		public String toString() {
			return "Element [" + number + ", " + level + "]";
		}


	}



}
