package practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class OpenHighLowClose {

	void dailyOHLC(int[] timestamp, String[] instrument, String[] side, double[] price, int[] size) {
		int n = timestamp.length;
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		String date;
		long timeStamp;
		double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Map<String, TreeMap> data = new TreeMap<String, TreeMap>();
		TreeMap<String, ArrayList> sub = new TreeMap<String, ArrayList>();
		ArrayList<String> val = new ArrayList<String>();

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			timeStamp = (long) timestamp[i] * 1000;
			date = df.format(timeStamp);

			if (!data.containsKey(date)) {
				sub = new TreeMap<String, ArrayList>();
				val = new ArrayList<String>();
				val.add(Double.toString(price[i]));
				val.add(Double.toString(price[i]));
				val.add(Double.toString(price[i]));
				val.add(Double.toString(price[i]));
				sub.put(instrument[i], val);
				data.put(date, sub);

			} else {
				sub = data.get(date);
				if (sub.containsKey(instrument[i])) {
					val = sub.get(instrument[i]);
					if (price[i] < min) {
						min = price[i];
						val.set(2, Double.toString(min));
					}
					if (price[i] > max) {
						max = price[i];
						val.set(1, Double.toString(max));
					}
					val.set(3, Double.toString(price[i]));
				} else {
					val = new ArrayList<String>();
					val.add(Double.toString(price[i]));
					val.add(Double.toString(price[i]));
					val.add(Double.toString(price[i]));
					val.add(Double.toString(price[i]));
					sub.put(instrument[i], val);
				}
			}
		}
		// System.out.println(data);

		Set set = data.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			Map.Entry<String, TreeMap> me = (Map.Entry<String, TreeMap>) i.next();

			TreeMap temp = me.getValue();
			Set s2 = temp.entrySet();
			Iterator i2 = s2.iterator();
			while (i2.hasNext()) {
				list.add(me.getKey());
				Map.Entry<String, ArrayList> me2 = (Map.Entry<String, ArrayList>) i2.next();
				list.add(me2.getKey());
				list.addAll(me2.getValue());
				res.add(list);
				list = new ArrayList<String>();
			}

		}

		int l = 0;
		String[][] op = new String[res.size()][];
		for (ArrayList<String> li : res) {
			op[l++] = new String[li.size()];
		}
		l = 0;
		for (ArrayList<String> li : res) {
			for (int m = 0; m < li.size(); m++) {
				op[l][m] = li.get(m);
			}
			l++;
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		OpenHighLowClose obj = new OpenHighLowClose();
		int[] timestamp = { 1450625399, 1450625400, 1450625500, 1450625550, 1451644200, 1451690100, 1451691000 };
		String[] instrument = { "HPQ", "HPQ", "HPQ", "HPQ", "AAPL", "HPQ", "GOOG" };
		String[] side = { "sell", "buy", "buy", "sell", "buy", "buy", "buy" };
		double[] price = { 10, 20.3, 35.5, 8.65, 20, 10, 100.35 };
		int[] size = { 10, 1, 2, 3, 5, 1, 10 };
		obj.dailyOHLC(timestamp, instrument, side, price, size);
		// obj.dailyOHLC();
	}

}
