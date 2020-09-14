package principles.java8.stream.one;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExercise1 {
	
	public static void main(String[] args) {
		
		String[] names = {"Barbara", "James", "Mary","Johns","Catherine", "Cristopher"};
		
		System.out.println("---------------- Display 1 ----------------");
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println("---------------- Display 2 ----------------");
		System.out.println(Arrays.asList(names));
		
		System.out.println("---------------- Display 3 ----------------");
		Arrays.asList(names).forEach(s -> System.out.println(s));
		
		System.out.println("---------------- Display 4 ----------------");
		Arrays.asList(names).forEach(System.out::println);
		
		System.out.println("---------------- Display 5 ----------------");
		Stream.of(names).forEach(System.out::println);
		
		System.out.println("---------------- Display 6 ----------------");
		System.out.println(Arrays.toString(Arrays.stream(new int[] {1,2,3,4}).map(n-> 2*(n+1)).toArray()));
		
		System.out.println("---------------- Display 7 ----------------");
		String[] list = {"10Apple","01Kale","05Banana","15Egg"};
		System.out.println(Arrays.asList(Stream.of(list).map(x-> x.substring(0, 2)).toArray()));
		
		Stream.of(list).map(x -> 
		new StringBuffer().append(x.substring(0, 2)).append("\t").append(x.substring(2, x.length()))
		).forEach(x-> System.out.println(x));
		
		
		System.out.println(IntStream.range(1, 4).average().getAsDouble());
		IntStream.range(1, 4).mapToObj(x -> "a"+x).forEach(System.out::println);
		
		System.out.println("---------------- Processing Order ----------------");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		
		System.out.println("---------------- Processing Order 2----------------");
		Stream.of("d2", "a2", "b1", "b3","c")
		.map(x-> {
			System.out.println("mapping : "+x);
			return x.toUpperCase();})
		.filter(s -> {
			System.out.println("filter : "+s); 
			return s.startsWith("A");})
		.forEach(x -> {
			System.out.println("forEach : "+x);
			
		});
		

		System.out.println("---------------- Processing Order 2 effeciently----------------");
		Stream.of("d2", "a2", "b1", "b3","c")
		.filter(s -> {
			System.out.println("filter : "+s); 
			return s.startsWith("a");})
		.map(x-> {
			System.out.println("mapping : "+x);
			return x.toUpperCase();})
		.forEach(x -> {
			System.out.println("forEach : "+x);
			
		});
	}

}
