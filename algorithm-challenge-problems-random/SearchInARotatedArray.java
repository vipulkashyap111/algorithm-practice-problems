package practice;

public class SearchInARotatedArray {
	private int pivot = 0;
	

	public int search(int[] nums, int target) {
		if (nums.length == 1 && target == nums[0])
			return 0;
		findPivot(nums, 0, nums.length - 1);
		int start = (target<=nums[nums.length-1])?pivot:0;
		int end = (target>nums[nums.length-1])?pivot:nums.length-1;
		int res = -1,mid=0;
		while(start<=end){
			mid = (start+end)/2;
			if(nums[mid]==target)
				return mid;
			if(nums[mid]<target)
				start = mid+1;
			if(nums[mid]>target)
				end = mid-1;
		}
		return res;
	}

	
	public void findPivot(int[] a, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (a[start] > a[mid] && a[mid - 1] > a[mid]) {
				pivot = mid;
				return;
			}
			if (a[end] < a[mid] && a[mid + 1] < a[mid]) {
				pivot = mid + 1;
				return;
			}
			if (a[start] > a[mid])
				findPivot(a, start, mid - 1);
			else if (a[end] < a[mid])
				findPivot(a, mid + 1, end);
		}
	}

	public static void main(String[] args) {
		SearchInARotatedArray obj = new SearchInARotatedArray();
		int[] a = { 3,1};
		obj.findPivot(a, 0, a.length - 1);
		System.out.println(obj.pivot);
		int res = obj.search(a, 1);
		System.out.println(res);
	}
}
