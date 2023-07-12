package dev.me.exercises;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i=0;i<s.length();i++) {
            int len1 = expand(s, i, i); // Considers the current character as the center of an odd-length palindrome
            int len2  = expand(s, i, i + 1); // considers it as the right half of an even-length palindrome
            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start + 1) { // check if we found a longer palindrome
                /*
                To update the start and end indices, we make use of the index i, which represents the center of the palindrome.
                Since the length of the palindrome can be odd or even, we need to consider both cases:
                 */
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        return right - left - 1;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring r = new LongestPalindromicSubstring();
        String input = "cbbd";
        System.out.println(r.longestPalindrome(input));
    }
}
