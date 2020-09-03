package principles.java8.lambda;

import java.util.function.Function;

public class LambdaExerciseOne {

	
	public static void main(String[] args) {
		
		Operations op = new Operations();
		
		MyInterface aBlockOfCode = (a,b) -> System.out.println("Hello world");
		aBlockOfCode.testMethod(1, 2);
		
		MyInterface newBlockCode = (a, b ) -> System.out.println("Sum of numbers = "+(a+b));
		newBlockCode.testMethod(1,2);
		
		//System.out.println(op.addition.operate(2, 3));
		op.addition.log("addition",op.addition.operate(2, 3).toString());
		System.out.println(op.multiplication.operate(2, 3));
		System.out.println(op.substraction.operate(5, 3));
		
		TestImplementation test = new TestImplementation();
		System.out.println("Test OPeration output : "+test.operate(2, 3));
		test.log("Test operation", test.operate(2, 3).toString());
	}
	
}
