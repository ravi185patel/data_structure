package practice.array.basic;

import common.PrintUtil;

import java.util.Arrays;

public class RemoveDuplicatesInPlaceFromSortedArray {
    public static void main(String[] args) {
        PrintUtil.print(removeDuplicateInPlaceArray(new int[]{1,1,2,2,2,3,3}));
    }

    public static int[] removeDuplicateInPlaceArray(int nums[]){
        int index=0;
//        int res[]=new int[nums.length];
//        res[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[index] != nums[i]){
                index++;
                nums[index]=nums[i];
            }
        }
        index++;
        for(;index<nums.length;index++){
            nums[index]=0;
        }
//        return res;
        return nums;
    }
}
