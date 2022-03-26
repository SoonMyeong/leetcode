package algorithm.day06._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 *  --> example 3 이해가 잘 안됨; , 슬라이딩 윈도우 알고리즘으로 해결할 수있다고 한다.
 *   p  w  w  k  e  w
 *  1)i,j
 *  2)i   j
 *  3)    i  j
 *  4)    i     j
 *  5)    i         j
 *  6)           i      j
 * ---
 * 그니까 왼쪽에서 오른쪽 방향으로 i,j 2포인터를 가지고 옮겨가면서 최대 길이를 측정해낸다.
 * 음... 이거 유형 좀 더봐야겠다.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 *
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j =0, max = 0;
        Set<Character> set = new HashSet<>();

        while(j<s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(set.size(),max);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }


    @Test
    void example1() {
        String s = "abcabcbb";
        Assertions.assertEquals(lengthOfLongestSubstring(s),3);
    }

    @Test
    void example2() {
        String s = "bbbbb";
        Assertions.assertEquals(lengthOfLongestSubstring(s),1);
    }

    @Test
    void example3() {
        String s = "pwwkew";
        Assertions.assertEquals(lengthOfLongestSubstring(s),3);

    }

}
