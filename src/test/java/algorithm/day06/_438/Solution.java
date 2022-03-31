package algorithm.day06._438;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
 *  https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];

        for(int i=0; i<p.length(); i++) {
            map[p.charAt(i)-'a']++;
        }

        int start = 0;

        for(int i=0; i<s.length(); i++) {
            map[s.charAt(i)-'a']--;

            //슬라이딩 윈도우를 잘 떠올려 보자.
            if(i-start >= p.length()) {
                map[s.charAt(start) - 'a']++;
                start++;
            }

            if(allZeroMap(map)) {
                result.add(start);
            }

        }
        return result;
    }

    private boolean allZeroMap(int[] map) {
        for(int i=0; i<map.length; i++) {
            if(map[i] != 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    void example1() {
        String s = "abab";
        String p = "ab";

        findAnagrams(s,p).forEach(System.out::println);
    }

    @Test
    void example2() {
        String s = "cbaebabacd";
        String p = "abc";

        findAnagrams(s,p).forEach(System.out::println);
    }

}
