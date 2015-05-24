package org.words.prepare;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadWords {
	
	static String readFileToString(String fn) throws IOException {
		FileReader fr = new FileReader(fn);
		BufferedReader br = new BufferedReader(fr);
		String ss = null;
		StringBuilder ans = new StringBuilder();
		while ((ss = br.readLine()) != null){
			ans.append(" " + ss);	
		}
		br.close();
		return ans.toString();
	}
	
	public static SpacedText fromFile(String fn) throws IOException {
		String s = readFileToString(fn);
		return WordsPrepare.mkSpacedText(s);
	}

}
