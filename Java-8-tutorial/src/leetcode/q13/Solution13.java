package leetcode.q13;

import java.util.ArrayList;

public class Solution13 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution13 obj = new Solution13();
		
		String s = "XIV";
		System.out.println(s+" = "+obj.romanToInt(s));

	}
	
	       
	
	public int romanToInt(String s) {
		ArrayList<Character> symbols = new ArrayList<Character>();
		symbols.add('I');symbols.add('V');symbols.add('X');symbols.add('L');symbols.add('C');symbols.add('D');symbols.add('M');
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(1);values.add(5);values.add(10);values.add(50);values.add(100);values.add(500);values.add(1000);
		
		int sum = 0;
		int substarct = 0;
		int currValue = -1;
		int futureValue = -1;
		
		for(int i=0; i<s.length(); i++) {

			if(currValue == -1) {
				currValue = values.get(symbols.indexOf(s.charAt(i)));
			}
			
			if(i+1 < s.length()) {
				futureValue = values.get(symbols.indexOf(s.charAt(i+1)));
			} else {
				futureValue = -1;
			}
			
			if(currValue < futureValue) {
				substarct = Math.addExact(substarct, currValue);
			} else {
				sum = Math.addExact(sum, currValue);
			}


			currValue = futureValue;
		}
		
		
		return sum-substarct;
	}
	 
	

}
