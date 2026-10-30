package practice.recursion.fundamentals.binary.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        // return helper(0,nums,target);
        return helperDp(0,nums,target);
    }

    public static int helper(int index,int nums[],int target){
        if(index == nums.length){
            return target == 0  ? 1:0;
        }

        int minus = helper(index+1,nums,target-nums[index]);
        int add = helper(index+1,nums,target+nums[index]);
        return minus + add;
    }


    public static int helperDp(int index1,int nums[],int target){
        int totalSum = Arrays.stream(nums).sum();
        int[] dp = new int[2 * totalSum + 1];

        dp[nums[0]+totalSum]= 1; // supposer nums[0] so we can reach by adding and subsctracting both.
        dp[-nums[0]+totalSum]+=1;

        for(int index=1;index<nums.length;index++){
            int[] next = new int[2*totalSum+1];
            for(int sum=-totalSum;sum<=totalSum;sum++){
                if(dp[sum+totalSum] > 0){
                    next[sum+nums[index]+totalSum] += dp[sum+totalSum];
                    next[sum-nums[index]+totalSum] += dp[sum+totalSum];
                }
            }
            dp = next;
        }

        return Math.abs(target) > totalSum ? 0:dp[target+totalSum];
    }
}
