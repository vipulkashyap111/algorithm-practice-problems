package practice;
import java.util.*;
public class AllSubsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0)
            return res;
        Arrays.sort(nums);
        res = getSubsets(nums, nums.length);
        return res; 
    }
    
    public List<List<Integer>> getSubsets(int[] nums, int index){
        List<List<Integer>> res;
        if(index==0){
            res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        res = getSubsets(nums, index-1);
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        int n = nums[index-1];
        for(List<Integer> temp:res){
            List<Integer> set = new ArrayList<Integer>();
            set.addAll(temp);
            set.add(n);
            sets.add(set);
        }
        sets.addAll(res);
        return sets;
    }
    
    public static void main(String[] args){
    	AllSubsets o = new AllSubsets();
    	int[] nums = {1,2};
    	o.subsets(nums);
    }
    
}
