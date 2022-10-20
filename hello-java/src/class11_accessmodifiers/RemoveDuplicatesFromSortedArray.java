package src.class11_accessmodifiers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[] {1,1,2}));
    }

    public static int removeDuplicates(int[] nums) {
        int totalNonDuplicateNums = 1, previousNum = nums[0];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > previousNum) {
                totalNonDuplicateNums++;
                previousNum = nums[i];
                nums[k++] = nums[i];
            }
        }
        return totalNonDuplicateNums;
    }
}