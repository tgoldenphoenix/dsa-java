package com.anhao.basic_syntax;

class Generics {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();

        integerBox.set(1206);
        System.out.println(integerBox.get());
    }
}

class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}