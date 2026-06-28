package practice.prefixsum;

import common.PrintUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        PrintUtil.print(productExceptSelf(new int[]{1,2,3,4}));
        PrintUtil.print(productExceptSelf(new int[]{-1,1,0,-3,3}));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftMul[]=new int[n+1];
        int rightMul[]=new int[n+1];
        int ans[]=new int[n];
        Arrays.fill(leftMul,1);
        Arrays.fill(rightMul,1);
        for(int i=0;i<nums.length;i++){
            leftMul[i]=(i-1>=0 ? leftMul[i-1]:1)*nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            rightMul[i]= nums[i] * (i+1  < nums.length ? rightMul[i+1]:1);
        }
        PrintUtil.print(leftMul);
        PrintUtil.print(rightMul);
        for(int i=0;i<nums.length;i++){
            int mul = i-1 >= 0 ? leftMul[i-1]:1;
            mul*=i+1 < n ? rightMul[i+1] : 1;
            ans[i]=mul;
        }
        return ans;
    }
}
