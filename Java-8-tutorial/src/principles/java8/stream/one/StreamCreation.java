package principles.java8.stream.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * In this class we look at various stream creation methods
 */
public class StreamCreation {
	
	public static void main(String[] args) {
		
		
		Stream<Integer> a = Stream.of(1, 2, 3, 4, 5, 6);
		a.forEach(System.out::print);
		System.out.println();
		
		Stream<String> b = Stream.of("Apple"," ","is"," ","a"," ","fruit");
		b.forEach(System.out::print);
		System.out.println();
		
				
		List<Integer> c = new ArrayList<Integer>();
		for(int i=1; i<10;i++) {
			c.add(i);
		}
		Stream<Integer> d = c.stream();
		d.forEach(System.out::print);
		System.out.println();
		
		String[] names = new String[] {"Sreekumar","Mini","Krishnapriya","Vishnupriya"};
		Stream<String> e = Stream.of(names);
		e.forEach(System.out::println);
		
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
		randomNumbers.limit(5).forEach(System.out::print);
		System.out.println();
		System.out.println("--------------------------------");
		
		IntStream f = "12345_abcdefgI love my india".chars();
		f.forEach(System.out::println);
		
		
		List<Integer> test1 = Stream.of(1,2,3,4,5,6).collect(Collectors.toList());
		List<Integer> test2 = IntStream.of(1,2,3,4,5).boxed()
			    .collect(Collectors.toList());
	}

}
