package leetcode.q43;

import java.util.Arrays;

public class ClassB43 implements Operation43{


	public String multiply(String num1, String num2) {
		
		//multiplication need to proceed only if the numbers contain any non zero digits

		int size = Math.max(num1.length(), num2.length());

		int[] a = new int[size];
		for(int i=num1.length()-1, j=size-1; j>=0; i--, j--) {
			a[j] = i>=0 ? Character.getNumericValue(num1.charAt(i)) : 0;
		}

		int[] b = new int[size];
		for(int i=num2.length()-1, j=size-1;  j>=0; i--, j--) {
			b[j] = i>=0 ? Character.getNumericValue(num2.charAt(i)) : 0;
		}

		StringBuffer output = new StringBuffer();
		
		int carry = 0;
		for(int counter = size-1;counter>=0; counter--) {
			int[] tempa = Arrays.copyOfRange(a, counter, size);
			int[] tempb = Arrays.copyOfRange(b, counter, size);
			Integer temp = getDigitForUnequalArray(tempa, tempb, carry);
			carry = temp/10;
			output.insert(0, temp%10);
		}
		
		for(int counter = size-1;counter>0; counter--) {
			int[] tempa = Arrays.copyOfRange(a, 0, counter);
			int[] tempb = Arrays.copyOfRange(b, 0, counter);
			Integer temp = getDigitForUnequalArray(tempa, tempb, carry);
			carry = temp/10;
			output.insert(0, temp%10);
		}
		if(carry !=0) {
			output.insert(0, carry);
		}
		
		//remove zeros before the string
		for(int i=0; i<output.length(); i++) {
			if(output.charAt(i) != '0') {
				return output.substring(i, output.length()).toString();
			}
		}
		
		
		return "0";

	}


	public Integer junitTestgetDigit(int[] a, int[] b, int carry) {
		return getDigitForEqualArray(a, b, carry);
	}

	public Integer junitTestgetDigitForUnequalArray(int[] a, int[] b, int carry) {
		return getDigitForUnequalArray(a, b, carry);
	}

	/**
	 * The method expects not null, not empty equal sized int array parameters a and b
	 * @param a int[] not null and not empty
	 * @param b int[] not null and not empty
	 * @param carry any carry forward from previous digit
	 * @return is a number with its 0th position as the
	 *  required digit and 1st position as the carry for next operation
	 */
	private Integer getDigitForEqualArray(int[] a, int[] b, int carry) {

		if(a.length != b.length) {
			throw new RuntimeException("the size incompatable for multiplication. Padding of zero missing");
		}
		int size = a.length;
		int sum = 0;
		//int midpoint = (size%2==0) ? size/2 : (size/2)+1;

		for(int i=0, j=size-1; i<size; i++, j--) {
			sum = sum + a[i]*b[j];
		}

		return sum+carry;
	}

	private Integer getDigitForUnequalArray(int[] a, int[] b, int carry) {

		int aSize = a.length;
		int bSize = b.length; 

		int sum = 0;
		if(aSize ==0 || bSize ==0) {
			return 0;
		}

		for(int i=0, j=bSize-1; i<aSize && j >= 0; i++, j--) {
			sum = sum + a[i]*b[j];
		}

		return sum+carry;
	}


}
