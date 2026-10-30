package practice.recursion.fundamentals.binary.medium;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
//        return Math.max(robHouse(0,nums),robHouse(1,nums));
        return robHouseDp(0,nums,new int[nums.length]);
    }

    public static int robHouse(int index,int nums[]){
        if(index >= nums.length){
            return 0;
        }

        int skip = robHouse(index+1,nums);
        int take = nums[index] + robHouse(index+2,nums);
        return Math.max(skip,take);
    }

    public static int robHouse(int index,int nums[],int memo[]){
        if(index >= nums.length){
            return 0;
        }

        if(memo[index] != -1){
            return memo[index];
        }

        int skip = robHouse(index+1,nums,memo);
        int take = nums[index] + robHouse(index+2,nums,memo);
        return memo[index] = Math.max(skip,take);
    }

    public static int robHouseDp(int index,int nums[],int memo[]){
        Arrays.fill(memo,0);
        memo[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int skip = memo[i-1];
            int take = nums[i];
            // [1,2] here i am on 1 , 1 to 0 = 1 cost
            // 1 to -1 = 2 cost now -1 < 0 break >= 0 condition so
            // take = nums[i] cost to reach -1 two jumps. it is edge of jump.
            if(i-2 >= 0){
                take += memo[i-2];
            }
            int current = Math.max(skip,take);
            memo[i]=current;
        }
        return Math.max(memo[nums.length-1],memo[nums.length-2]);
    }
}
