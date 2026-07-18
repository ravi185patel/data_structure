package practice.binarysearch.searchonans;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
     System.out.println(aggressiveCows(new int[]{1, 2, 4, 8, 9},3));
     System.out.println(aggressiveCows(new int[]{10, 1, 2, 7, 5},3));
    }

    public static int aggressiveCows1(int[] nums, int k) {
        Arrays.sort(nums);

        int low =0,high = nums[nums.length-1]-nums[0];

        while(low < high){
            int mid = (low + high + 1) / 2;
            if(canMake(nums,k,mid)){
                low = mid;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }
    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int low =0,high = nums[nums.length-1]-nums[0];
        while(low < high){
            int mid = low + ( high - low )/2;
            if(canMake(nums,k,mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }

    public static boolean canMake(int [] stalls,int k,int distance){
        int count = 1;
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= distance) {
                count++;
                lastPos = stalls[i]; // to make previous point available to get difference
                if (count == k) return true;
            }
        }

        return false;
    }
}
