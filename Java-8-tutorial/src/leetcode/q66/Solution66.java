package leetcode.q66;

import java.util.Objects;

public class Solution66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] digits = {1, 2, 3};
		System.out.println(plusOne(digits));

	}
	
	public static int[] plusOne(int[] digits) {

		boolean isOverflow = false;
		int len = digits.length;
		do {
			
			int dig = digits[len-1];
			if(dig == 9) {
				digits[len-1] = 0;
				isOverflow = true;
			} else {
				digits[len-1] = dig+1;
				isOverflow = false;
			}
			
			len--;
		} while (isOverflow && len>0);
		
		if(isOverflow && len == 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0]=1;
			
			for(int i=0; i<digits.length; i++) {
				newDigits[i+1]=digits[i];
			}
			return newDigits;
			
		}
		
		return digits;
	}

}
