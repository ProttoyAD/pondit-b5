package com.pondit.class11_accessmodifiers;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1}));        // 2
        System.out.println(firstMissingPositive(new int[] {0}));        // 1
        System.out.println(firstMissingPositive(new int[] {-3, -2, -1}));   // 1
        System.out.println(firstMissingPositive(new int[] {1,2,0}));    //3
        System.out.println(firstMissingPositive(new int[] {3,4,-1,1})); // 2
        System.out.println(firstMissingPositive(new int[] {7,8,9,11,12}));  // 1
        System.out.println(firstMissingPositive(new int[] {-1,-2,-60,40,43})); // 1
        System.out.println(firstMissingPositive(new int[] {1,1})); // 2
        System.out.println(firstMissingPositive(new int[] {1000,-1})); // 1
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int prePositiveNumIdx = 0;
        if (nums[nums.length - 1] <= 0) return 1;
        if (nums.length == 1 && nums[0] == 1) return 2;
        if (nums[0] > 1) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (i-1 > -1) {
                if (nums[i-1] > 0 && nums[i] - nums[i-1] > 1) {
                    return nums[i - 1] + 1;
                }
                else if (nums[i-1] <= 0 && (nums[i] - 0) > 1) {
                    return 1;
                }
            }
            prePositiveNumIdx = i;
        }
        return prePositiveNumIdx == 0 ? 1 : nums[prePositiveNumIdx] + 1;
    }
}
