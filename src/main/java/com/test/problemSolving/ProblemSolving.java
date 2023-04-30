package com.test.problemSolving;

public class ProblemSolving {

	public static void main(String[] args) {
		reverseSubstrings("abd(jnb)asdf");
		reverseSubstrings("abdjnbasdf");
		reverseSubstrings("dd((df))a(ghhh)");		
	}
	
	private static void reverseSubstrings(String input) {
		ReverseSubstrings reverseSubstrings = new ReverseSubstrings();
		System.out.println("Input: " + input);
		System.out.print("Output: ");
		System.out.println(reverseSubstrings.reverseStringsBetweenParentheses(input));
	}
}