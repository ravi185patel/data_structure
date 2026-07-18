package practice.binarysearch;

public class FindPickElement {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,3,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{1,2,3,1}));
        System.out.println(findMin(new int[]{1,10,13,7,6,5,4,2,1,0}));
        System.out.println(findMin(new int[]{1,5,6,4,3,8,7}));

        // here asked for any pick element not like give max pick element.
    }
    public static int findMin(int[] nums) {
        int start=0,end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }
}
