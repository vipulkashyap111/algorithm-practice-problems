package practice;

public class SearchRange {
	int[] range = new int[2];
    public int[] searchRange(int[] nums, int target) {
        range[0]=range[1]=-1;
        if(nums.length==1){
            if(nums[0]==target){
                range[0]=range[1]=0;
            }
                
            return range;
        }
        bsearch(nums,0,nums.length-1,target);
        return range;
    }
    
    public void bsearch(int[] nums, int start, int end, int target){
        if(start<end){
           int mid = (start+end)/2;
            if(nums[mid]<target){
                bsearch(nums,mid+1,end,target);
            }else if(nums[mid]>target){
                bsearch(nums,start,mid,target);
            }else if(nums[mid]==target){
                if(nums[start]==target){
                	if(range[0]==-1)
            			range[0]=start;
                    range[0]=start<range[0]?start:range[0];
                    range[1]=mid>range[1]?mid:range[1];
                    bsearch(nums,mid+1,end,target);
                }
                if(nums[end]==target){
                	if(range[0]==-1)
            			range[0]=start;
                    range[1]=end>range[1]?end:range[1];
                    range[0]=end>range[1]?end:range[1];
                    bsearch(nums,start,mid,target);
                }
                else{
                    bsearch(nums,start,mid,target);
                    bsearch(nums,mid+1,end,target);
                }
                
            }
        }else if(start==end){
        	if(nums[start]==target){
        		if(range[0]==-1)
        			range[0]=start;
        		range[0]=start<range[0]?start:range[0];
        		range[1]=end>range[1]?end:range[1];
        	}
        }
        
    }
    
    public static void main(String[] args){
    	SearchRange obj = new SearchRange();
    	int[] a = {1,2,3,3,3,3,4,5,9};
    	obj.searchRange(a, 3);
    }
}
