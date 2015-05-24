package org.words.prepare;

import org.junit.Assert;

import junit.framework.TestCase;

public class SpacedTextTest3 extends TestCase {
	SpacedText t1 = new SpacedText("aaaa bbbb cccc".split(" "));

	public final void testNoSpaces() {
		assertEquals(t1.noSpaces(), "aaaabbbbcccc");
	}

	public final void testWordCount() {
		assertEquals(t1.wordCount(), 3);
	}

	public final void testSpacesPositions() {
		int[] aa = { 4, 8, 12 };
		int[] bb = t1.spacesPositions();
		// compare arrays:
		// for (int i = 0; i < aa.length; i++) {
		Assert.assertArrayEquals(aa, bb);

	}

}
