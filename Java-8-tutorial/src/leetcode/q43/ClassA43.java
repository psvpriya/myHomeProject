package leetcode.q43;

import java.math.BigInteger;

public class ClassA43 implements Operation43{

	
	public String multiply(String num1, String num2) {

		BigInteger bi1, bi2, bi3;
		bi1 = new BigInteger(num1);
		bi2 = new BigInteger(num2);

		bi3 = bi1.multiply(bi2);
		return bi3.toString();
	}

	
}
