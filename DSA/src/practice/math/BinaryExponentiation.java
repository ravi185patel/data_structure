package practice.math;

public class BinaryExponentiation {
    public static void main(String[] args) {
        System.out.println(binaryExponentiation(2,4));
        System.out.println(binaryExponentiation(2,3));
    }

    public static int binaryExponentiation(int a, int b){
        if(b  == 0){
            return 1;
        }

        int half = binaryExponentiation(a,b/2);
        int value  = half * half;
        if( b%2 == 1){
            value = value * a;
        }
        return value;
    }
}
