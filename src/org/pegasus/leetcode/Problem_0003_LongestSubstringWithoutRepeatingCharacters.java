package org.pegasus.leetcode;

import java.util.HashMap;

public class Problem_0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        for (int i = 0, j = -1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)),j);//右面节点不回退
            }
            result = Math.max(result, i - j);
            map.put(s.charAt(i), i);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem_0003_LongestSubstringWithoutRepeatingCharacters instance = new Problem_0003_LongestSubstringWithoutRepeatingCharacters();

        System.out.println(instance.lengthOfLongestSubstring("abccba"));

    }
}
