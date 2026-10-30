package practice.recursion.fundamentals.binary.hard;

import java.util.Arrays;

public class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {
        System.out.println(countGoodStrings(3,3,1,1));
        System.out.println(countGoodStrings(2,3,1,2));
    }
    private static final int MOD = 1_000_000_007;

    public static int countGoodStrings(int low, int high, int zero, int one) {
//        return count(0,low,high,zero,one);
        int memo[]=new int[high+1];
        Arrays.fill(memo,-1);
//        return count(0,low,high,zero,one,memo);
        return countDp(0,low,high,zero,one,memo);
    }

    public static int count(int len,int low,int high,int zero,int one){
        if(len > high) return 0;
        int count=0;
        if(low <= len && high >= len){
            count=1;
        }

        int addZero = count(len+zero,low,high,zero,one)%MOD;
        int addOne = count(len+one,low,high,zero,one)%MOD;
        return (count+ addZero + addOne) %MOD;
    }

    public static int count(int len,int low,int high,int zero,int one,int memo[]){
        if(len > high) return 0;
        if(memo[len] != -1){
            return memo[len];
        }
        int count=0;
        if(low <= len && high >= len){
            count=1;
        }

        int addZero = count(len+zero,low,high,zero,one,memo)%MOD;
        int addOne = count(len+one,low,high,zero,one,memo)%MOD;
        return memo[len] = (count+ addZero + addOne) %MOD;
    }

    public static int countDp(int len,int low,int high,int zero,int one,int memo[]){
        Arrays.fill(memo,0);
        memo[0]=1;
        int res=0;
        for(int i=1;i<=high;i++){
            if(i >= zero) memo[i] = (memo[i] + memo[i-zero])%MOD;
            if(i >= one) memo[i] = (memo[i] + memo[i-one])%MOD;
            if(i >= low) res = (res + memo[i])%MOD;
            System.out.println(Arrays.toString(memo));
        }
        return res;
    }
}
