package leetcode.q43;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClassB43Test {
	
	private static ClassB43 obj = null;
	
	@BeforeAll
	static void initialization() {
		obj = new ClassB43();
	}

	@Test
	@DisplayName("testSingleElement")
	void test() {
		int[] a = {5};
		int[] b = {6};
		assertEquals(30, obj.junitTestgetDigit(a, b, 0));
		assertEquals(32, obj.junitTestgetDigit(a, b, 2));
		
		
		int[] c = {5};
		int[] d = {};
		assertEquals(30, obj.junitTestgetDigitForUnequalArray(a, b, 0));
		assertEquals(32, obj.junitTestgetDigitForUnequalArray(a, b, 2));
	}
	
	@Test
	@DisplayName("testOddElements")
	void testOddElements() {
		int[] a = {5,7,9};
		int[] b = {0,0,6};
		assertEquals(30, obj.junitTestgetDigit(a, b, 0));
		assertEquals(31, obj.junitTestgetDigit(a, b, 1));
		
		
		int[] c = {5,7,9};
		int[] d = {0,1,6};
		assertEquals(37, obj.junitTestgetDigit(c, d, 0));
		assertEquals(38, obj.junitTestgetDigit(c, d, 1));
		
		int[] e = {5,7,9};
		int[] f = {6};
		assertEquals(30, obj.junitTestgetDigitForUnequalArray(e, f, 0));
		assertEquals(31, obj.junitTestgetDigitForUnequalArray(e, f, 1));
	}
	
	@Test
	@DisplayName("testEvenElements")
	void testEvenElements() {
		int[] a = {5,4};
		int[] b = {1,2};
		assertEquals(14, obj.junitTestgetDigit(a, b, 0));
		assertEquals(15, obj.junitTestgetDigit(a, b, 1));
	}

}
