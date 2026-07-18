package practice.binarysearch.searchonans;


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
                right=mid - 1;
            }else{
                left = mid + 1;
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
                if(count>k){
                    return false;
                }
            }else{
                sum+=nums[i];
            }
        }
        return true;
    }


    public int splitArray1(int[] nums, int k) {
        return findMinLargestSum(nums,k);
    }

    private int findMinLargestSum(int[]nums,int k){
        int start=findMaxOfArray(nums),end=findSumOfArray(nums);
        System.out.println(start+" >> " +end);
        int ans=Integer.MIN_VALUE;
        while(start <= end){
            int mid = start + (end-start)/2;
            int noOfSplit = finSplit(nums,mid);
            if(noOfSplit > k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return start;
    }

    private int findMaxOfArray(int [] nums){
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            max =  Math.max(max,i);
        }

        return max;
    }

    private int findSumOfArray(int nums[]){
        int sum =0 ;
        for(int i:nums){
            sum+=i;
        }
        return sum;
    }
    private int finSplit(int[]nums,int maxSum){
        int cnt=1,sum=0;
        for(int i:nums){
            if(sum + i > maxSum){
                sum=i;
                cnt++;
            }else{
                sum+=i;
            }
        }

        return cnt;
    }
}
