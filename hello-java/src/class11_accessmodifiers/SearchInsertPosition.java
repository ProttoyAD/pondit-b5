package src.class11_accessmodifiers;

import javax.naming.directory.SearchResult;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));    // 2
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));    // 1
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));    // 4
        System.out.println(searchInsert(new int[]{1,3}, 2));      // 1
        System.out.println(searchInsert(new int[]{5,6}, 2));      // 0
        System.out.println(searchInsert(new int[]{5,6}, 5));      // 0
        System.out.println(searchInsert(new int[]{5,6}, 6));      // 1
        System.out.println(searchInsert(new int[]{5,6}, 9));      // 2
        System.out.println(searchInsert(new int[]{5,6}, 3));      // 0
        System.out.println(searchInsert(new int[]{1, 3, 5}, 4));      // 2
        System.out.println(searchInsert(new int[]{2,3,5,6,9}, 7));      // 4
        System.out.println(searchInsert(new int[]{2,3,5,6,9}, 4));      // 2
        System.out.println(searchInsert(new int[]{5,6}, Integer.MAX_VALUE));  // 2
        System.out.println(searchInsert(new int[]{5,6}, Integer.MIN_VALUE));  // 0
    }

    public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length -1, 0, target);
    }

    private static int searchInsert(int[] nums, int L, int R, int closest, int target) {
        int M = (R+L) / 2;
        if (nums[M] == target) return M;
        if (target <= nums[0]) return 0;
        if (target == nums[R]) return nums.length - 1;
        if (target > nums[R]) return nums.length;
        int diff_L = M - 1;
        int diff_R = M + 1;

        if (diff_L >= 0 && nums[diff_L] < target && target < nums[M]) return M;
        if (diff_L >= 0 && nums[diff_L] == target) return diff_L;
        if (diff_L >= 0 && nums[diff_L] < target && target == nums[M]) return M;

        if (diff_R < nums.length && nums[diff_R] > target && target > nums[M]) return diff_R;
        if (diff_R < nums.length && nums[diff_R] == target) return diff_R;
        if (diff_R < nums.length && nums[diff_R] > target && target == nums[M]) return M;

        if (diff_L >= 0 && diff_R < nums.length && nums[diff_L] < target && nums[diff_R] > target) return M;

        if (target < nums[M]) {
            if (L == diff_L) return L;
            else {
                closest = searchInsert(nums, L, diff_L, closest, target);
            }
        }

        if (target > nums[M]) {
            if (R == diff_R) return R;
            else {
                closest = searchInsert(nums, diff_R, R, closest, target);
            }
        }
        return closest;
    }
}
