package practice;

public class NextPermutation {
	 public void reverse(int[] nums, int start, int end){
	        int temp = 0;
	        while(start<end){
	            temp = nums[start];
	            nums[start]=nums[end];
	            nums[end] = temp;
	            start++;
	            end--;
	        }
	    }
	    
	    public void nextPermutation(int[] nums) {
	        int n = nums.length;
	        int smallIndex, nextIndex, temp;
	        smallIndex = nextIndex = temp = -1;
	        boolean flag = false;
	        for(int i=n-1; i>0; i--){
	            if(nums[i]>nums[i-1]){
	                flag = true;
	                smallIndex = i-1;
	                nextIndex = i;
	                break;
	            }
	        }
	        
	        if(!flag){
	            //Reverse numbers in the array
	            reverse(nums,0,n-1);
	        }
	        else{
	            for(int i = nextIndex+1;i<n;i++){
	                if(nums[i]>nums[smallIndex] && nums[i]<=nums[nextIndex]){
	                    nextIndex = i;
	                }
	            }
	            temp = nums[nextIndex];
	            nums[nextIndex] = nums[smallIndex];
	            nums[smallIndex] = temp;
	            reverse(nums,smallIndex+1,n-1);
	        }
	        
	        
	    }
	    
	    public static void main(String[] args){
	    	//Define main
	    }
}
