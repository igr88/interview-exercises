package dev.me.exercises;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s, find the length of the longest
substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // This is a sliding window problem
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;

        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                max = Math.max(set.size(), max);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        List<String> inputs = List.of("abcabccc");
        LongestSubstringWithoutRepeatingCharacters r = new LongestSubstringWithoutRepeatingCharacters();

        for (String input : inputs) {
            System.out.println(r.lengthOfLongestSubstring(input));
        }
    }
}
