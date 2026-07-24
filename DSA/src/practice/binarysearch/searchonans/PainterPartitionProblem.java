package practice.binarysearch.searchonans;

import java.util.Arrays;

public class PainterPartitionProblem {
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{5, 10, 30, 20, 15},3));
        System.out.println(minTime(new int[]{15,10,19,10,5,18,7},5));
    }

    public static int minTime(int[] arr, int k) {
        // code here
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();
//        for(int i=left;i<=right;i++){
//            if(isPossible(arr,i,k)){
//                return i;
//            }
//        }
        int ans=-1;
        while(left<=right){
            int mid = left +(right - left)/2;
            if(isPossible(arr,mid,k)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }


    public static boolean isPossible(int[] arr,int mid,int k){
        int count=1;
        int sum=0;
        for(int i:arr){
            if(sum + i > mid){
                sum = i;
                count++;
            }else{
                sum+=i;
            }
            if(count > k){
                return false;
            }
        }
        return count <= k;
    }
}
