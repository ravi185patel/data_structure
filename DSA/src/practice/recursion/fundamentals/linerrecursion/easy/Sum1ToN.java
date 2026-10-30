package practice.recursion.fundamentals.linerrecursion.easy;

public class Sum1ToN {
    public static void main(String[] args) {
        System.out.println(sum1ToN(3));
    }

    public static int sum1ToN(int n){
        if(n == 0) return 0;
        return n + sum1ToN(n-1);
    }
}
