package com.pondit;

import java.util.Arrays;

public class FirstMissingPositive {

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
