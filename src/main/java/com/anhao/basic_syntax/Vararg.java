package com.anhao.basic_syntax;

/*
Varargs = variable arguments
- Avoid overloading many times

No need to pass an already initialized array as argument, just pass them normally
```
int[] params = {1, 2, 3, 4, 5};
sum(params); // 15
```
*/

class Vararg {
    public static void main(String[] args) {
        System.out.println("Sum: " + sum(1, 2));
    }

    public static int sum(int... args) {
        int result = 0;
        for (int i=0; i<args.length; i++)
            result += args[i];
        return result;
    }
}

/*
Notes:
- Varargs must be the last argument
- One method can only have one varargs
*/