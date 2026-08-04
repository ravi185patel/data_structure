package practice.array.basic;

import common.PrintUtil;

public class MoveAllZeroToTheEndOfArray {
    public static void main(String[] args) {
        PrintUtil.print(moveZeroToEnd(new int[]{0,0,1,2,3,0,0,4}));
    }

    public static int[] moveZeroToEnd(int nums[]){
        int index=0,count=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                continue;
            }
            nums[index]=nums[i];
            index++;
        }
        for(;index<n;index++){
                nums[index]=0;
        }
        return nums;
    }
}
