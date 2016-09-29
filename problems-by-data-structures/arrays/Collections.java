package arrays;

import java.util.*;

public class Collections {

	enum CardSuit {
		Diamond(1), Club(2);
		int value;

		CardSuit(int value) {
			this.value = value;
		}
	}

	public boolean isValid(String ip) {
		Stack<Character> s = new Stack<Character>();

		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		char ch;
		for (int i = 0; i < ip.length(); i++) {
			ch = ip.charAt(i);
			if (map.containsKey(ch)) {
				s.push(ch);
			} else if (map.containsValue(ch) && s.isEmpty()) {
				return false;
			} else if (map.containsValue(ch) && (char) (map.get(s.peek())) != ch)
				return false;
			else if (map.containsValue(ch) && ((char) (map.get(s.peek())) == ch)) {
				s.pop();
			}
		}
		if (s.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		for (CardSuit value : CardSuit.values())
			System.out.println(value);
		System.out.println(CardSuit.Diamond.value);
	}
}
