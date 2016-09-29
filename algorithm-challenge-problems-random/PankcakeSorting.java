package practice;

import java.util.LinkedList;

public class PankcakeSorting {
	public void pancakeSort1(int[] a) {
		int n = a.length;
		int maxIndex = 0;
		for (int i = 0; i < n - 1; i++) {
			maxIndex = 0;
			for (int j = 1; j < n - i; j++) {
				if (a[j] > a[maxIndex]) {
					maxIndex = j;
				}
			}
			flip(a, maxIndex);
			flip(a, n - i - 1);
		}
	}

	public void pancakeSort2(int[] a) {
		int n = a.length;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				j = bsearch(a, a[i], 0, i - 1);
				if(j!=-1){
					flip(a,j-1);
					flip(a,i-1);
					flip(a,i);
					flip(a,j);
				}
			}
		}
	}

	public int bsearch(int[] a, int target, int start, int end) {
		if (target < a[start])
			return start;
		int mid = (start + end) / 2;
		if (a[mid] == target)
			return mid;
		if (a[mid] < target) {
			if ((mid + 1) <= end && a[mid + 1] > target)
				return mid + 1;
			else
				return bsearch(a, target, mid + 1, end);
		}
		if (a[mid] > target) {
			if (mid - 1 >= start && a[mid - 1] < target)
				return mid;
			else
				return bsearch(a, target, start, mid - 1);
		}
		return -1;
	}

	public void flip(int[] a, int index) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = index; i >= 0; i--)
			list.offer(a[i]);
		for (int i = 0; i <= index; i++)
			a[i] = list.removeFirst();

	}

	public static void main(String[] args) {
		PankcakeSorting obj = new PankcakeSorting();
		int[] a = { 5, 3, 4, 1, 6, 2 };
		obj.pancakeSort2(a);
		for (int i : a)
			System.out.print(i + " ");
	}
}
