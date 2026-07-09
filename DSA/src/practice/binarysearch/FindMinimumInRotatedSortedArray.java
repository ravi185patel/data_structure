package practice.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,3,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
    public static int findMin(int[] nums) {
        int element=0;
        int start=0,end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){
                start =mid + 1;
            }else{
                end = mid; // possible mid can be ans so we set end = mid because mid-1 gives wrong ans.
            }
        }
        return nums[end];
    }
}
