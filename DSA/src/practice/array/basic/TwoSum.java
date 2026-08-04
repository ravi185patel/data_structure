package practice.array.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(findTwoSum(new int[]{2,6,5,8,11},14));
        System.out.println(findTwoSum(new int[]{2,6,5,8,11},15));

        System.out.println(findTwoSum1(new int[]{2,6,5,8,11},14));
        System.out.println(findTwoSum1(new int[]{2,6,5,8,11},15));
    }
    public static boolean findTwoSum(int nums[],int target){
        Set<Integer> set = new HashSet<>();
        for(int no:nums){
            int reminder = target-no;
            if(set.contains(reminder)){
               return true;
            }
            set.add(no);
        }
        return false;
    }

    public static boolean findTwoSum1(int nums[],int target){
        Arrays.sort(nums);
        int left =0,right = nums.length-1;
        while(left < right){
            int sum = nums[left]+nums[right];
            if(sum == target){
                return true;
            }
            else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
