package practice;

import java.util.Scanner;

public class JumpGame2 {
	public int jump(int[] nums) {
		if(nums.length==0)
			return 0;
		int reach = nums[0];
		int i = 0;
		int nextMax = nums[0];
		int counter = 0;
		while(i<nums.length && nums[i]!=0){
			if(reach>=nums.length-1){
				counter++;
				return counter;
			}
				
			for(int j = i+1; j<=reach && j<nums.length;j++){
				if(j+nums[j]>=nextMax){
					nextMax = j+nums[j];					
					i=j;
				}
			}
			
			reach = nextMax;
			counter++;			
		}
		return Integer.MAX_VALUE;
	}	
	
	public static void main(String[] args) {
		JumpGame2 j = new JumpGame2();
		//int[] a = {5,9,3,2,1,0,2,3,2,1,0,0};
		//int[] a = {4,2,0,0,1,1,4,4,4,0,4,0};
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();
		System.out.println(j.jump(a));
	}
}
