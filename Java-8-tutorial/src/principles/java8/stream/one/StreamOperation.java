package principles.java8.stream.one;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperation {

	public static void main(String[] args) {


		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
		
		/* Filters
		 * 
		 * Filter all members starting with A
		 */
		memberNames.stream().filter((s)-> s.startsWith("A")).forEach(System.out::println);
		memberNames.stream().filter((s)-> s.startsWith("a")).forEach(System.out::println);
		

		/* Map
		 * 
		 */
		memberNames.stream().map((x)-> x+" : Class 10").forEach(System.out::println);
		
		//"Vishnu".chars().mapToObj(item -> (char) item).forEach(System.out::println);
		memberNames.stream().map(x -> x.replace("a", "A")).forEach(System.out::println);
		
		Stream<Integer> numbers = Stream.of(1,2,3,4,5);
		Integer sumValue = Stream.of(1,2,3,4,5).reduce(0, Integer::sum);
		System.out.println("sumValue : "+sumValue);
		
		Integer sumTerminal = Stream.of(1,2,3,4,5).collect(Collectors.summingInt(x -> x.intValue()));
		System.out.println("sumTerminal : "+sumTerminal);
		
		Integer sumNew1 = Stream.of(1,2,3,4,5).collect(Collectors.reducing(0, Integer::sum));
		System.out.println("sumNew1 : "+sumNew1);
		
		
		
		
	}

}
