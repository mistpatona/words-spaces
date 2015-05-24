package org.words.prepare;

import java.io.IOException;

/*
 * how to run the compiled classes from command line:
 * java -cp bin  org.words.prepare.PrideTest
 * 
 * comlipling classes by javac one directory level lower (in src folder),
 * so
 * after compiling by hand in src dir:
 *  
 *  src$ javac -cp . org/words/prepare/PrideTest.java
 *  
 *  do:
 *  
 *  cd ..
 *  java -cp src  org.words.prepare.PrideTest
 */

public class PrideTest {
	
	public static void main(String[] args) throws IOException {
		SpacedText txt = ReadWords.fromFile("src/pride_and_prejustice.txt");
		AnalyserPack p = new AnalyserPack(txt);
		String s1 = "some cats do do jump and see other cats and dogs";
		String s  = s1.toLowerCase().replaceAll(" ", "");       // "somelandandotherminorterritories";
		System.out.println (s1);
		System.out.println (s);
		System.out.println ("'" + MyUtil.restoreSpacesByPositions(s,p.restoreSpaces1(s)) + "'");
	}

}
