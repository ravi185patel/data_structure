package practice.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimeNumber {
    public static void main(String[] args) {
        System.out.println(primeInGivenRange(6));
        System.out.println(isPrime(2));
        System.out.println(isPrime(4)+" "+isPrimeOpt(4));
    }

    public static List<Integer> primeInGivenRange(int N){
        boolean primeFlag[]=new boolean[N+1];
        Arrays.fill(primeFlag,true);
        for(int i=2;i*i<=N;i++){
            if(primeFlag[i]){
                for(int j=2;i*j <= N;j++){
                    primeFlag[i*j] = false;
                }
            }
        }
        List<Integer> lst = new ArrayList<>();
        for(int i=1;i<N;i++){
            if(primeFlag[i]){
                lst.add(i);
            }
        }
        return lst;
    }

    public static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeOpt(int n){
        for(int i=2;i*i<n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
