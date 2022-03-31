package algorithm.day06._438;


import org.junit.jupiter.api.Test;

import java.util.List;

/**
 *  Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 *  You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *  1 <= s.length, p.length <= 3 * 104
 *  s and p consist of lowercase English letters.
 *
 *  슬라이딩윈도우 알고리즘을 활용하는 대표적인 문제인 애나그램 문제
 *  으... 아직은 내게 어렵구나
 *
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

    }


    @Test
    void example1() {
        String s = "abab";
        String p = "ab";

        findAnagrams(s,p);
    }

}
