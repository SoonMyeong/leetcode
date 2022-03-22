package algorithm.day03._167;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * Example 3:
 *
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 *
 *
 */
public class Solution {

    /**
     *
     * 2중루프 이용 시 무조건 타임오버가 된다.
     * 같은 인덱스를 두번 더하여 합을 뽑아내지 않으며,
     * 다른 두 인덱스의 합이 target 이 된다.
     *
     * 단순히 배열을 단방향의 개념만 생각할 시 뇌가 막히는 상태가 된다.
     * 양방향으로 생각하고, 합과 target 의 관계를 잘 생각해보면 쉽게 해결할 수 있다.
     * numbers 는 오름차순 정렬되어 있으므로
     * 양 끝의 값들의 합이 target 보다 작다면 작은수부터 시작하는 왼쪽 커서를 이동시키고
     * target 보다 클 경우 큰수부터 시작하는 오른쪽 커서를 이동 시킨다.
     *
     * 결국 최대 O(n) 에 target 값을 가진 index 들을 뽑아 낼 수 있다.
     *
     */

    public int[] twoSum(int[] numbers, int target) {
        int from = 0;
        int to = numbers.length-1;

        while(from<to) {
            int sum = numbers[from]+numbers[to];
            if(sum == target) {
                int[] result = new int[2];
                result[0] = ++from;
                result[1] = ++to;
                return result;
            }

            if(sum<target) {
                from++;
            }else {
                to--;
            }

        }
        return null;
    }


    @Test
    void example() {
        int[] nums = {2,7,11,15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }

}
