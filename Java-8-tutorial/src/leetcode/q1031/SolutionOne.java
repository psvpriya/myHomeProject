package leetcode.q1031;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionOne {

	public static void main(String[] args) {
		SolutionOne obj = new SolutionOne();
		
		String s = "the sky is blue";
		System.out.println(s +" -> "+obj.test(s));
		
		s = "  hello world  ";
		System.out.println(s +" -> "+obj.test(s));
		
		s= "a good   example";
		System.out.println(s +" -> "+obj.test(s));
		
		s= "  Bob    Loves  Alice   ";
		System.out.println(s +" -> "+obj.test(s));
		
		s= "Alice does not even like bob";
		System.out.println(s +" -> "+obj.test(s));

	}
	
	public String test(String s) {
		SolutionOne obj = new SolutionOne();
		//return obj.reverseWordsTwo(String)(s);
		return obj.reverseWordsThree(s);
	}

	public String reverseWords(String s) {
		s = s.trim();
		List<String> words = new ArrayList<String>();
		int start = 0;
		int end = 0;
		for(int index=0; index <s.length(); index++) {
			if(s.charAt(index) == ' ') {

				words.add(s.substring(start, end+1));

				words.add(s.substring(index, index+1));
				start = index+1;
			} else if(index == s.length()-1) {
					words.add(s.substring(start, index+1));
				start = index+1;
			}
			
			
			end = index;
		}
		
		Collections.reverse(words);
		
		return words.stream().collect(Collectors.joining());
	}
	
	
	public String reverseWordsNew(String s) {
		
		List<String> splits = Arrays.asList(s.trim().split("[\" \"]+"));
		Collections.reverse(splits);
		return splits.stream().collect(Collectors.joining(" "));
	}
	
	public String reverseWordsTwo(String s) {
	    
		List<String> splits = Arrays.asList(s.trim().split("[\" \"]+"));
		Deque<String> deque = new ArrayDeque<String>();
		for(String word : splits) {
			deque.addFirst(word);
		}
		//return String.join(" ", deque);
		
		return deque.stream().collect(Collectors.joining(" "));
	  }
	
	public String reverseWordsThree(String s) {
		s = s.trim();
		int startIndex = 0;
		Deque<String> deque = new ArrayDeque<String>();
		for(int i=0; i< s.length(); i++) {
			//if current character is a space
			if(s.charAt(i) == ' ') {
				//extract the word during each space encounter only if the previous character is not space
				//this is done to handle multiple space scenario
				if(s.charAt(i-1) != ' ') {
					String word = s.substring(startIndex, i);
					deque.addFirst(word);
				}
				startIndex = i+1;
			} 
			//This is to handle the last word of a string scenario, 
			//where loop does not meet with space char as terminating condition
			//instead the line length finishes
			else if(i == s.length()-1) {
				String word = s.substring(startIndex);
				deque.addFirst(word);
			}
		}
		
		
		return String.join(" ", deque);
	}

}
