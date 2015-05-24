package org.words.prepare;

public class SpacedText {
	String[] text;

	public SpacedText(String[] st) {
		text = st;
	}

	public String noSpaces() {
		StringBuilder ans = new StringBuilder();
		for (String i : text) {
			ans.append(i);
		}
		return ans.toString();
	}


	public int wordCount() {
		return text.length;
	}

	public int[] spacesPositions() {
		int ans[] = new int[this.wordCount()];
		int k = 0; // word counter
		int s = 0; // character counter
		for (String i : text) {
			s = s + i.length();
			ans[k] = s;
			k++;
		}
		return ans;
	}

}
