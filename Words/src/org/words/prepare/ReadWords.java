package org.words.prepare;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadWords {
	
	public static String readFileToString(String fn) throws IOException {
		FileReader fr = new FileReader(fn);
		BufferedReader br = new BufferedReader(fr);
		String ss = null;
		String result = "";
		while ((ss = br.readLine()) != null){
			result += (" " + ss);	
		}
		br.close();
		return result;
	}
	
	public static SpacedText fromFile(String fn) throws IOException {
		String s = readFileToString(fn);
		return WordsPrepare.mkSpacedText(s);
	}

}
