package algorithm.day06._242;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 */
public class Solution {

    public boolean isAnagram(String s, String t) {

        int[] map = new int[26];
        int[] map2 = new int[26];

        for(int i=0; i<s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t.length(); i++) {
            map2[t.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(map[i]!=map2[i])
                return false;
        }

        return true;
    }


    @Test
    void example1() {
        String s = "anagram" , t = "nagaram";
        Assertions.assertTrue(isAnagram(s,t));
    }

    @Test
    void example2() {
        String s = "rat" , t = "car";
        Assertions.assertFalse(isAnagram(s,t));
    }

}
