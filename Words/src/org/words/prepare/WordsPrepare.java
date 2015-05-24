package org.words.prepare;

import java.util.ArrayList;

public class WordsPrepare {
	
	// TODO: join with MyUtils class
	// or even distribute all functions between other classes

	public static String simplify(String inp) {
		return inp.toLowerCase().replaceAll("[\n\t]", " ").replaceAll("[0-9-,.;:()\"']", "");
	}

	public static String[] stringFilter(String[] inp) {
		ArrayList<String> ans = new ArrayList<String>();
		for (String i : inp) {
			// TODO add filter to remove non-alphabetic words
			if (i.isEmpty()) {
			} else {
				ans.add(i);
			}
		}
		return ans.toArray(new String[ans.size()]);
	}

	public static SpacedText spacedText(String[] inp) {
		return (new SpacedText(inp));
	}

	public static SpacedText mkSpacedText(String inp) {
		return spacedText(stringFilter(simplify(inp).split(" ")));

	}
}