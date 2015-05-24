package org.words.prepare;

import java.util.HashMap;
import java.util.Map;

public class StatTable3 {
	Map<String, WordStats> st;
	int p,q;
	

	public StatTable3(int p1, int q1) {
		st = new HashMap<String, WordStats>();
		p = p1;
		q = q1;
	}
	
	public WordStats find(String src, int offset) {
		String s = MyUtil.myCutPQ(src, offset, p, q);
		return st.get(s);
	}

	public int getP() {
		return p;
	}

	public int getQ() {
		return q;
	}

	public void add(String k, Boolean isSpace) {
		if (st.containsKey(k)) {
			st.get(k).add(isSpace);
		} else {
			st.put(k, new WordStats(isSpace));
		}
	}

	public Map<String, WordStats> getSt() {
		return st;
	}
	
	public String toString() {
		String r = new String();
		for (String s : st.keySet()) {
			r += (s + " " + st.get(s).toString() + "\n");
		}
		return r;
	}
}
