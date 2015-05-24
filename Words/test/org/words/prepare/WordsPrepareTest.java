package org.words.prepare;

import junit.framework.TestCase;
import org.junit.Assert;

public class WordsPrepareTest extends TestCase {

	public final void testSimplify() {
		assertEquals(WordsPrepare.simplify("aAa1: BBB; -ccc- ;"),
				"aaa bbb ccc ");
	}

	public final void testStringFilter() {
		String[] expectedResult = "aa bb cc dd".split(" ");
		String[] result = WordsPrepare.stringFilter("aa bb       cc     dd"
				.split(" "));
		Assert.assertArrayEquals(expectedResult, result);
	}

	public final void testMkSpacedText() {
		assertEquals(WordsPrepare.mkSpacedText("AAA 1234 BBB  -").noSpaces(),
				"aaabbb");
	}

}
