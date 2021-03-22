package leetcode.q1031;

import java.util.Arrays;

public class ClassA1031 {


	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		int sumMax=0;
		
		
		
		for(int i=0; i<A.length; i++) {
			int[] part0 = new int[0];
			int[] part1 = new int[0];
			int[] part2 = new int[0];

			int index1 = i+Math.max(M, L);

			part0 = Arrays.copyOfRange(A, 0, i);
			if(i>=0 && i<A.length && index1<=A.length) {
				part1 = Arrays.copyOfRange(A, i, index1);
			}
			if(part1.length == 0) {
				break;
			}
			if(index1>=0 && index1<=A.length) {
				part2 = Arrays.copyOfRange(A, index1, A.length);
			}
			//System.out.println(Arrays.toString(part0)+"--"+Arrays.toString(part1)+"--"+Arrays.toString(part2));
			
			int sum0 = maxSum(part0, Math.min(M, L));
			int sum1 = Arrays.stream(part1).reduce((a,b)->a+b).orElse(0);
			int sum2 = maxSum(part2, Math.min(M, L));
			//System.out.println(sum0+"--"+sum1+"--"+sum2);

			int sum = Math.max(sum0, sum2)+sum1;
			if(sumMax < sum) {
				sumMax = sum;
			}
		}


		return sumMax;
	}

	private int maxSum(int[] x, int size) {
		int sum = 0;
		if(x!=null && x.length >0) {
			for(int i=0; (i+size)<=x.length; i++) {
				int data = Arrays.stream(Arrays.copyOfRange(x, i, i+size)).reduce((a,b)->a+b).orElse(0);
				if(sum<data) {
					sum = data;
				}
			}
		}
		return sum;
	}

}
