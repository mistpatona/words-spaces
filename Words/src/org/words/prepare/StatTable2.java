package org.words.prepare;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StatTable2 {
	StatTable sp; // SPaces
	StatTable ns; // No Spaces

	public StatTable2() {
		sp = new StatTable();
		ns = new StatTable();
	}

	public void addSpace(String s) {
		sp.add(s);
	}

	public void addNoSpace(String s) {
		ns.add(s);
	}

	public Map<String, Integer> getSpaces() {
		return sp.getSt();
	}
	public Map<String, Integer> getNoSpaces() {
		return ns.getSt();
	}
	
	public Set<String> collisional() {
		Set<String> s = new HashSet<String>();
		s = this.getSpaces().keySet();
		s.retainAll( this.getNoSpaces().keySet() );
		return s;
	}
	
	public String statReportSignatures() {
		String res = new String();
		res = "space signatures: " + getSpaces().size() + "\n" +
				"non-space signatures: " + getNoSpaces().size() + "\n" +
				"collisional signatures: " + collisional().size() + "\n";
		return res;
	}
}
