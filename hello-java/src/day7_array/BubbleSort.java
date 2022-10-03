package src.day7_array;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[] {4, 7, 3, 5, 1, 10, 2, 9, 6, 8};
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length; i++ ) {
                if (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    isSorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i) {
        int j = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = j;
    }
}
