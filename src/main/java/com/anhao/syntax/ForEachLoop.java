package com.anhao.syntax;

class ForEachLoop {
    public static void main(String[] args) {
        int[] even_numbers = { 2, 4, 6, 8 };

        for(int number : even_numbers) {
            System.out.println(number);
        }
    }
}
