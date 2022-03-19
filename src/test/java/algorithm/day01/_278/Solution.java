package algorithm.day01._278;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 231 - 1
 *
 * 이 문제는 leetcode ide 에서 풀기
 * 이 문제에서 묻고자 하는건 bad version 을 찾기 위해 이진트리로 찾아보라는 식의 문제였다.
 * 단순히 자바에 내장된 binarySearch 를 이용하는 게 아닌 구현하는 문제
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution {

    public int firstBadVersion(int n) {
        int firstIdx = 1;
        int lastIdx = n;

        while(firstIdx + 1 < lastIdx) {
            int midIdx = firstIdx + ((lastIdx - firstIdx) / 2);
            if(isBadVersion(midIdx)) {
                lastIdx = midIdx;
            }else {
                firstIdx = midIdx;
            }
        }

        return isBadVersion(firstIdx) ? firstIdx : lastIdx;
    }

    private boolean isBadVersion(int idx) {
        if(idx == 3) { // TC 1에 있는 bad value 4 를 만족할라면 version 3 부터 잘못된 버전일 경우 bad value 4 가 첫번째 에러 버전이다.
            return false;
        } else {
            return true;
        }
    }

    @Test
    void example1_bad_value_4() {
        int n = 5;
        Assertions.assertEquals(firstBadVersion(n),4);
    }



}
