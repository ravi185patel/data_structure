package practice.array.basic;

import common.PrintUtil;

/*
1 2 3 4

2 3 4 1
3 4 1 2
 */
public class RotateArrayToLeftOrRightByKPosition {
    public static void main(String[] args) {
        PrintUtil.print(rotateLeft(new int[]{1,2,3,4},3));
        PrintUtil.print(rotateRight(new int[]{1,2,3,4},3));
    }

    public static int[] rotateRight(int nums[],int k){
        int n = nums.length;
        k =  k%n;
        reverse(0,n-1,nums);
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
        return nums;
    }

    public static void reverse(int left,int right,int nums[]){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] rotateLeft(int nums[],int k){
        int n = nums.length;
        k =  k%n;
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
        reverse(0,n-1,nums);
        return nums;
    }
}
