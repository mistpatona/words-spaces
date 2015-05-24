package org.words.prepare;

import java.io.IOException;
//import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Analyser0 {
	public static StatTable analyseFile(String f) throws IOException {
		SpacedText t = ReadWords.fromFile(f);
		return (analyseString11(t.noSpaces()));
	}

	public static StatTable2 analyseFile2(String f) throws IOException {
		SpacedText t = ReadWords.fromFile(f);
		return (analyseStringPQS(t.noSpaces(), array2Set(t.spacesPositions()),1,1));
	}
	
	public static StatTable2 analyseFile4(String f) throws IOException {
		//copypaste from analyseFile2
		SpacedText t = ReadWords.fromFile(f);
		return (analyseStringPQS(t.noSpaces(), array2Set(t.spacesPositions()),2,2));
	}
	
	public static Set<Integer> array2Set(int[] src) {
		Set<Integer> r =  new HashSet<Integer>() ; //= new Set<Integer>();
		r.clear(); 
		for (int i = 0; i < src.length; i++) {
			r.add(src[i]);
		}
		return r;
	}
	
	public static StatTable analyseStringPQ(String src, int p, int q) {
		// p and q are count of symbols to use, before and after
		// current position, respectively
		StatTable t = new StatTable();
		for (int i = 0; i < src.length(); i++) {
			t.add(myCutPQ(src, i, p, q));
		}
		return t;
	}

	public static StatTable2 analyseStringPQS(String src, Set<Integer> spaces,
			int p, int q) {
		// p and q are count of symbols to use, before and after
		// current position, respectively
		StatTable2 t = new StatTable2();
		for (int i = 0; i < src.length(); i++) {
			if (spaces.contains(i)) {
				t.addSpace(myCutPQ(src, i, p, q));
			} else {
				t.addNoSpace(myCutPQ(src, i, p, q));
			}
		}
		return t;
	}

	public static StatTable analyseString11(String src) {
		return analyseStringPQ(src, 1, 1);
	}

	public static StatTable analyseString22(String src) {
		return analyseStringPQ(src, 2, 2);
	}

	public static String myCutPQ(String src, int position, int p, int q) {
		int p1 = Math.max(0, position - p);
		int q1 = Math.min(src.length(), position + q);
		return (src.substring(p1, q1));
	}

}
