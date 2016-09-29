package practice;
import java.util.*;
public class Permutation {
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(nums.length==0){
	            return res;
	        }
	        res = permuteNum(nums,nums.length-1);
	        return res;
	    }
	    
	    public List<List<Integer>> permuteNum(int[] nums, int index){
	        List<List<Integer>> perm= new ArrayList<List<Integer>>();
	        List<Integer> currSet = new ArrayList<Integer>();
	        if(index==0){
	        	currSet.add(nums[index]);
	            perm.add(new ArrayList<Integer>(currSet));
	            return perm;
	        }
	        
	        int curr = nums[index];
	        
	        if(index>0){
	        	List<List<Integer>> temp = permuteNum(nums,index-1);	            
	            for(List<Integer> set:temp){
	            	
	                for(int i = 0; i<=set.size();i++){
	                	currSet = new ArrayList<Integer>();
	                    currSet.addAll(set.subList(0, i));
	                    currSet.add(curr);
	                    currSet.addAll(set.subList(i, set.size()));
	                    perm.add(new ArrayList<Integer>(currSet));
	                }
	                
	            }
	            
	        }
	        	
	        return perm;
	    }
	    
	    public static void main(String[] args){
	    	Permutation obj = new Permutation();
	    	int[] nums = {1,2,3};
	    	obj.permute(nums);
	    }
}
