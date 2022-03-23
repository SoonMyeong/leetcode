package algorithm.day04._557;


import org.junit.jupiter.api.Test;

/**
 * Given a string s, reverse the order of characters
 * in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 *
 *
 */

public class Solution {

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = s.split(" ");

        for(String str : strs) {
            char[] c = str.toCharArray();
            int from = 0;
            int to = c.length-1;
            reserve(c,from,to);
            stringBuilder.append(c).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        return stringBuilder.toString();
    }

    public void reserve(char[] c, int from, int to) {
        while(from<to) {
            swap(c,from++,to--);
        }
    }

    private void swap(char[] c, int from, int to) {
        char temp = c[from];
        c[from] = c[to];
        c[to] = temp;
    }


    @Test
    void example() {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

}
