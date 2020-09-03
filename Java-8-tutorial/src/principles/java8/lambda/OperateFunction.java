package principles.java8.lambda;

@FunctionalInterface
public interface OperateFunction {
	
	public Object operate(double a, double b);
	
	public default void log(String str) {
		System.out.println("Logged : "+str);
	}
	
	public default void log(String action, String str) {
		System.out.println("Logged : "+action+" : "+str);
	}
	
	public static boolean isNull () {
		return true;
	}

}
