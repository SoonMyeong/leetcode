package algorithm.day01._704;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * 와.. TC 까지 짤라니 너무귀찮다.. 좀 하다 그냥 평소 하던대로 해야지..
 */
public class Solution {

    public int search(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void example1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int result = search(nums,target);

        Assertions.assertEquals(result,4);
    }

    @Test
    void example2() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int result = search(nums,target);

        Assertions.assertEquals(result,-1);
    }
}
