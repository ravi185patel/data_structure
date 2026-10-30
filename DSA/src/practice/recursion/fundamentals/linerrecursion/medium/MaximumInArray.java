package practice.recursion.fundamentals.linerrecursion.medium;

public class MaximumInArray {
    public static void main(String[] args) {
        System.out.println(max(new int[]{1,2,3,4,5},0));
    }

    public static int max(int[] nums, int index) {
        if(nums.length == index) return Integer.MIN_VALUE;
        int max = max(nums,index+1);
        return Math.max(nums[index],max); // return Math.max(nums[index],max(nums,index+1)); // same effect same calls.
    }
}
