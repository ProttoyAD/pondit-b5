package src.day5_solutions;

import java.util.Scanner;

public class StarPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var i = sc.nextInt();

        for (var line = 1; line <= i; line++) {
            for (var k = i - line; k > 0; k--) {
                System.out.print(" ");
            }
            for (var k = 1; k <= line; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
