package leetcode.q1031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionTwoTrial2 {

	public static void main(String[] args) {
		SolutionTwoTrial2 obj  = new SolutionTwoTrial2();


		int l = 0;
		int m = 0;

		int[] c = {0,6,5,2,2,5,1,9,4};
		l = 1;
		m = 2;
		System.out.println("MAX = "+obj.maxSumTwoNoOverlap(c, l, m));


		int[] a = {3,8,1,3,2,1,8,9,0};
		l = 3;
		m = 2;
		System.out.println("MAX = "+obj.maxSumTwoNoOverlap(a, l, m));

		int[] b = {2,1,5,6,0,9,5,0,3,8};
		l = 4;
		m = 3;
		System.out.println("MAX = "+obj.maxSumTwoNoOverlap(b, l, m));

		int[] d = {4,0,1};
		l = 2;
		m = 1;
		System.out.println("MAX = "+obj.maxSumTwoNoOverlap(d, l, m));

		int[] e = {8,20,6,2,20,17,6,3,20,8,12};
		l = 5;
		m = 4;
		System.out.println("MAX = "+obj.maxSumTwoNoOverlap(e, l, m)); //expected 105



		int[] f = {338,31,208,306,897,279,348,999,957,312,393,542,166,401,519,653,362,823,989,654,929,290,216,376,115,731,887,475,854,562,459,863,555,498,177,159,180,854,839,309,71,43,654,42,293,611,629,688,878,602,8,872,165,217,622,985,218,377,707,29,508,993,115,805,403,229,386,142,427,493,924,567,916,65,584,842,408,526,176,24,891,503,415,180,132,378,921,46,591,255,697,935,638,554,839,825,305,811,462,45,200,429,39,563,322,798,325,44,827,132,789,698,870,696,477,378,628,462,551,793,674,424,218,371,384,347,859,676,320,350,806,498,117,842,469,634,740,944,955,889,798,862,413,966,812,561,102,969,559,975,300,284,815,207,855,240,172,615,433,824,628,519,251,235,449,796,489,857,234,875,828,971,589,721,195,596,470,92,740,981,759,746,821,239,658,330,420,662,501,852,175,967,690,935,316,466,354,335,846,825,589,372,544,796,667,433,584,234,170,185,491,121,370,558,656,600,965,48,405,54,986,77,641,957,154,864,319,276,67,796,492,574,546,238,313,73,308,678,53,719,809,112,293,463,83,292,174,642,63,672,583,764,185,30,84,628,612,908,406,525,688,930,262,977,580,976,768,69,514,546,966,526,784,139,361,487,378,42,903,845,622,501,75,700,239,559,508,618,494,601,655,173,179,451,604,69,658,235,400,232};
		l=28;
		m=109;
		System.out.println("MAX = "+obj.maxSumTwoNoOverlap(f, l, m)); 

		int[] g = {3,8,1,3,2,1,8,9,0};
		l= 3;
		m=2;
		System.out.println("MAX = "+obj.maxSumTwoNoOverlap(g, l, m)); //expected 29

	}


	public int maxSumTwoNoOverlapMine(int[] a, int l, int m) {


		ArrayList<Integer> alist = new ArrayList<Integer>();


		for(int i=0; i<a.length ; i++) {
			alist.add(a[i]);
		}
		int sum = 0;

		System.out.println("number = "+alist);
		//Case1 : l array before m array
		for(int i=0; i<alist.size() ; i++) {
			if(i+l<=alist.size()) {
				ArrayList<Integer> lindex = (ArrayList)IntStream.range(i, i+l).mapToObj(x -> new Integer(x))
						.collect(Collectors.toList());
				List<Integer> list1 = alist.subList(0, i);
				List<Integer> list2 = alist.subList(i, i+l);
				List<Integer> list3 = alist.subList(i+l, alist.size());


				//System.out.println("lindex = "+lindex);
				//System.out.println("subList"+list1+list2+list3);



				int sum1=0;
				if(list1.size() >= m) {
					for(int j=0; j+m-1<list1.size() ; j++) {
						int tempsum = IntStream.range(j, j+m).map(x -> list1.get(x)).sum();
						if(tempsum > sum1) {
							sum1 = tempsum;
						}
					}
				}

				int sum2 = list2.stream().reduce(0, Integer::sum);


				if(list3.size() >= m) {
					for(int j=0; j+m-1<list3.size() ; j++) {
						int tempsum = IntStream.range(j, j+m).map(x -> list3.get(x)).sum();
						if(tempsum > sum1) {
							sum1 = tempsum;
						}
					}
				}
				if(sum < (sum1+sum2)) {
					sum = sum1+sum2;
				}
				//System.out.println("sums -> "+sum1+" "+sum2);
				//System.out.println("sum -> "+sum);
			}
		}


		return sum;
	}


	public int maxSumTwoNoOverlap(int[] a, int L, int M) {
		int[] sum=new int[a.length];
		sum[0]=a[0];
		for(int i=1;i<a.length;i++) {
			sum[i]=sum[i-1]+a[i];
		}
		int lmax=sum[L-1];
		int mmax=sum[M-1];
		int res=sum[L+M-1];
		for(int i=L+M;i<a.length;i++){
			lmax=Math.max(lmax,sum[i-M]-sum[i-L-M]);
			mmax=Math.max(mmax,sum[i-L]-sum[i-L-M]);
			res=Math.max(res,Math.max(lmax+sum[i]-sum[i-M],mmax+sum[i]-sum[i-L]));
		}
		return res;
	}

}
