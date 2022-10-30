package com.pondit;

public class MultiDimensionalArray {
    public static void main(String[] args) {

        int[][] x = new int[5][5];
        int counter = 0;
        for (int i = 0; i < x.length; i++) {
            int y[] = new int[x[i].length];
            for (int j = 0; j < x[i].length; j++) {
                y[j] = counter++;
            }
            x[i] = y;
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
