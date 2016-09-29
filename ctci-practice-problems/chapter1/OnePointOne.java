package chapter1;

import java.util.Scanner;

public class OnePointOne {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String ip = sc.nextLine();
		ip = ip.toUpperCase();
		int index;
		char[] ch = new char[26];
		boolean flag = false;
		for (int i = 0; i < ip.length(); i++) {
			if(ip.charAt(i)!=32)
			if (!flag) {
				index = (int) (ip.charAt(i) - 'A');
				if (ch[index] != '\u0000') {
					flag = true;
				}
				else
				{
					ch[index] = ip.charAt(i);
				}
			}
			else
				break;
		}
		if(!flag)
		{
			System.out.println("All characters are unique");
		}
		else
			System.out.println("All characters are not unique");
	}
}
