package leetcode.q507;

import java.util.HashSet;
import java.util.Set;

public class ClassA507 {


	public boolean checkPerfectNumber(int num) {

		Set<Integer> divisors = getDivisors(num);
		int sum = divisors.stream().reduce(Integer::sum).orElse(new Integer(0)).intValue();
		
		if(sum == num) {
			return true;
		}
		return false;
	}

	public Set<Integer> getDivisors(int num){
		Set<Integer> divisors = new HashSet<Integer>();
		
		for(int i=1; i<num; i++) {
			if(num%i ==0) {
				divisors.add(i);
			}
		}
		return divisors;
	}


}
