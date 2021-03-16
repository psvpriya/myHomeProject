package leetcode.q1;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 obj = new Solution1();
		int[] a = {2,7,11,15};
		System.out.println(obj.twoSum(a, 9));

	}

	public int[] twoSum(int[] nums, int target) {

		int[] output = new int[2];
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(i!=j && Math.addExact(nums[i], nums[j]) == target) {
					output[0] = i;
					output[1] = j;
					return output;
				}
			}
		}
		return output;
	}

}
