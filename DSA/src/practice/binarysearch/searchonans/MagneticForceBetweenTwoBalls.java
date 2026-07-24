package practice.binarysearch.searchonans;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        System.out.println(findMaxDistance(new int[]{1,2,3,4,7},3));
        System.out.println(findMaxDistance(new int[]{7,2,3,4,1},3));
    }

    /*
     7,2,1,4,3  m=3 --> any difference no because i just need place to put to get max difference
     And even order is required still we get ans.
     Ans : no
     why : 7 to 1 to 4 => 6 and 3  => get only 2 count instead of 3.
     solution: ans =2 is right if asked for preserver order. and need to use BF

     1,2,3,4,7  m=3
     max distance
     min = 1 and max = 6 = 7-1
     range = 1 to 6 = 6 to 1
     check for 6 -> posible => ans or check further
     check for 5 ->  posible => ans or check further
     .
     .
     .
     check for 1 ->
     -1
     BF
     O(r*n)

    range max to min -> we can apply bs on it
    1 2 3 4 5 6
    T T T F F F
    l   m     r
        l--> want max
     */
    public static int findMaxDistance(int nums[],int m){
        Arrays.sort(nums);
        int min = nums[0];//Arrays.stream(nums).min().getAsInt();
        int max = nums[1];//Arrays.stream(nums).max().getAsInt();

        int left = min,right=max,ans=-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(isPossible(nums,m,mid)){
                left = mid + 1;
                ans=mid;
            }else{
                right = mid - 1;
            }
        }
        /*for(int i=max;i>=min;i--){
            if(isPossible(nums,m,i)){
                return i;
            }
        }*/
        return ans;
    }

    public static boolean isPossible(int nums[],int m,int mid){
        long count=1;
        long prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(Math.abs(prev-nums[i]) >= mid){
                count++;
                prev=nums[i];
            }
            if(count >=m){
                return true;
            }
        }
        return false;
    }
}
