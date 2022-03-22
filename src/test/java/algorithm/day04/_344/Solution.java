package algorithm.day04._344;


import org.junit.jupiter.api.Test;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 *
 */

public class Solution {


    public void reverseString(char[] s) {
        int from = 0;
        int to = s.length-1;
        while(from<to) {
            swap(s,from++,to--);
        }
        for(char c : s) {
            System.out.print(c +",");
        }
    }

    private void swap(char[] s, int from, int to) {
        char temp = s[from];
        s[from] = s[to];
        s[to] = temp;
    }

    @Test
    void example1() {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
}
