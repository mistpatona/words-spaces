package org.words.prepare;

import java.util.HashMap;
import java.util.Map;

public class StatTable {

	Map<String, Integer> st;

	public StatTable() {
		st = new HashMap<String, Integer>();
	}

	public void addPair(String k, int v) {
		if (st.containsKey(k)) {
			st.put(k, st.get(k) + v);
		} else {
			st.put(k, v);
		}
	}

	public void add(String k) {
		this.addPair(k, 1);
	}
	
	public String[] getKeys() {
		String[] r = st.keySet().toArray(new String[st.size()]);
		return r;
	}
	
	public Map<String, Integer> getSt() {
		return st;
	}
}
