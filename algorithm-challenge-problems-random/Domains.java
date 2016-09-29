package practice;

import java.util.*;

public class Domains {
	String[] domainType(String[] domains) {
		Map<String, String> map = new HashMap<String, String>();
		int n = domains.length;
		String[] res = new String[n];
		map.put("com", "commercial");
		map.put("org", "organization");
		map.put("net", "network");
		map.put("info", "information");
		int dotIndex = 0;
		int i = 0;
		for (String s : domains) {
			dotIndex = s.lastIndexOf(".");
			res[i++] = map.get(s.substring(dotIndex + 1));
		}
		return res;
	}

	public static void main(String[] args) {
		Domains d = new Domains();
		String[] domains = { "en.wiki.org", "codefights.com", "happy.net", "code.info" };
		String[] res = d.domainType(domains);
		for (String s : res) {
			System.out.println(s);
		}

	}
}
