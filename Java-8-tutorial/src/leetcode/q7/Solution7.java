package leetcode.q7;

import javax.xml.bind.TypeConstraintException;

public class Solution7 {
	
	Integer reverse = new Integer(0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution7 obj = new Solution7();
		int input = 1534236469;
		System.out.println("input : "+input);
		System.out.println("output : "+obj.reverse(input));
		
		input = -123;
		System.out.println("input : "+input);
		System.out.println("output : "+obj.reverse(input));
	}



	public int reverse(int x) {

		try {
			reverseHelper(x);
			
		} catch(ArithmeticException e) {
			reverse = 0;
		}

		return reverse;
	}

	private void reverseHelper(int x){
		int d = x/10;
		int r = x%10;
	
		reverse = Math.multiplyExact(reverse.intValue(), 10) + r;
		System.out.println("d = "+d+" ; r = "+r+" ; reverse = "+reverse.intValue());
		
		if(d==0){
			return;
		}
		reverseHelper(d);
	}

}
