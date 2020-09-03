package principles.java8.lambda;

public class TestImplementation implements OperateChildFunction{

	@Override
	public Object operate(double a, double b) {
		//Step 1 : double each number
		//Step 2 : Sum of the doubles
		//Step 3 : half of the number
		return ((a*a)+(b*b))/2;
	}

	/*public void log(String action, String str) {
		System.out.println("Logged new overwritten: "+action+" : "+str);
	}*/
}
