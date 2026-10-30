package practice.recursion.fundamentals.linerrecursion.easy;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigitRec(0));
        System.out.println(countDigitRec(1));
        System.out.println(countDigitRec(100000000));
    }
    public static int countDigit(int no){
        int count=0;
        while(no > 0){
            count++;
            no=no/10;
        }
        return 10;
    }

    public static int countDigitRec(int no){
        if(no <= 0) return 0;
        return 1 + countDigitRec(no/10);
    }
}
