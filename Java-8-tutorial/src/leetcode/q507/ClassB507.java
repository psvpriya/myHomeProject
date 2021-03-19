package leetcode.q507;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ClassB507 {

	public boolean checkPerfectNumber(int num) {

		//special handling of 1
		if(num == 1) {
			return false;
		}
		Set<Integer> divisors = getDivisors(num);
		int sum = divisors.stream().reduce(Integer::sum).orElse(new Integer(0)).intValue();
		
		if(sum == num) {
			return true;
		}
		return false;
	}

	public Set<Integer> getDivisors(int num){
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		divisors.add(1);

		int divident = num;

		//Step 1 : getting all primary divisors
		//eg for 28 -> 1, 2, 2, 7 (all except the number itself)
		while(divident>1) {
			for(int i=2; i<=divident; i++) {
				if(divident %i == 0) {
					divisors.add(i);
					divident = divident/i;
					break;
				}
			}
		}
		
		Set<Integer> uniqueDivisors = new HashSet<Integer>();
		uniqueDivisors.addAll(divisors);
		/*
		 * Then using the primary divisors the secondary divisors are created
		 * The is done by cross multiplying all the dividents to each other
		 * eg for 28 -> 1, 2, 4, 7, 14
		 */
		for(int group = 2; group<divisors.size(); group++) {
			for(int i=0; i+group<=divisors.size(); i++) {
				int value = divisors.subList(i, i+group).stream().reduce(1, Math::multiplyExact);
				if(value>0 && value<num && !uniqueDivisors.contains(value)) {
					uniqueDivisors.add(value);
				}
			}
		}
		
		//divisors.addAll(uniqueDivisors);

		return uniqueDivisors;
	}

	
	
}
