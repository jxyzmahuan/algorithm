package org.pegasus;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses1(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses(String s) {
        int length = 0;
        Stack<Character> stack = new Stack();

        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                    length += 2;
                } else {
                    stack.push(c);
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = "((((()))()(";
        System.out.println(longestValidParentheses.longestValidParentheses1(s));
    }
}
