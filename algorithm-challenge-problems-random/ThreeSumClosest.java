package practice;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int j = 1;
        int k = nums.length-1;
        int sum=0;
        int ans = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++){
             j = i+1;
            k = nums.length-1;
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                
                if(Math.abs(target-sum)<Math.abs(target-ans)){
                    ans = sum;
                    if(ans==target)
                        return ans;
                }
                
                 if (sum<target)
					j++;
				else
					k--;
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		ThreeSumClosest obj = new ThreeSumClosest();
		int[] a = { 0,1,2};
		obj.threeSumClosest(a,0);
	}
}
