package practice.math;

public class FindnCr {
    public static void main(String[] args) {
        System.out.println(findnCr(14,2,7));
    }

    public static int findnCr(int n,int r,int m){

        if( r < 0  || r > n){
            return 0;
        }

        int a = fact(n) % m;
        int b = (fact(r) * fact(n-r)) % m;

        return a * (binaryExponentiation(b,m-2) % m);

    }

    public static int fact(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        return f;
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
