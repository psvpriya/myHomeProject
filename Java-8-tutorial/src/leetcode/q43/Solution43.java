package leetcode.q43;


public class Solution43 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operation43 obj = new ClassB43();
		Operation43 obj2 = new ClassA43();

		String num1 = "123";
		String num2 = "456";
		String output = null;
		output = obj.multiply(num1, num2);

		System.out.println("got     >>"+num1+" * "+num2+" = "+output);
		System.out.println("correct >>"+num1+" * "+num2+" = "+obj2.multiply(num1, num2));

		/*num1 = "0";
		num2 = "0";
		output = obj.multiply(num1, num2);

		System.out.println(num1+" * "+num2+" = "+output);


		num1 = "123456789";
		num2 = "987654321";
		output = obj.multiply(num1, num2);

		System.out.println("got     >>"+num1+" * "+num2+" = "+output);
		System.out.println("correct >>"+num1+" * "+num2+" = "+obj2.multiply(num1, num2));*/

	}




	
	


}
