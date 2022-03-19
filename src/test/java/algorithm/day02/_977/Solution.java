package algorithm.day02._977;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 *
 *
 *
 */
public class Solution {

    public int[] sortedSquares(int[] nums) {

        List<Integer> list = null;
        list = Arrays.stream(nums)
                .map(n -> n * n)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        int[] result = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    @Test
    void example1() {
        int[] nums = {-4,-1,0,3,10};

        sortedSquares(nums);
    }


}
