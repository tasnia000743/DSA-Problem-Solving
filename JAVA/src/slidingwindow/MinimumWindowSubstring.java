//Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// Example
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t. 

package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int countRequired = 0;
        int minLengthStartIndex = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                if (map.get(s.charAt(end)) > 0) {
                    countRequired++;
                }
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);

            }
            while (countRequired == t.length()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minLengthStartIndex = start;

                }

                if (map.containsKey(s.charAt(start))) {

                    if (map.get(s.charAt(start)) == 0) {
                        countRequired--;
                    }
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);

                }

                start++;

            }

        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minLengthStartIndex, minLength + minLengthStartIndex);
        }

    }

    public static void main(String args[]) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));

    }
}
