package practice.binarysearch.searchonans;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
      System.out.println(minEatingSpeed(new int[]{3,6,7,11},8));
      System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},5));
      System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},6));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int  min = Integer.MAX_VALUE;
        int  max = Integer.MIN_VALUE;

        for(int pile:piles){
            min = Math.min(min,pile);
            max = Math.max(max,pile);
        }

//        int maxTimeH=0;
//        for(int k=min;k<=max;k++){
//            if(isPossibleToEatAllBanansInH(piles,k) <= h){
//                return k;
//            }
//        }

        /*

        int maxTimeH=0;
        int start=min,end=max;
        while(start < end){
            int mid = start + (end - start)/2;
            int hours = isPossibleToEatAllBanansInH(piles,mid);
            if(hours <= h){
                maxTimeH = mid;
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;

         */
        int maxTimeH=0;
        int start=min,end=max;
        while(start <= end){
            int mid = start + (end - start)/2;
            int hours = isPossibleToEatAllBanansInH(piles,mid);
            if(hours <= h){
                maxTimeH = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return maxTimeH;
    }

    public static int isPossibleToEatAllBanansInH(int piles[],int k){
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // which is more important when you need
        }
        return hours;
    }
}
