package com.pondit;

public class MultiDimensionalArray {
    public static void main(String[] args) {

        int[][] x = new int[5][5];
        int counter = 0;
        for (int i = 0; i < x.length; i++) {
            x[i] = new int[x[i].length];
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] = counter++;
            }
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.printf("""
                        (%d, %d) = %d
                        """, i, j, x[i][j]);
            }
            System.out.println();
        }
    }
}
