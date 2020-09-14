package principles.java8.optional;

import java.util.Optional;

public class OptionalExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer a = null;
		Integer b = 45;
		
		Optional<Integer> optionalA = Optional.ofNullable(a);
		Optional<Integer> optionalB = Optional.ofNullable(b);
		
		
		System.out.println("A present : "+optionalA.isPresent());
		System.out.println("B present : "+optionalB.isPresent());
		
		Integer aa = optionalA.orElse(new Integer(0));
		Integer bb = optionalB.orElse(new Integer(0));

		
		System.out.println("Sum = "+Integer.sum(aa, bb));
		
		String nameA = "Vishnupriya";
		String nameB = null;
		
		Optional<String> optionalNameA = Optional.ofNullable(nameA);
		Optional<String> optionalNameB = Optional.ofNullable(nameB);
		
		optionalNameA.ifPresent(text -> System.out.println(text));
		optionalNameB.ifPresent(text -> System.out.println(text));
		
	}

}
