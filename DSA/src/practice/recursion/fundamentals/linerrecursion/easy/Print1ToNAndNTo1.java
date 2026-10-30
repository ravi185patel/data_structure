package practice.recursion.fundamentals.linerrecursion.easy;

public class Print1ToNAndNTo1 {
    public static void main(String[] args) {
        print1ToN(10);
        System.out.println();
        printNto1(10);
    }

    public static void print1ToN(int n){
        if(n < 0 ) return;
        print1ToN(n-1);
        System.out.print(n+" ");
    }

    public static void printNto1(int n){
        if(n < 0 ) return;
        System.out.print(n+" ");
        printNto1(n-1);
    }
}
