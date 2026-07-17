package practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{7,7,7}));
        System.out.println(lengthOfLIS(new int[]{1,2,3}));
        System.out.println(lengthOfLIS(new int[]{1,3,2}));
    }

    public static  int lengthOfLIS(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        lst.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num > lst.get(lst.size()-1)){
                lst.add(num);
            }else{
                int j = binarySearch(lst, num);
                lst.set(j,num);
            }
        }

        return lst.size();
    }

    private static int binarySearch(List<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
