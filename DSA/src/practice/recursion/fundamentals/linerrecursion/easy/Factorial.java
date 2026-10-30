package practice.recursion.fundamentals.linerrecursion.easy;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(3));
    }

    public static int findFactorial(int n){
        if(n == 1) return n;
        return n* findFactorial(n-1);
    }
}
