package org.words.prepare;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(SpacedTextTest3.class);
		suite.addTestSuite(WordsPrepareTest.class);
		//$JUnit-END$
		return suite;
	}

}
