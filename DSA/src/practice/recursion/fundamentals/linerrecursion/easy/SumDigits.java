package practice.recursion.fundamentals.linerrecursion.easy;

public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumDigit(0));
        System.out.println(sumDigit(10));
        System.out.println(sumDigit(111));
        System.out.println(sumDigit(123456789));
    }

    public static int sumDigit(int no){
        if(no <= 0) return 0;
        return no%10 + sumDigit(no/10);
    }
}
