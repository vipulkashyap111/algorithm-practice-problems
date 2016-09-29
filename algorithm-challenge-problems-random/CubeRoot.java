package codingChallengePractice;

public class CubeRoot {

	public int bruteforce(int a,int b){
		double res = 0;
		int count=0;
		for(int x = 1; x<=a;x++){
			for(int y=1; y<=b;y++){
				res = Math.pow(Math.cbrt(x)+Math.cbrt(y),3);
				if(Math.abs(res-Math.round(res))<1E-7){
					System.out.println(x+","+y);
					count++;
				}
			}
		}
		return count;
	}
	public int countPerfectCubes(int a, int b) {
		int count = 0;
		System.out.println("Range" + a + ":" + b);
		int i = (int) Math.cbrt(a), cube = 1;
		do {
			cube = i * i * i;
			System.out.println(cube);
			count++;
			i = i + 1;
		} while (cube <= b);
		System.out.println("Count:"+(count - 1));
		return count - 1;
	}

	public int countComb(int a, int b) {
		a = a <= b ? a : b;
		b = b > a ? b : a;
		int xcount = countPerfectCubes(1, a);
		int ycount = countPerfectCubes(a, b) + xcount - 1;
		System.out.println(xcount + ":" + ycount);
		int res = xcount * ycount + a - xcount;
		return res;
	}

	public static void main(String[] args) {
		CubeRoot cr = new CubeRoot();
		/*
		 * int res1 = cr.countPerfectCubes(1,8); int res2 =
		 * cr.countPerfectCubes(8,27);// cr.bruteForce2(8, 27);
		 * System.out.println("Res1:"+res1); System.out.println("Res2:"+res2);
		 */
		//int res = cr.countComb(16, 108);
		int res = cr.bruteforce(16, 128);
		System.out.println("Final Result:" + res);
	}
}
