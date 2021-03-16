package leetcode.q1031;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionTwo {
	ArrayList<Integer> alist = null;
	ArrayList<Integer> llist = null;
	ArrayList<Integer> mlist = null;
	private HashMap<Integer, ArrayList<Integer>> lindexMap = null;
	private HashMap<Integer, ArrayList<Integer>> mindexMap = null;
	
	private HashMap<ArrayList<Integer>, Integer> lMap = null;
	private HashMap<ArrayList<Integer>, Integer> mMap = null;
	
	int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SolutionTwo two = new SolutionTwo();
		
		int l = 0;
		int m = 0;
		
		/*int[] c = {0,6,5,2,2,5,1,9,4};
		l = 1;
		m = 2;
		System.out.println("MAX = "+two.maxSumTwoNoOverlap(c, l, m));
		
		int[] a = {3,8,1,3,2,1,8,9,0};
		l = 3;
		m = 2;
		System.out.println("MAX = "+two.maxSumTwoNoOverlap(a, l, m));
		
		int[] b = {2,1,5,6,0,9,5,0,3,8};
		l = 4;
		m = 3;
		System.out.println("MAX = "+two.maxSumTwoNoOverlap(b, l, m));
		
		int[] d = {4,0,1};
		l = 2;
		m = 1;
		System.out.println("MAX = "+two.maxSumTwoNoOverlap(d, l, m));
		
		int[] e = {8,20,6,2,20,17,6,3,20,8,12};
		l = 5;
		m = 4;
		System.out.println("MAX = "+two.maxSumTwoNoOverlap(e, l, m)); //expected 105
		
		*/
		
		int[] f = {338,31,208,306,897,279,348,999,957,312,393,542,166,401,519,653,362,823,989,654,929,290,216,376,115,731,887,475,854,562,459,863,555,498,177,159,180,854,839,309,71,43,654,42,293,611,629,688,878,602,8,872,165,217,622,985,218,377,707,29,508,993,115,805,403,229,386,142,427,493,924,567,916,65,584,842,408,526,176,24,891,503,415,180,132,378,921,46,591,255,697,935,638,554,839,825,305,811,462,45,200,429,39,563,322,798,325,44,827,132,789,698,870,696,477,378,628,462,551,793,674,424,218,371,384,347,859,676,320,350,806,498,117,842,469,634,740,944,955,889,798,862,413,966,812,561,102,969,559,975,300,284,815,207,855,240,172,615,433,824,628,519,251,235,449,796,489,857,234,875,828,971,589,721,195,596,470,92,740,981,759,746,821,239,658,330,420,662,501,852,175,967,690,935,316,466,354,335,846,825,589,372,544,796,667,433,584,234,170,185,491,121,370,558,656,600,965,48,405,54,986,77,641,957,154,864,319,276,67,796,492,574,546,238,313,73,308,678,53,719,809,112,293,463,83,292,174,642,63,672,583,764,185,30,84,628,612,908,406,525,688,930,262,977,580,976,768,69,514,546,966,526,784,139,361,487,378,42,903,845,622,501,75,700,239,559,508,618,494,601,655,173,179,451,604,69,658,235,400,232};
		l=28;
		m=109;
		System.out.println("MAX = "+two.maxSumTwoNoOverlap(f, l, m)); 
		
		
	}

	/**
	 * Algorithm
	 * 
	 * Step 1 : Iterate over A, make list of arrays of size l and m respectively.
	 * @param a
	 * @param l
	 * @param m
	 * @return
	 */
	public int maxSumTwoNoOverlap(int[] a, int l, int m) {
		dataFOrmat(a, l, m);
		//The max value comparison fails in teh border sceanrio where the sum ives max but does not necessarily contain the max values
		//return findMaxByMaxofListComparison();
		
		//The max is by plain comparison of nonoverlapping elements. But this fails due to time limit exceed
		//return findMaxByComparison();		
		
		return findByMapValuesComparison();
	}
	
	private void dataFOrmat(int[] a, int l, int m) {
		alist = new ArrayList<Integer>();
		/*llist = new ArrayList<Integer>();
		lindexMap = new HashMap<Integer, ArrayList<Integer>>();
		mlist = new ArrayList<Integer>();
		mindexMap = new HashMap<Integer, ArrayList<Integer>>();*/
		
		lMap = new HashMap<ArrayList<Integer>, Integer>();
		mMap = new HashMap<ArrayList<Integer>, Integer>();
		for(int i=0; i<a.length ; i++) {
			alist.add(a[i]);
		}
		for(int i=0; i<alist.size() ; i++) {
			if(i+l<=alist.size()) {
				//the function excludes i+l th element
				int sum = IntStream.range(i, i+l).map(x -> alist.get(x)).sum();
				//llist.add(sum);
				ArrayList<Integer> tt = (ArrayList)IntStream.range(i, i+l).mapToObj(x -> new Integer(x))
						.collect(Collectors.toList());

				//lindexMap.put(i, tt);
				lMap.put(tt, sum);
			} else {
				//llist.add(0);
				//lindexMap.put(i, null);
			}
			if(i+m<=alist.size()) {
				//the function excludes i+m th element
				int sum = IntStream.range(i, i+m).map(x -> alist.get(x)).sum();
				//mlist.add(sum);
				ArrayList<Integer> tt = (ArrayList)IntStream.range(i, i+m).mapToObj(x -> new Integer(x))
						.collect(Collectors.toList());

				//mindexMap.put(i, tt);
				mMap.put(tt, sum);
			} else {
				//mlist.add(0);
				//mindexMap.put(i, null);
			}
		}
		System.out.println("alist "+alist);
		//System.out.println("llist "+llist);
		//System.out.println("lindexMap "+lindexMap);
		//System.out.println("mlist "+mlist);
		//System.out.println("mindexMap "+mindexMap);
		
		System.out.println("lMap "+lMap);
		System.out.println("mMap "+mMap);
	}

	
	private boolean isOverlapped(int lIndex, int mIndex) {
		
		ArrayList<Integer> list1 = lindexMap.get(lIndex);
		ArrayList<Integer> list2 = mindexMap.get(mIndex);
		
		if(list1 == null || list2 == null) {
			return false;
		}
		
		Optional<Integer> overlap = list1.stream()
				.filter((Integer e) -> (list2.stream().filter((Integer d) -> e.intValue() == d.intValue()).count()) > 0)
				.findAny();
			    

		if(overlap.isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
	private int findMaxByMaxofListComparison() {
		int maxLIndex1 = -1;
		int maxMIndex1 = -1;
		for(int i=0; i<llist.size() ; i++) {
			if(maxLIndex1 == -1 || llist.get(i) > llist.get(maxLIndex1)) {
				maxLIndex1 = i;
			}
		}
		for(int i=0; i<mlist.size() ; i++) {
			if(!isOverlapped(maxLIndex1, i) && ( maxMIndex1 == -1  || mlist.get(i) > mlist.get(maxMIndex1))) {
				maxMIndex1 = i;
			}
		}
		System.out.println( " maxLIndex1 : "+maxLIndex1+";  maxMIndex1 : "+maxMIndex1+"; total : "
				+Integer.sum(llist.get(maxLIndex1), mlist.get(maxMIndex1)));



		int maxLIndex2 = -1;
		int maxMIndex2 = -1;
		for(int i=0; i<mlist.size() ; i++) {
			if(maxMIndex2 == -1 || mlist.get(i) > mlist.get(maxMIndex2)) {
				maxMIndex2 = i;
			}
		}
		for(int i=0; i<llist.size() ; i++) {
			if(!isOverlapped(i, maxMIndex2) && (maxLIndex2 == -1 || llist.get(i) > llist.get(maxLIndex2))) {
				maxLIndex2 = i;
			}
		}
		System.out.println( " maxMIndex2 : "+maxMIndex2+";  maxLIndex2 : "+maxLIndex2+"; total : "
				+Integer.sum(llist.get(maxLIndex2), mlist.get(maxMIndex2)));
		

		return Integer.max(Integer.sum(llist.get(maxLIndex1), mlist.get(maxMIndex1))
				, Integer.sum(llist.get(maxLIndex2), mlist.get(maxMIndex2)));
	}

	private int findMaxByComparison() {
		
		
		int sum = 0;
		for(int x=0; x<llist.size(); x++) {
			for(int y=0; y<mlist.size(); y++) {
				
				int temp = Integer.sum(llist.get(x),mlist.get(y));
				if(!isOverlapped(x, y) && sum<temp) {
					sum = temp;
				}
				
			}
		}
		
		System.out.println("----------------"+sum);
		
		return sum;
	}
	
	private int findByMapValuesComparison() {
		
		lMap.entrySet().stream().forEach(x -> {
			ArrayList<Integer> key = x.getKey();
			
			mMap.entrySet().stream()//.peek(xp -> System.out.println("test-----"+xp))
			.forEach(y -> {
				ArrayList<Integer> key2 = (ArrayList<Integer>) y.getKey().clone();
				key2.retainAll(key);
				if(key2.isEmpty()) {
					if(sum < x.getValue()+y.getValue()) {
						sum = x.getValue()+y.getValue();
					}
				}	
			});
			
		});
			
		return sum;
	}


}
