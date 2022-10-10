package src.class11_accessmodifiers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }

    // Two pointers
    public static int maxArea(int[] height) {

        int n = height.length;
        int L = 0, R = n - 1, max = Integer.MIN_VALUE;

        while (L < R) {
            int tempMax = (R - L) * Math.min(height[L], height[R]);
            max = Math.max(max, tempMax);
            if(height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return max;
    }
}
