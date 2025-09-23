package com.anhao.algorithms;

/**
 * N= 138575789 => 3 number 7
 * <p></p>
 * <a href="https://www.youtube.com/watch?v=ldYLYRNaucM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=9">src</a>
 */

public class CountOccurrence {
    public static void main(String[] args) {
        int n = 45535;

        /*
        * Modulus by 10 will give you the last digit of the number
        * */
        int count = 0;
        while (n > 0) {
            // rem = remainder
            int rem = n % 10;
            if (rem == 5) {
                count++;
            }
            n = n / 10; // n /= 10
        }

        System.out.println("There are "+count+" number 5 in the given number");
    }
}
