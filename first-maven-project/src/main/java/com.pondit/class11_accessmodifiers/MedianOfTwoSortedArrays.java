package com.pondit.class11_accessmodifiers;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    // Solution 1: O(n+m) complexity
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var newArr = new int[nums1.length + nums2.length];
        var k = 0;
        for (int i = 0; i< nums1.length; i++) {
            newArr[k++] = nums1[i];
        }

        for(int i = 0; i< nums2.length; i++) {
            newArr[k++] = nums2[i];
        }

        Arrays.sort(newArr);

        var midPos = newArr.length / 2;
        
        double midResult = 0;
        if (newArr.length % 2 == 0) {
            midResult = ((double)(newArr[midPos - 1] + newArr[midPos]) / 2);
        } else {
            midResult = newArr[midPos];
        }
        return midResult;
    }
}
