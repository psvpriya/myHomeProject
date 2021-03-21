package leetcode.q266;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution266 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution266 obj = new Solution266();
		
		String a = "carerac";
		
		System.out.println(obj.canPermutePalindrome(a));

	}

	public boolean canPermutePalindrome(String s) {

		HashMap<Character, Integer> characterCountMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			Integer count = null;
			if(characterCountMap.containsKey(s.charAt(i))) {
				count = characterCountMap.get(s.charAt(i));
				count++;
			} else {
				count = 1;
			}
			characterCountMap.put(s.charAt(i), count);
		}
		//HashSet<Integer> numbers = new HashSet<Integer>(characterCountMap.values());
		long count = characterCountMap.values().stream().filter(n -> n%2!=0).count();
		if(count <= 1) {
			return true;
		} else {
			return false;
		}
		
	}

}
