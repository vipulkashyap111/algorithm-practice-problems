package practice;

import java.util.HashSet;

public class LongestSubStringWORepeatingChar {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() > 0) {
			HashSet dict = new HashSet();
			int maxLength = 0;
			int currentLength = 0;
			int startPointer = 0;
			char ch = 0;
			while (s.length() - maxLength >= startPointer) {
				for (int runner = startPointer; runner < s.length(); runner++) {
					ch = s.charAt(runner);
					if (!dict.contains(ch)) {
						currentLength++;
						dict.add(ch);
					} else {
						startPointer++;
						dict.clear();
						if (currentLength > maxLength)
							maxLength = currentLength;
						currentLength = 0;
						break;
					}
				}
			}
			return maxLength;
		} else
			return 0;
	}
	
	public static void main(String[] args){
		LongestSubStringWORepeatingChar obj = new LongestSubStringWORepeatingChar();
		String s = "bbbb";
		obj.lengthOfLongestSubstring(s);
	}
}
