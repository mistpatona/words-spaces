package org.words.prepare;

import junit.framework.TestCase;

public class TestStatTable3 extends TestCase {

	public final void testAdd() {
		StatTable3 t = new StatTable3(1,1);
		t.add("aa",true);
		t.add("aa",true);
		t.add("bb",false);
		
		assertEquals(2, t.getSt().size());
	}

}
