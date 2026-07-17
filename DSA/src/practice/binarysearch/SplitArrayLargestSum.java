package practice.binarysearch;


import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,2,5,10,8},2));
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
        System.out.println(splitArray(new int[]{1,4,4},3));
    }

    public static int splitArray(int nums[],int k){
        Arrays.sort(nums);
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        int ans=0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canSplit(nums,mid,k)){
              ans=mid;
              left = mid + 1;
            }else{
              right=mid - 1;
            }
        }
        return ans;
    }

    public static boolean canSplit(int nums[],int mid,int k){
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] > mid){
                sum=nums[i];
                count++;
            }else{
                sum+=nums[i];
            }
        }
        return count > k;
    }
}
