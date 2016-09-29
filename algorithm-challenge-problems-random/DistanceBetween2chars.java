package interview;

import java.util.*;

public class DistanceBetween2chars{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String in = sc.next();
		System.out.println("Enter the 2 characters");
		char c1 = sc.next().charAt(0);
		char c2 = sc.next().charAt(0);

		int n1l = in.lastIndexOf(c1);
		int n1f = in.indexOf(c1);
		int n2l = in.lastIndexOf(c2);
		int n2f = in.indexOf(c2);
		if(n1f == -1 || n2f == -1)
			throw new Exception("One of the characters is not present in the string");
		int distance1 = Math.abs(n1l-n2f);
		int distance2 = Math.abs(n2l-n1f);
		int distance3 = Math.abs(n1f-n2f);
		int distance4 = Math.abs(n1l-n2l);
		int distance5 = distance1<distance2?distance1:distance2;
		int distance6 = distance3<distance4?distance3:distance4;
		int distance = distance5<distance6?distance5:distance6;
		System.out.println("Minimum Distance between given 2 characters is: "+distance);		
	}
}
