package practice.binarysearch.searchonans;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int start= Arrays.stream(weights).max().getAsInt(),end=Arrays.stream(weights).sum();
        int ans=0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isPossibleToShipInD(weights,days,mid)){
                // max value so within days we can ship so decrease end why because there can be lower weight which can be achieved within days
                ans=mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossibleToShipInD(int weights[],int days,int mid){
        int totalDays=1;
        int totalW=0;
        for(int weight:weights){

            if(totalW+weight > mid){ // important because if it is more than mid, so we can use for next one.
                totalW=weight;
                totalDays++;
            }else{
                totalW+=weight;
            }

        }
        return totalDays <= days; // important
    }


    public static int shipWithinDays1(int[] weights, int days) {  //BF + greedy
        int maxWeight = 0;
        int totalWeight = 0;

        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }

        // Try every possible capacity
        for (int capacity = maxWeight; capacity <= totalWeight; capacity++) {
            if (canShip(weights, days, capacity)) {
                return capacity;
            }
        }

        return totalWeight;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int usedDays = 1;

        for (int w : weights) {
            if (currentLoad + w <= capacity) {
                currentLoad += w;
            } else {
                usedDays++;
                currentLoad = w;
            }
        }

        return usedDays <= days;
    }
}
