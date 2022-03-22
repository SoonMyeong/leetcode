package algorithm.day03._283;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 *
 *
 */
public class Solution {

    @Test
    void exmaple1() {
        int[] nums = {0,1,0,3,12};

        int i = 0;
        for(int j=0; j< nums.length; j++) {
            if(nums[j]==0) {
                continue;
            }

            int temp = nums[j];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
        }

        for(int k = i; k<nums.length; k++) {
            nums[k] = 0;
        }

        Arrays.stream(nums).forEach(System.out::println);

    }

}
