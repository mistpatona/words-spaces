package org.words.prepare;

public class FrqSample {
	int count;
	String chars;
	
	public FrqSample(String s) { // counstructor
		count = 1;
		chars = s;
	}
	
	public void inc() {
		count++;
	}
	
	public String getChars() {
		return chars;
	}

	public int getCount() {
		return count;
	}
	public boolean matches(String s){
		return (chars.equals(s));
	}
}
