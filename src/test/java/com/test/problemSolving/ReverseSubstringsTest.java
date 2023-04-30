package com.test.problemSolving;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseSubstringsTest {

	private static ReverseSubstrings reverseSubstrings;
	private static final String FAILURE_MESSAGE = "Input String is not valid!";

	@BeforeClass
	public static void setup() {
		reverseSubstrings = new ReverseSubstrings();
	}

	@Test
	public void testValidCharsInputProcessingShouldSuccess() {
		String output = reverseSubstrings.reverseStringsBetweenParentheses("abdjnbasdf");
		assertEquals("abdjnbasdf", output);
	}
	
	@Test
	public void testParanthesesOnlyInputProcessingShouldSuccess() {
		String output = reverseSubstrings.reverseStringsBetweenParentheses("(())()((()()))");
		assertEquals("(())()((()()))", output);
	}
	
	@Test
	public void testValidMixedInputProcessingShouldSuccess() {
		String output = reverseSubstrings.reverseStringsBetweenParentheses("abd(jnb)asdf");
		assertEquals("abd(bnj)asdf", output);
	}

	@Test
	public void testEmptyInputProcessingShouldFail() {
		String output = reverseSubstrings.reverseStringsBetweenParentheses("");
		assertEquals(FAILURE_MESSAGE, output);
	}

	@Test
	public void testUnbalancedInputProcessingShouldFail() {
		String output = reverseSubstrings.reverseStringsBetweenParentheses("abd((jnb)asdf");
		assertEquals(FAILURE_MESSAGE, output);
		output = reverseSubstrings.reverseStringsBetweenParentheses("abd((jnb)))asdf");
		assertEquals(FAILURE_MESSAGE, output);
	}

	@Test
	public void testInputWithCapCharProcessingShouldFail() {
		String output = reverseSubstrings.reverseStringsBetweenParentheses("Abd(jnb)asdf");
		assertEquals(FAILURE_MESSAGE, output);
	}

	@Test
	public void testInputWithNumbersProcessingShouldFail() {
		String output = reverseSubstrings.reverseStringsBetweenParentheses("1abd(jnb)asdf");
		assertEquals(FAILURE_MESSAGE, output);
	}
}
