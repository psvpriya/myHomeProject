package principles.java8.lambda;

public interface OperateChildFunction extends OperateFunction{

	
	public default void log(String str) {
		System.out.println("Logged child : "+str);
	}
	
	public default void log(String action, String str) {
		System.out.println("Logged child : "+action+" : "+str);
	}
}
