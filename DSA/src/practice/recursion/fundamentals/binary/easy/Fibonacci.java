package practice.recursion.fundamentals.binary.easy;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
    }

    public static int fibonacci(int n){
        return helper(n);
    }

    public static int helper(int n){
        if(n <= 1) return n;

        return helper(n-1) + helper(n-2);
    }

}
