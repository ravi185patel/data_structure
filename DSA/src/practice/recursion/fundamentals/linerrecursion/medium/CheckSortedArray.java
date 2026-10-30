package practice.recursion.fundamentals.linerrecursion.medium;

public class CheckSortedArray {
    public static void main(String[] args) {
        System.out.println(isArraySorted(0,new int[]{1,2,3,4}));
        System.out.println(isArraySorted(0,new int[]{1,2,5,4}));
        System.out.println(isArraySorted(0,new int[]{5,4,3,1}));
        System.out.println(isArraySorted(0,new int[]{1}));
        System.out.println(isArraySorted(0,new int[]{2,1}));
        System.out.println(isArraySorted(0,new int[]{1,2}));
    }

    public static boolean isArraySorted(int index,int nums[]){
        if(index+1 == nums.length){
            return true;
        }

        if(nums[index] <= nums[index+1]){
            return isArraySorted(index+1,nums);
        }else {
            return false;
        }
    }
}
