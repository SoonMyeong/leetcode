package algorithm.day06._567;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * 아직도 이해가 잘 안된다.
 * 슬라이딩 윈도우 알고리즘 개념은
 * 범위 전체를 한쪽 방향으로 이동해가면서 포함하는지 확인하는 알고리즘 인건 알겠는데..
 *
 * 이 문제에 어떻게 적용되는지가 이해가 안됨... Solution 보고 가져왔는데
 * 자세히 분석 해봐야겠다.
 *
 */
public class Solution {


    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    @Test
    public void example1() {
        String s1 = "ab";
        String s2 = "eidbaooo";

        Assertions.assertTrue(checkInclusion(s1,s2));
    }

    @Test
    public void example2() {
        String s1 = "ab";
        String s2 = "eidboaoo";

        Assertions.assertFalse(checkInclusion(s1,s2));
    }

}
