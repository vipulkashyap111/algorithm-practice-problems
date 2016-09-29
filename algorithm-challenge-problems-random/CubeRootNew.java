package codingChallengePractice;

import java.util.*;

public class CubeRootNew {

	public ArrayList<Integer> countPerfectCubes(int b) {
		ArrayList<Integer> cubes = new ArrayList<Integer>();
		int i = 1, cube = 1;
		do {
			cube = i * i * i;
			// System.out.println(cube);
			cubes.add(cube);
			i = i + 1;
		} while (cube <= b);
		cubes.remove(cubes.size() - 1);
		return cubes;
	}

	public int count(int a, int b) {
		a = a <= b ? a : b;
		b = b > a ? b : a;
		int y = 0, j = 0;
		int count = 0;
		int cube = 0;
		ArrayList<Integer> bcubes = countPerfectCubes(b);
		int size = bcubes.size();
		for (int x = 1; x <= a; x++) {
			for (int i = size - 1; i >= 0; i--) {
				cube = bcubes.get(i);
				if(x==cube){
					for(int val:bcubes){
						System.out.println(x+":"+val);
						count++;
					}				
					break;
				}else if(x%cube==0){
					int quotient = x/cube;
					j=0;
					while(j<size){
						y = quotient*bcubes.get(j++);
						if(y<=b){
							System.out.println(x+":"+y);
							count++;
						}
						
					}
					break;
				}
				
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		CubeRootNew crn = new CubeRootNew();
		int res = crn.count(16,128);
		System.out.println(res);
	}
}
