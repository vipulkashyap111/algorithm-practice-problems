package dynamicProgramming;

import java.util.*;
import java.io.*;

public class SubStringPalindrome {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		// System.out.println("String:");
		String str = in.nextLine();
		isSubStringPalindrome(str);
	}

	public static void isSubStringPalindrome(String str) {
		int len = str.length();
		boolean[][] table = new boolean[len][len];
		// sub string len = 1
		for (int i = 0; i < len; i++) {
			table[i][i] = true;
		}
		// sub string len=2
		for (int i = 0; i < len - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
			}
		}
		// sub string len more than 2
		for (int j = 3; j <=len; j++) {
			for (int i = 0; i <len - j + 1; i++) {
				int k=i+j-1;
				if (str.charAt(i) == str.charAt(k)) {
					if (table[i + 1][k - 1] == true)
						table[i][k] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (table[i][j] == true)
					count++;
			}
		}
		System.out.println(count);
	}
}
