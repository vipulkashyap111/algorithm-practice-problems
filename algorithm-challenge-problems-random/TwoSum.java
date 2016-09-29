package practice;

import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>(nums.length);
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if(mapping.containsKey(nums[i])){
				res[1] = i+1;
				res[0] = mapping.get(nums[i]);
			}
			else
				mapping.put(target - nums[i], (i+1));
		}
		return res;
	}
	
	public static void main(String args[]){
		int[] a = {3,2,4};
		int[] res = twoSum(a, 6);
	}
}
