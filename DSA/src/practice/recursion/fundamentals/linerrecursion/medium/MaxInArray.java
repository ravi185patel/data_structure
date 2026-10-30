package practice.recursion.fundamentals.linerrecursion.medium;

public class MaxInArray {
    public static void main(String[] args) {
        System.out.println(findMaxInArray(new int[]{1,2,3,4,5}));
    }

    public static int findMaxInArray(int nums[]){
        return helper(0,nums.length-1,nums);
    }

    public static int helper(int l,int r,int nums[]){
        if(l == r) return nums[l];
        int mid = l + ( r - l)/2;
        int lMax = helper(l,mid,nums);
        int rMax = helper(mid+1,r,nums);
        return Math.max(lMax,rMax);
    }
}
