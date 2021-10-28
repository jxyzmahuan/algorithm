package com.pegasus.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Problem_0020_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        int l = s.length();
        if (l % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> pare = new HashMap<Character, Character>();
        pare.put('(', ')');
        pare.put('[', ']');
        pare.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < l; i++) {
            if (pare.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if(!stack.isEmpty()&&pare.get(stack.peek()).equals(s.charAt(i))){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

}
