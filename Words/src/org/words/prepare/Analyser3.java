package org.words.prepare;

import java.io.IOException;
//import java.util.Collections;
//import java.util.HashSet;
import java.util.Set;

public class Analyser3 {

	public StatTable3 analyseFile(String f) throws IOException {
		return analyseReadWords(ReadWords.fromFile(f));
	}

	public static StatTable3 analyseStringPQS(String src, Set<Integer> spaces,
			int p, int q) {
		// p and q are count of symbols to use, before and after
		// current position, respectively
		StatTable3 t = new StatTable3(p,q);
		for (int i = 0; i < src.length(); i++) {
			t.add(MyUtil.myCutPQ(src, i, p, q), spaces.contains(i));
		}
		return t;
	}

	int p;
	int q;

	public Analyser3(int p1, int q1) {
		p = p1;
		q = q1;
	}

	public StatTable3 analyseReadWords(SpacedText t) {
		return (analyseStringPQS(t.noSpaces(),
				MyUtil.array2Set(t.spacesPositions()), p, q));
	}
}
