package org.words.prepare;

import java.util.ArrayList;
import java.util.Collections;

public class AnalyserPack {
	ArrayList<StatTable3> ts;

	public AnalyserPack(SpacedText t) {
		ts = statTables(t);
	}

	public ArrayList<Integer> restoreSpaces1(String src) {
		String chip;
		int d = 3; // an offset
		WordStats ws;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 1; i < src.length(); i++) {
			chip = MyUtil.myCutPQ(src, i, d, d);
			//System.out.print(chip);
			ArrayList<WordStats> wss = find(chip, d);
			if (!wss.isEmpty()) {
				ws = wss.iterator().next(); // we need the first element ( 'cus
											// the array is sorted)
				if (ws.spaceProbability() > 0.5) {
										ans.add(i);
				}
				//System.out.print(ws.spaceProbability());
				//System.out.println();
			} else { 
				//System.out.println("E");
			}
		}
		return ans;
	}

	public ArrayList<WordStats> find(String src, int offset) {
		ArrayList<WordStats> a = new ArrayList<WordStats>();
		WordStats w;
		for (StatTable3 t : ts) {
			w = t.find(src, offset);
			if (w != null) {
				a.add(w);
			}
		}
		Collections.sort(a);
		return a;
	}

	public static ArrayList<StatTable3> statTables(SpacedText t) {
		int[] kk = { 1, 2, 3 };
		ArrayList<StatTable3> as = new ArrayList<StatTable3>();
		for (int i : kk) {
			for (int j : kk) {
				if (i*j > 1){
				as.add(new Analyser3(i, j).analyseReadWords(t));
				}
			}
		}
		return as;
	}

}
