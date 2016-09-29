package challenge;

import java.util.*;

public class ZigzagArray {

	static int[] wiggleArrangeArray(int[] intArr) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i:intArr)
        	arr.add(i);
        Collections.sort(arr);
        for(int i:arr){
        	System.out.print(i+" ");
        }
        System.out.println();
        int start = 0;
        int end = arr.size()-1;
        int[] res = new int[arr.size()];
        int i =0;
        while(start<=end){
        	if(start!=end){
        		res[i] = arr.get(end);
        		i = i+1;
        		res[i] = arr.get(start);
        		i = i+1;
        		//System.out.print(arr.get(end)+" ");
            	//System.out.print(arr.get(start)+" ");
        	}
        	else
        		res[i++] = arr.get(start);
        		//System.out.print(arr.get(start)+" ");
        	start++;
        	end--;
        }
        return res;
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] intArr = {1,3,6,9,-3};
		//int[] intArr = {-27676, 211621, 904304,161270, -292822,732004,860511,-825806, -721722, 536428, -927571, -287004};
		int[] res = wiggleArrangeArray(intArr);
		for(int i:res)
			System.out.print(i + " ");
	}
}
