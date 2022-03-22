package algorithm.day02._189;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 105
 *
 * 3가지 방법으로 풀어보라는데
 * 한가지는 내가 생각한거
 * 한가지는 discussion 참고한거
 * 한가지는 뭘로함? 생각이 안나는디.. 2가지만 하자
 *
 *
 */
public class Solution {

    private int[] nums = {1,2,3,4,5,6,7};
    private int k = 3;

    /**
     * 내가 생각한 방법
     */
    @Test
    void example1() {
        //결국 사이클 돌고 나머지만큼만 이동할거임
        k = k%nums.length;
        int []temp = new int[k]; //k 개수만큼의 뒤에있던 값들이 앞으로 배치될꺼니까 뒤에꺼 미리 저장해둘 배열
        int n = 0;

        for(int i = nums.length-k; i<nums.length; i++) {
            temp[n] = nums[i];
            n++;
        }

        //기존 배열 뒤로 밀어넣기
        for(int i= nums.length-1-k; i>=0; i--) {
            nums[i+k] = nums[i];
        }

        //temp 에 있는 값들 순서대로 nums 배열 앞에 넣어주기
        for(int i=0; i<temp.length; i++) {
            nums[i] = temp[i];
        }

        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * discussion 참고
     * reverse 한다음에 k 만큼은 reserve, 그다음 나머지 reverse
     *
     * 1)1,2,3,4,5,6,7
     * 2)7,6,5,4,3,2,1
     * 3)5,6,7,4,3,2,1
     * 4)5,6,7,1,2,3,4
     *
     * 가독성 완전좋음... 내가졌다..
     *
     */
    @Test
    void example2() {
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k-1);
        reserve(nums,k,nums.length-1);

        Arrays.stream(nums).forEach(System.out::println);

    }

    public void reserve(int[] nums, int from, int to) {
        while(from<=to) {
            swap(nums,from++,to--);
        }
    }

    public void swap(int[]nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
