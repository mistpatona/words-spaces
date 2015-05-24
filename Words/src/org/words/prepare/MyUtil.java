package org.words.prepare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyUtil {
	public static Set<Integer> array2Set(int[] src) {
		Set<Integer> r = new HashSet<Integer>();
		r.clear(); // is this needed?
		for (int i = 0; i < src.length; i++) {
			r.add(src[i]);
		}
		return r;
	}

	public static String myCutPQ(String src, int position, int p, int q) {
		int p1 = Math.max(0, position - p);
		int q1 = Math.min(src.length(), position + q);
		return (src.substring(p1, q1));
	}

	public static String restoreSpacesByPositions(String src,
			ArrayList<Integer> spaces) {
		if (src.length() < 2) {
			return "";
		}
		// TODO: change to string builder ++++
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			if (spaces.contains(i)) {
				ans.append(' '); // ans += ' ';
			}
			ans.append(src.charAt(i));

		}
		return ans.toString();
	}
}
