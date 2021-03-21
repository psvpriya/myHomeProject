package leetcode.q1228;

public class ClassB1228 {
	
	
	
	
	
	//implement using binary search.
	
	public int missingNumber(int arr[]) {
       int len = arr.length;
       
       int diff = (arr[len-1]-arr[0])/(len);
       
       int indexL =0;
       int indexH = len-1;
       
       while(indexL < indexH) {
    	   int mid = (indexH+indexL)/2;
    	   
    	   int expected = arr[0]+mid*diff;
       }
       
       return 0;
       
    }
	
	
	

}
