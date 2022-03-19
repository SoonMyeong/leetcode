package algorithm.day01._35;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 *
 *
 *  시간복잡도를 logn 으로 뽑아낼라면 binarysearch 를 이용해면 되는데,
 *  실제 코테 시엔 java 에 있는 Arrays.binarySearch 메서드를 이용하자자 *
 *
 */

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums,target);

        if(idx <0) {
            return Math.abs(idx+1);
        }else {
            return idx;
        }
    }

    @Test
    void example1() {
        int[] nums = {1,3,5,6};
        int target = 7;

        Assertions.assertEquals(searchInsert(nums,target),4);
    }




}
