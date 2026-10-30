package practice.recursion.fundamentals.linerrecursion.hard;

public class PowerNOfX {
    public static void main(String[] args) {
        System.out.println(power(2,4));
    }

    public static int power(int x,int n){
        if(n <= 0){
            return 1;
        }
        if(n%2==0){
            return x*x*power(x,n-2);
        }else{
            return x*power(x,n-1);
        }
    }
}
