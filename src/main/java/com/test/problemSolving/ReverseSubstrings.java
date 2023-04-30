package com.test.problemSolving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstrings {
	private final String CHARS_VALIDATION_REGEX = "^([a-z()]*)$";

	public String reverseStringsBetweenParentheses(String input) {
		if (!isValidInputString(input)) {
			return "Input String is not valid!";
		} else {
			Stack<Character> charsStack = new Stack<Character>();
			Queue<Character> reverseQueue = new LinkedList<Character>();
			// Loop over the input characters
			for (Character c : input.toCharArray()) {
				// If the character is ) then reverse the previous chars until the open
				// parenthesis is found
				if (c.equals(')')) {
					if (charsStack.size() > 0) {
						while (!charsStack.peek().equals('(')) {
							// Add substring to the the reverseQueue
							reverseQueue.add(charsStack.pop());
						}
						// poll the reversed substring to the stack and clear the queue
						charsStack.addAll(reverseQueue);
						reverseQueue.clear();
					}
				}
				charsStack.push(c);
			}
			return stackToString(charsStack);
		}
	}

	private boolean isValidInputString(String input) {
		if (input == null || input.isEmpty() || input.length() > 2000)
			return false;
		if (!input.matches(CHARS_VALIDATION_REGEX))
			return false;
		return validateBalancedParentheses(input);
	}

	private boolean validateBalancedParentheses(String input) {
		// push the opening parenthesis in a stack then pop one if a closing parenthesis
		// is found. The stack should be empty at the end if the parentheses are
		// balanced
		Stack<Character> parenthesesStack = new Stack<Character>();
		for (Character c : input.toCharArray()) {
			if (c.equals('(')) {
				parenthesesStack.push(c);
			} else if (c.equals(')')) {
				if (!parenthesesStack.isEmpty() && parenthesesStack.peek().equals('(')) {
					parenthesesStack.pop();
				} else {
					return false;
				}
			}
		}
		return parenthesesStack.isEmpty();
	}

	private String stackToString(Stack<Character> input) {
		StringBuilder stringBuilder = new StringBuilder();
		if (input != null && !input.isEmpty()) {
			input.forEach(c -> stringBuilder.append(c));
		}
		return stringBuilder.toString();
	}

}
