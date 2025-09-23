package com.anhao.algorithms;

import java.util.Scanner;

/**
 * This program finds the n-th fibonacci number
 *<p>Each number is the sum of the two preceding ones, usually starting with 0 and 1</p>
 * <p></p>
 * <a href="https://www.youtube.com/watch?v=ldYLYRNaucM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=9">src</a>
 */

// TODO: write this using recursion
public class Fibonacci {
    public static void main(String[] args) {
        // enter the n-th number you want to find
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;

        System.out.print("0, 1, ");
        while (count <= n) {
            int temp = b;
            b = b + a;
            a = temp;
            count++;
            System.out.print(b + ", ");
        }
        System.out.println();

        System.out.println("The " + n + "-th fibonacci number: " + b);
    }
}
