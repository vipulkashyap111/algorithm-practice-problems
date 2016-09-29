package practice;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length == 0)
			return true;
		if (nums.length == 1)
			return true;
		int prev = 0, curr = 0;
		int start = 1;
		int end = nums[curr];
		int next = start;
		int max = nums[0];
		while (start <= end) {
			if ((nums.length - 1 - curr) <= max)
				return true;
			max = 0;			
			for (int i = start; i <= end && i < nums.length; i++) {
				if (max <= nums[i]) {
					max = nums[i];
					next = i;
				}
			}
			prev = curr;
			curr = next;
			start = prev + nums[prev] + 1;
			end = nums[next] + next;
			
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGame j = new JumpGame();
		int[] a = {4,2,0,0,1,1,4,4,4,0,4,0};
		j.canJump(a);
	}
}
