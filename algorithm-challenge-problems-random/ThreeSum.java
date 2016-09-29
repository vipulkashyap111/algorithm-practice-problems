package practice;

import java.util.*;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		if (nums.length == 0)
			return res;

		Arrays.sort(nums);
		int j, k;
		j = k = 0;
		int sum = 0;
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			j = i + 1;
			k = n - 1;
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
					if (!(res.contains(list)))
						res.add(list);
					list = new ArrayList<Integer>();
				} else if (sum > 0) {
					k--;
				} else
					j++;
			}
		}

		return res;

	}

	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		int[] a = { 0, -4, -1, -4, -2, -3, 2 };
		obj.threeSum(a);
	}
}
