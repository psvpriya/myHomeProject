package leetcode.q507;

import java.util.ArrayList;

public class ClassC507 {
	
	public boolean checkPerfectNumber(int num) {
        
		
		ArrayList<String> divisorList = new ArrayList<String>(); 
		for(int i=1; i<num; i++) {
			
			
			if(num%i == 0) {
				int y = num/i;
				divisorList.add(i+","+y);
			}
		}
		return false;
    }


}
